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
	            <li class="crumb-trail">Design</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/design/non-progressive/"/>'>Non-Progressive Journal</a>
	            </li>
	            <li class="crumb-link">
	            	<a class="t-t-capt" href='<spring:url value="/design/non-progressive/${!empty(journalName)? journalName :  'new'}"/>'>${!empty(journalName)? (fn:replace(fn:toLowerCase(journalName),'-', ' ')) :  'New'}</a>
	            </li>
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
	            <div class="panel panel-visible" id="spy1">
                	<div class="panel-body">
	                       	<c:choose>
	                			<c:when test="${!empty(journalName)}">
	                				<spring:url value="/design/non-progressive/${journalName}" var="url_alt"/>
	                			</c:when>
	                			<c:otherwise>
	                				<spring:url value="/design/non-progressive/new" var="url_alt"/>
	                			</c:otherwise>
	                		</c:choose>
							<div class="mpxd theme-primary mw1000 center-block">
								<form:form method="post" action="${url_alt}" id="user-form" modelAttribute="nonprogressive">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> <spring:message code="npj.new.info"/> </span>
										</div>
										<!-- .section-divider -->
										<div class="col-md-6">
											<spring:bind path="projectMasterId">
											   <c:if test="${status.error}">
											   		<span class="field-error ${projectMasterId.error}" >
													<form:errors path="projectMasterId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
											   		<span class="field-alt fw600">
														<spring:message code="npj.new.projectname"/> <span class="text-danger">*</span> <div class="ico-help" title="Select the Project Name."><i class="fa fa-question-circle"></i></div>
													</span>	
											   </c:if>								
												<div class="section">												
													<label class="field select">
														<form:select path="projectMasterId">
						                          			<form:option value="" label="Please Select" selected="selected"/>
						                          			<form:options items="${projectList}" itemValue="projectMasterId" itemLabel="projectName" />
						                          		</form:select> 	
						                          		<i class="arrow double"></i>																							
													</label>
												</div>
											</spring:bind>	
										</div>
										<form:hidden path="nonProgressiveMasterId"/>
										<div class="col-md-6">																		 
											<spring:bind path="journalName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="journalName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.journalname"/> <div class="ico-help" title="Name your new Journal."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="journalName" class="field prepend-icon"> 
													   <form:input path="journalName" id="journalName" cssClass="gui-input br5" placeholder="Journal Name"></form:input>
															<label for="journalName" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>
										</div>
										<!-- <div class="col-md-12">		 -->
										<div class="col-md-6">																				 
											<spring:bind path="jounralOwner">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="jounralOwner" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.owner"/> <div class="ico-help" title="Select the Journal Owner."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
											<div class="section">
												<label class="field select">
													<form:select path="jounralOwner">
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
											<spring:bind path="validatorId">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="validatorId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.validator"/> <div class="ico-help" title="Select the Validator."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
						                          <label class="field select">
													<form:select path="validatorId">
					                          			<form:option value="" label="Please Select" selected="selected"/>
					                          			<form:options items="${userList}" itemValue="intUserId" itemLabel="strUserName"/>
					                          		</form:select> 
					                          		<i class="arrow double"></i>
						                          </label>				                          
						                        </div>
					                        </spring:bind>
											<!-- end section -->
										</div>
										<spring:bind path="dataEntryId">
											<div class="${!optn ? 'col-md-6' : 'col-md-12'}">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="dataEntryId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.dataentryuser"/> <div class="ico-help" title="Selec the Data Entry."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
													<label class="field select">
														<form:select path="dataEntryId">
						                          			<form:option value="" label="Please Select" selected="selected"/>
						                          			<form:options items="${userList}" itemValue="intUserId" itemLabel="strUserName"/>
						                          		</form:select> 
						                          		<i class="arrow double"></i>
													</label>													
												</div>											
											</div>
										</spring:bind>
										<!-- end section -->
										<spring:bind path="reminderFreq">
										<c:if test="${!optn}">
											<div class="col-md-6">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="reminderFreq" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.reminderfrequency"/> <div class="ico-help" title="Select the reminder Frequency."><i class="fa fa-question-circle"></i></div>
												</span>
											   </c:if>	
												<div class="section">
													<label class="field select">
														<form:select path="reminderFreq">
						                          			<form:option value="" label="Please Select" selected="selected"/>
						                          			<form:options items="${frequencyList}" itemValue="frequencyMasterId" itemLabel="frequencyName"/>
						                          		</form:select> 
						                          		<i class="arrow double"></i>
													</label>													
												</div>									
										<!-- end section -->
											</div>
											</c:if>
										</spring:bind>	
										<!-- end section -->
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" name="mode" value="save" class="button btn-success br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save</span></button>
										<button type="submit" name="mode" value="save_continue" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save and Continue</span></button>
										<a href="<spring:url value="/security/user/"/>" class="button br3">
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/user.js"></script>	  
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>