<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
	            <li class="crumb-trail">Security</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/security/password-changes"/>'>Change Password</a>
	            </li>
	          </ol>
	        </div>
<!-- 	        <div class="topbar-right mt-5"> -->
<!-- 	          <div class="ib topbar-dropdown"> -->
<!-- 	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Change Password</label> -->
<!-- 	          </div> -->
<!-- 	        </div> -->
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
	        	 	<div class="panel panel-visible bt-green" id="spy1">
	        	 		<div class="panel-body">
                                 <div class="forum-icon">
                                     <span class="fa fa-lock"></span>
                                  </div>
                                  <span class="forum-item-title">Change Password</span>
                                  <div class="forum-sub-title">Change your account password.</div>
	        	 		</div>
	        	 	</div>
	        	</div>
	          <div class="col-md-12">
	            <div class="panel bt-blue">
	                <div class="panel-body ">
	                	<div class="mpxd theme-primary mw1000 center-block">
	                	<spring:url value="/security/user/account/password-change" var="url"/>
			                <form:form method="post" action="${url}" modelAttribute="reset" id="password-change-form">
			                  <div class="panel-body p0">
			                  <security:authentication property="principal.userId" var="a_uid"/>
			                  <form:hidden path="intUserId" value="${a_uid}"/>
			                    <div class="section-divider mv40" id="spy4">
			                      <span> Provide the following information to change Password </span>
			                    </div>
			                    <!-- .section-divider -->
			                     <div class="col-md-12">
			                     	<spring:bind path="strExPassword">
									   <c:if test="${status.error}">
									   		<span class="field-error">
												<form:errors path="strExPassword" />
											</span>
									   </c:if>
									    <c:if test="${not status.error}">
											<span class="field-alt fw600">
												Current Password <div class="ico-help" title="Current password of your account."><i class="fa fa-question-circle"></i></div>
											</span>			
										</c:if>	                    
					                    <div class="section">
					                      <label for="strExPassword" class="field prepend-icon">
					                        <form:password path="strExPassword" id="strExPassword" cssClass="gui-input br5" placeholder="Current Password"/>
					                        <label for="strExPassword" class="field-icon">
					                          <i class="fa fa-lock"></i>
					                        </label>
					                      </label>
					                    </div>
				                    </spring:bind>
			                     </div>
				                 <!-- <div class="col-md-12">		 -->
					                 <div class="col-md-6">
						                 <spring:bind path="strPassword">
										   <c:if test="${status.error}">
										   		<span class="field-error">
													<form:errors path="strPassword" />
												</span>
										   </c:if>
										   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													New Password <div class="ico-help" title="New Password for your account."><i class="fa fa-question-circle"></i></div>
												</span>		
											</c:if>				                 				
							                    <div class="section">
							                      <label for="strPassword" class="field prepend-icon">
							                       	<form:password path="strPassword" id="strPassword" cssClass="gui-input br5" placeholder="New Password"/>
							                        <label for="strPassword" class="field-icon">
							                          <i class="fa fa-lock"></i>
							                        </label>
							                      </label>
							                    </div>
					                    </spring:bind>
					                 </div>
				                    	<!-- end section -->
									 <div class="col-md-6">
									 	<spring:bind path="strConfirmPassword">
										   <c:if test="${status.error}">
										   		<span class="field-error">
													<form:errors path="strConfirmPassword" />
												</span>
										   </c:if>
										   <c:if test="${not status.error}">	
												<span class="field-alt fw600">
													Confirm Password <div class="ico-help" title="Confirm the given new password."><i class="fa fa-question-circle"></i></div>
												</span>		
											</c:if>								 
						                    <div class="section">
						                      <label for="strConfirmPassword" class="field prepend-icon">
						                       <form:password path="strConfirmPassword" id="strConfirmPassword" cssClass="gui-input br5" placeholder="Confirm Password"/>
						                        <label for="strRePassword" class="field-icon">
						                          <i class="fa fa-unlock-alt"></i>
						                        </label>
						                      </label>
						                    </div>
						                 </spring:bind>
						                    <!-- end section -->
						             </div>
						         <!-- </div> -->
			                  </div>
			                  <!-- end .form-body section -->
			                  <div class="panel-footer text-right">
			                    <button type="submit" class="button btn-primary br3"> Change </button>
			                    <button type="reset" class="button br3"> Cancel </button>
			                  </div>
			                  <!-- end .form-footer section -->
			                </form:form>
			             </div>   
	                </div>
	            </div>
	          </div>
<!-- 	          <div class="col-md-2"></div> -->
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>