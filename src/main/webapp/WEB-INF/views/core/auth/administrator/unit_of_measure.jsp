<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>MPXD Data Capture System</title>
		<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/fav.ico" />
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/theme/theme.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/forms-theme.css">
	</head>
	<body class="sb-top sb-top-sm">
	  <!-- Start: Main -->
	  <div id="main">
		<jsp:include page="../../../fragments/header.jsp"></jsp:include>
		<jsp:include page="../../../fragments/menu.jsp"></jsp:include>
	    <!-- Start: Content-Wrapper -->
	    <section id="content_wrapper">
	      <!-- Start: Topbar -->
	      <header id="topbar">
	        <div class="topbar-left">
	          <ol class="breadcrumb">
	            <li class="crumb-icon">
	              <a href='<spring:url value="/dashboard"/>'>
	                <span class="glyphicon glyphicon-home"></span>
	              </a>
	            </li>
	            <li class="crumb-trail">Administrator</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/manage/unit-measure/"/>'><spring:message code="uom.title"/></a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted"><spring:message code="uom.title"/></label>
	          </div>
	        </div>
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
	
	        <div class="row">
		       	<c:if test="${ not empty error}">
		        	<div class="col-md-12">	
						<div class="section animated fadeIn">
							<div class="alert alert-danger alert-dismissable mt10">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
								<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>	
									<span>${error}</span>
							</div>
						</div>
					</div>        
		        </c:if>
		        <c:if test="${ not empty message}">
		        	<div class="col-md-12">	
						<div class="section animated fadeIn">
							<div class="alert alert-success alert-dismissable mt10">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
								<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>	
									<span>${message}</span>
							</div>
						</div>
					</div>	        
		        </c:if>	
		        <div class="col-md-12">
	        	 	<div class="panel panel-visible bt-red" id="spy1">
	        	 		<div class="panel-body">
	        	 			<div class="col-xs-12 col-sm-9 col-md-9">
                                 <div class="forum-icon">
                                     <i class="glyphicon glyphicon-check"></i>
                                  </div>
                                  <span class="forum-item-title"><spring:message code="uom.title"/></span>
                                  <div class="forum-sub-title">Manage <spring:message code="uom.title"/>.</div>
                             </div>
                             <div class="col-xs-12 col-sm-3 col-md-3">	        	     
	        	           		<a href="#" data-toggle="modal" data-target="#uomModal" class="btn btn-default br3 fw600 pull-right"><span class="fa fa-plus"></span> <spring:message code="uom.add"/> </a>
	        	           	</div>	
	        	 		</div>
	        	 	</div>
		        </div>
	          <div class="col-md-12">
	             <div class="panel panel-visible bt-blue" id="spy1"> 
	                <div class="panel-body">
		                <spring:url value="/manage/unit-measure" var="url"/>
		                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
		                    <thead>
		                      <tr>
		                        <th width="5%">#</th>
		                        <th>UOM Name</th>
		                        <th>Description</th>
		                        <th width="5%">Edit</th>
		                        <th width="5%">Delete</th>
		                      </tr>
		                    </thead>
		                    <tbody>
			                    <c:if test="${fn:length(unitList) gt 0}">
				                    <c:forEach items="${unitList}" var="unit" varStatus="counter">
				                      <tr>
				                        <td>${counter.index+1}</td>
				                        <td class="t-t-capt">${unit.uomLabel}</td>           
				                        <td class="t-t-capt">${unit.uomDesc}</td>
				                        <c:set var="rand" value="${100+random.nextInt(1000-(100+1))}"/>
				                        <td><a href="${url}/${fn:replace(fn:replace(fn:replace(fn:toLowerCase(unit.uomLabel),'/','||'),'-','&&'),' ', '-')}"><span class="glyphicon glyphicon-edit"></span></a></td>
				                        <td><a class="dr-confirm no-loader" data-content= "This will remove <b><code>${unit.uomLabel}</code></b> permanantly .Continue deleting?" data-title="Delete Unit of Measure" href="<spring:url value="/manage/unit-measure/delete"/>/${rand}${unit.uomId}"><span class="glyphicon glyphicon-trash"></span></a></td>
				                      </tr>  
				                      </c:forEach>	
			                      </c:if>	                      		                      
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
	<!-- Model -->
	 <div class="modal fade" id="uomModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header gradient-1">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel"><span class="glyphicon glyphicon-education"></span><span class="head_text"> <spring:message code="uom.new.modal.head.title" /> </span></h4>
		      </div>
		      <div class="modal-body pt0 gradient-2-modal-body">
					<div class="mpxd theme-primary mw1000 center-block">
					<spring:url value="/manage/unit-measure/" var="url"/>
						<form:form method="post" action="${url}" id="role-form" modelAttribute="unit">
							<div class="panel-body pt0">
								<div class="section-divider mv40" id="spy4">
									<span class="desc_text"><spring:message code="uom.new.info"/></span>
								</div>
								<!-- .section-divider -->
								<div class="section">
									<span class="field-alt fw600">
										Unit Name <span class="ico-help" title="Unit of Measure Name"><i class="fa fa-question-circle"></i></span>
									</span>	
									<label for="uomLabel" class="field prepend-icon"> 
										<form:input path="uomLabel"  id="uomLabel" class="gui-input br5" placeholder="New Unit Name"/>
											<label for="uomLabel" class="field-icon"> 
												<i class="glyphicon glyphicon-education"></i>
											</label>
									</label>
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Description <span class="ico-help" title="Brief about the Unit of Measure"><i class="fa fa-question-circle"></i></span>
									</span>	
									 <label for="uomDesc" class="field prepend-icon"> 
										<form:textarea path="uomDesc" id="uomDesc" class="gui-input br5" placeholder="Unit Description" style="height:130px;"/>
											<label for="uomDesc" class="field-icon"> 
												<i class="glyphicon glyphicon-education"></i>
											</label>
									</label>	                           								
								</div>
							</div>
							<!-- end .form-body section -->
							<div class="panel-footer text-right">
							<form:button id="add_new_unit" class="button btn-primary br3"><i class="fa fa-check"></i> <span class="btn-text">Add Unit</span></form:button>
								<button type="reset" data-dismiss="modal" class="button br3">
									<i class="fa fa-close"></i> Cancel
							   </button>
							</div>
							<!-- end .form-footer section -->
						</form:form>
					</div>
				</div>
		    </div>
		  </div>
		</div>	
	  <!-- BEGIN: PAGE SCRIPTS -->	
	  <!-- jQuery -->
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery2.2.4.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-ui.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/util.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/dataTables/jquery.dataTables.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>