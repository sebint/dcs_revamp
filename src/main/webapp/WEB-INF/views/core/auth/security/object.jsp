<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>MPXD Data Capture System</title>
		<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/fav.ico" />
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<link rel="stylesheet" type="text/css" href="<spring:url value='../../resources/css/theme/theme.css'/>">
		<link rel="stylesheet" type="text/css" href="<spring:url value='../../resources/css/forms-theme.css'/>">
	</head>
	<body class="sb-top sb-top-sm">
	  <!-- Start: Main -->
	  <div id="main">
		<jsp:include page="../../../fragments/header.jsp"></jsp:include>
		<jsp:include page="../../../fragments/menu.jsp"></jsp:include>
	    <!-- Start: Content-Wrapper -->
	    <section id="content_wrapper">
	
	      <!-- Start: Topbar-Dropdown -->
	     <div id="topbar-dropmenu">
	        <div class="topbar-menu row">
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-inbox"></span>
	              <p class="metro-title">Messages</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-user"></span>
	              <p class="metro-title">Users</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-headphones"></span>
	              <p class="metro-title">Support</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon fa fa-gears"></span>
	              <p class="metro-title">Settings</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-facetime-video"></span>
	              <p class="metro-title">Videos</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-picture"></span>
	              <p class="metro-title">Pictures</p>
	            </a>
	          </div>
	        </div>
	      </div>
	      <!-- End: Topbar-Dropdown -->
	
	      <!-- Start: Topbar -->
	      <header id="topbar">
	        <div class="topbar-left">
	          <ol class="breadcrumb">
	            <li class="crumb-icon">
	              <a href='<spring:url value="/dashboard"/>'>
	                <span class="glyphicon glyphicon-home"></span>
	              </a>
	            </li>
	            <li class="crumb-trail">Security</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/security/object/"/>'>Object</a>
	            </li>
	          </ol>
	        </div>
<!-- 	        <div class="topbar-right mt-5"> -->
<!-- 	          <div class="ib topbar-dropdown"> -->
<!-- 	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Object</label> -->
<!-- 	          </div> -->
<!-- 	        </div> -->
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
	        <div class="row">
	        	<div class="col-md-12">
	        	 	<div class="panel panel-visible bt-green" id="spy1">
	        	 		<div class="panel-body">
	        	 			<div class="col-md-9">
                                 <div class="forum-icon">
                                     <i class="fa fa-users"></i>
                                  </div>
                                  <span class="forum-item-title">Manage Object</span>
                                  <div class="forum-sub-title">Edit existing Object.</div>
                             </div>
                            
	        	 		</div>
	        	 	</div>
	        	</div>
	          <div class="col-md-12">
              <div class="panel panel-visible bt-yellow" id="spy1">
<!--                 <div class="panel-heading"> -->
<!--                   <div class="panel-title hidden-xs"> -->
<%--                     <span class="glyphicon glyphicon-tasks"></span>Basic Datatable</div> --%>
<!--                 </div> -->
                <div class="panel-body">
                <spring:url value="/security/object/update" var="url"/>
                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
                    <thead>
                      <tr>
                        <th>No</th>
                        <th>Group</th>
                        <th>Object Name</th>
                        <th>Type</th>
                        <th>Edit</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${lstMenuSub}" var="menu" varStatus="counter">  
                      <tr>
                        <td>${counter.index+1}</td>
                        <td>${menu.strMenuName}</td>
                        <td>${strMenuSubLabel}</td>
                        <c:choose>
                        	<c:when test="${boolSubIsScreenType==true}">
                        		<td>Screen</td>
                        	</c:when>
                        	<c:otherwise>
                        		<td>Report</td>
                        	</c:otherwise>
                        </c:choose>                
                        <td><input type="hidden" name="sr-prop" class="sr-info" value='{"intMenuMasterId":"${intMenuMasterId}","strMenuSubLabel":"${strMenuSubLabel}","boolSubIsScreenType":"${boolSubIsScreenType}"}'/><a href="#" class="sr-update" data-action="${url}/${intMenuSubId}" data-toggle="modal" data-target=".object_modal"><span class="glyphicon glyphicon-edit"></span></a></td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
	          </div>
	        </div>
	      </section>
	      <!-- End: Content -->
	
	    </section>
			<jsp:include page="../../../fragments/footer.jsp"></jsp:include>
	  </div>
	  <!-- End: Main -->
			<div class="modal fade object_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header gradient-2">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel">Update Object</h4>
		      </div>
		      <div class="modal-body pt0 gradient-2-modal-body">
							<div class="mpxd theme-primary mw1000 center-block">
								<s:form method="post" action="object/update" namespace="/security" id="object-form">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text">Update</span>
										</div>
										<!-- .section-divider -->
										<span class="field-alt fw600">
											Group <div class="ico-help" title="Select the group name."><i class="fa fa-question-circle"></i></div>
										</span>	
										<div class="section">
											 <label class="field select">
											  <s:select key="intMenuMasterId" id="intMenuMasterId"
													headerKey="-1" headerValue="Select Group"
														list="lstMenu" listKey="intMenuMasterId" 
											       			listValue="strMenuName" /> 
												<i class="arrow double"></i>
											</label>	                           								
										</div>
										<span class="field-alt fw600">
											Object Name <div class="ico-help" title="Select the group name."><i class="fa fa-question-circle"></i></div>
										</span>	
										<div class="section">
											<label for="password" class="field prepend-icon"> 
											 <s:textfield name="strMenuSubLabel" id="strMenuSubLabel" cssClass="gui-input br5" placeholder="Object Name"></s:textfield>
													<label for="strRoleName" class="field-icon"> 
														<i class="glyphicon glyphicon-pencil"></i>
													</label>
											</label>
										</div>
										<span class="field-alt fw600">
											Type <div class="ico-help" title="Select the type of the object(Screen or Report)."><i class="fa fa-question-circle"></i></div>
										</span>	
										<div class="section">
											 <label class="field select">
											 <select name="boolSubIsScreenType" id="boolSubIsScreenType">
   													 <option value="-1">Select Type</option>
   													 <option value="true">Screen</option>
   													 <option value="false">Report</option>
											</select>
												<i class="arrow double"></i>
											</label>	                           								
										</div>
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<s:submit type="button" cssClass="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Update</span></s:submit>
										<button type="reset" data-dismiss="modal" class="button br3">
											<i class="fa fa-close"></i> Cancel
									   </button>
									</div>
									<!-- end .form-footer section -->
								</s:form>
							</div>
						</div>
		    </div>
		  </div>
		</div>	
	  <!-- BEGIN: PAGE SCRIPTS -->	
	  <!-- jQuery -->
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery/jquery2.2.4.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery/jquery-ui.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/util.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/dataTables/jquery.dataTables.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/_sn.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/pages/object.js'/>"></script>
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>