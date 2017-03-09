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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.full.min.css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/handsontable/pikaday/pikaday.css"></link>
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
	            <li class="crumb-trail">Design</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/design/non-progressive/"/>'>Non-Progressive Journal</a>
	            </li>
	            <li class="crumb-link">
	              <a class="t-t-capt" href='<spring:url value="/design/non-progressive/${journalUrl}"/>'>${fn:replace(journalName,'-',' ')}</a>
	            </li>
	             <li class="crumb-trail">Design</li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Non-Progressive Journal</label>
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
	        	 	<div class="panel panel-visible bt-gray" id="spy1">
	        	 		<div class="panel-body">
	        	 			<div class="col-xs-12 col-sm-9 col-md-9">
                                 <div class="forum-icon">
                                     <i class="glyphicon glyphicon-equalizer"></i>
                                  </div>
                                  <span class="forum-item-title"><span class="t-t-capt">${fn:replace(journalName,'-',' ')}</span></span>
                                  <div class="forum-sub-title">Design  <span class="t-t-capt">${fn:replace(journalName,'-',' ')}</span></div>
                             </div>
                             <div class="col-xs-12 col-sm-3 col-md-3">	        	     
	        	           		<a href="#" data-toggle="modal" data-target=".column_modal" class="btn btn-warning br3 fw600 pull-right"><span class="fa fa-plus"></span> <spring:message code="npj.dsign.row.add"/> </a>
	        	           	</div>	
	        	 		</div>
	        	 	</div>
	        </div>
	          <div class="col-md-12">
	             <div class="panel panel-visible bt-blue" id="spy1"> 
	                <div class="panel-body">
	               		<div class="row">
	               			<div class="col-md-12">
								<div id="scroll_container" style="overflow:hidden;">
									<div id="hottable_container" style="margin-bottom:15px"></div>									
								</div>
							</div>
						</div>
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
	 <div class="modal fade column_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header gradient-2">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel"><span class="glyphicon glyphicon-education"></span><span class="head_text"> New Role</span></h4>
		      </div>
		      <div class="modal-body pt0 gradient-2-modal-body">
					<div class="mpxd theme-primary mw1000 center-block">
						<form method="post" action="#" id="role-form">
							<div class="panel-body pt0">
								<div class="section-divider mv40" id="spy4">
									<span class="desc_text">Provide the following information to add new column</span>
								</div>
								<!-- .section-divider -->
								<div class="section">
									<span class="field-alt fw600">
										Column Title <div class="ico-help" title="New Role Name"><i class="fa fa-question-circle"></i></div>
									</span>	
									<label for="strRoleName" class="field prepend-icon"> 
									   <input name="strRoleName" id="strRoleName" class="gui-input br5" placeholder="New Role"/>
											<label for="strRoleName" class="field-icon"> 
												<i class="glyphicon glyphicon-education"></i>
											</label>
									</label>
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Column Type <div class="ico-help" title="Home page for this role."><i class="fa fa-question-circle"></i></div>
									</span>	
									 <label class="field select">
									 <select name="intRoleHome">
									 		<option value="" label="Please Select" selected="selected"/>
									 </select>
										<i class="arrow double"></i>
									</label>	                           								
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Unit of Measurement <div class="ico-help" title="Home page for this role."><i class="fa fa-question-circle"></i></div>
									</span>	
									 <label class="field select">
									 <select name="sdsf">
									 		<option value="" label="Please Select" selected="selected"/>
									 </select>
										<i class="arrow double"></i>
									</label>	                           								
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Read only
									</span>	
									<label class="checkbox-inline mr10">
									  	<input type="checkbox" id="inlineCheckbox1" value="option1" >
									</label>                           								
								</div>
							</div>
							<!-- end .form-body section -->
							<div class="panel-footer text-right">
								<button id="add_new_column" type="button" class="button btn-primary br3"><i class="fa fa-check"></i> 
									<span class="btn-text">Add Column</span></button>
								<button type="reset" data-dismiss="modal" class="button br3">
									<i class="fa fa-close"></i> Cancel
							   </button>
							</div>
							<!-- end .form-footer section -->
						</form>
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.full.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/moment/moment.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/pikaday/pikaday.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery.json.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/rulejs/ruleJS.all.full.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.formula.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/ilyas.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>