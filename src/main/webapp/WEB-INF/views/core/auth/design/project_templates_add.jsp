<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	            <li class="crumb-trail">Design</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/design/templates/"/>'>Project Templates</a>
	            </li>
	            <li class="crumb-link">
	              <a class="t-t-capt" href='<spring:url value="/design/templates/${!empty(projectName)? projectName :  'new'}"/>'>${!empty(projectName)? (fn:replace(fn:toLowerCase(projectName),'-', ' ')) :  'New'}</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	             <label for="topbar-multiple" class="control-label pr10 fs20 text-muted"><spring:message code="prj.new.header"/></label>
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
	            <div class="panel panel-visible" id="spy1">
                	<div class="panel-body">
                	 		<c:choose>
	                			<c:when test="${!empty(projectName)}">
	                				<spring:url value="/security/user/${projectName}" var="url_alt"/>
	                			</c:when>
	                			<c:otherwise>
	                				<spring:url value="/security/user/new" var="url_alt"/>
	                			</c:otherwise>
	                		</c:choose>
							<div class="mpxd theme-primary mw1000 center-block">
								<form:form method="post" action="${url_alt}" id="project-form" modelAttribute="project">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> <spring:message code="prj.new.info"/> </span>
										</div>
										<form:hidden path="projectMasterId" />					
										<!-- .section-divider -->
										<div class="col-md-6">
											<spring:bind path="projectName">
											   <c:if test="${status.error}">
											   		<span class="field-error" >
														<form:errors path="projectName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
											   		<span class="field-alt fw600">
														<spring:message code="npj.new.projectname"/> <span class="text-danger">*</span> <span class="ico-help" title="New Project Name"><i class="fa fa-question-circle"></i></span>
													</span>	
											   </c:if>								
												<div class="section">												
													<label for="projectName" class="field prepend-icon"> 
													   <form:input path="projectName" id="projectName" cssClass="gui-input br5" placeholder="Project Name"></form:input>
															<label for="projectName" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>	
										</div>
										<div class="col-md-6">																		 
											<spring:bind path="projectDesc">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="projectDesc" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="prj.new.desc"/> <span class="ico-help" title="Description of your project"><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="projectDesc" class="field prepend-icon"> 
													   <form:input path="projectDesc" id="projectDesc" cssClass="gui-input br5" placeholder="Description"></form:input>
															<label for="projectDesc" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>
										</div>
										<!-- <div class="col-md-12">		 -->
										<div class="col-md-6">																				 
											<spring:bind path="userMasterId">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="userMasterId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.owner"/> <span class="ico-help" title="Select the Project Owner."><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
											<div class="section">
												<label class="field select">
													<form:select path="userMasterId">
					                          			<form:option value="" label="Please Select" selected="selected"/>
					                          			<form:options items="${userList}" itemValue="intUserId" itemLabel="strUserName"/> 
					                          		</form:select> 
					                          		<i class="arrow double"></i>
												</label>										
											</div>
											</spring:bind>
										</div>
										<!-- end section -->
										<div class="col-md-6">
											<spring:bind path="startDate">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="startDate" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="prj.new.startdate"/> <span class="ico-help" title="Date of the Project Begins"><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="startDate" class="field prepend-icon"> 
													   <form:input path="startDate" id="startDate" cssClass="gui-input br5 datepicker theme-primary" readonly="readonly" placeholder="Start Date"></form:input>
									                          <label class="field-icon">
									                            <i class="fa fa-calendar-o"></i>
									                          </label>
													</label>			                          
						                        </div>
					                        </spring:bind>
											<!-- end section -->
										</div>
										<spring:bind path="endDate">
											<div class="col-md-6">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="endDate" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="prj.new.enddate"/> <span class="ico-help" title="Date of Project completetion"><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="endDate" class="field prepend-icon"> 
													   <form:input path="endDate" id="endDate" cssClass="gui-input br5 datepicker" readonly="readonly" placeholder="End Date"></form:input>
															<label for="endDate" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>													
												</div>											
											</div>
										</spring:bind>
										<!-- end section -->
										<!-- end section -->
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" name="mode" value="save" class="button btn-success br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save</span></button>
										<button type="submit" name="mode" value="save_continue" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save and Continue</span></button>
										<a href="<spring:url value="/design/templates/"/>" class="button br3">
											<i class="fa fa-close"></i> Cancel
									   </a>
									</div>
									<!-- end .form-footer section -->
								</form:form>
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
	  <!-- BEGIN: PAGE SCRIPTS -->	
	  <!-- jQuery -->
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery2.2.4.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-ui.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/util.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/dataTables/jquery.dataTables.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery-ui-datepicker/jquery-ui-datepicker.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/user.js"></script>	  
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	    $(".datepicker").datepicker({
	    	dateFormat : "dd-mm-yy",
		 	prevText: '<i class="fa fa-chevron-left"></i>',
	        nextText: '<i class="fa fa-chevron-right"></i>',
	        showButtonPanel: false,
	        beforeShow: function(input, inst) {
	          var newclass = 'admin-form';
	          var themeClass = $(this).parents('.admin-form').attr('class');
	          var smartpikr = inst.dpDiv.parent();
	          if (!smartpikr.hasClass(themeClass)) {
	            inst.dpDiv.wrap('<div class="' + themeClass + '"></div>');
	          }
	        }
	      });
	  </script>
	</body>
</html>