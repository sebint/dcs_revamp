<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>MPXD Data Capture System</title>
<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/fav.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Redirect to default login success URL -->
<security:authorize access="isAuthenticated()">
	<security:authorize access="!hasRole('ROLE_CHANGE_PASSWORD')">
    	<% response.sendRedirect("dashboard"); %>
    </security:authorize>
</security:authorize>

<link rel="stylesheet" type="text/css" href="<spring:url value='resources/css/theme/theme.css'/>">
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
	<div id="main" class="animated fadeIn">
		<header class="navbar navbar-fixed-top navbar-shadow bbr">
			<div class="navbar-branding mpxd_header">
				<a class="navbar-brand mpxd_logo" href="<spring:url value='/login'/>"> 
					<span class="m_lt">MPXD 
						<span class="mpxd_t_title">Data Capture System </span>
					</span>
				</a>
			</div>
		</header>
		<section id="content_wrapper">
			<section id="content">
				<div class="admin-form theme-info mw450 toggle-loading" id="login">
					<div class="panel mt20p mb25 bs-gray br6 b2-gray">
						<div class="row table-layout">
							<a title="Dashboard" href="<spring:url value='/login'/>"> 
								<img src="<spring:url value='resources/img/logo.png'/>" title="AdminDesigns Logo" class="center-block img-responsive w32p mw40p mt10">
							</a>
						</div>
						<div class="row table-layout">
							<h2 class="t-a mt10"><span class="txt-sky-blue">MRT</span> Data Capture System</h2>
						</div>
						<spring:url value="login" var="formUrl"/>
						<form:form action="${formUrl}" method="POST" id="mpxd-login" cssClass="form-toggle" modelAttribute="login">
							<div class="panel-body bg-light p25 pb15 pt0">
							   <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
									<div class="section animated fadeIn">
										<div class="alert alert-danger alert-dismissable mt10">
										  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
										  <i class="fa fa-frown-o fa-2x pr10 va-middle"></i>					  
											<span>${SPRING_SECURITY_LAST_EXCEPTION.message}</span>
										</div>
									</div>
								</c:if>
							    <c:if test="${ not empty error}">
									<div class="section animated fadeIn">
										<div class="alert alert-danger alert-dismissable mt10">
											<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
											<i class="fa fa-frown-o fa-2x pr10 va-middle"></i>	
												<span>${error}</span>
										</div>
									</div>   
						        </c:if>
						        <c:if test="${ not empty message}">	
									<div class="section animated fadeIn">
										<div class="alert alert-success alert-dismissable mt10">
											<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
											<i class="fa fa-smile-o fa-2x pr10 va-middle"></i>	
												<span>${message}</span>
										</div>
									</div>
						        </c:if>	
						        <c:if test="${ not empty info}">	
									<div class="section animated fadeIn">
										<div class="alert alert-info alert-dismissable mt10">
											<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
											<i class="fa fa-frown-o fa-2x pr10 va-middle"></i>	
												<span>${info}</span>
										</div>
									</div>
						        </c:if>								        	
								<div class="section">
									<h3><spring:message code="login.request"/></h3>
									<p>Please enter your <code>username</code> and <code>password</code> to log in.</p>
								</div>
								<div class="section">
									<div class="form-group">
										<span class="input-icon"> 
											<form:input path="strUserName" id="strUserName" cssClass="form-control" placeholder="Username or Email"/>
											<i class="fa fa-user"></i>
										</span> 
										<span>
											<form:errors path="strUserName" cssClass="field-error"/>
										</span>
									</div>

								</div>
								<div class="section">
									<div class="form-group">
										<span class="input-icon"> 
											<form:password path="strPassword" id="strPassword" cssClass="form-control" placeholder="Password"/>
											<i class="fa fa-lock"></i>
										</span> 
										<span>
											<form:errors path="strPassword" cssClass="field-error"/>
										</span>
									</div>
								</div>
								<div class="login-links">
									<p>
										<a href="javascript:void(0);" class="active form-toggle-btn" title="Forgot Password" data-toggle=".form-toggle"><i class="fa fa-key"></i> Forgot Password?</a>					
									</p>
								</div>
							</div>

							<div class="panel-footer clearfix">
								<div class="section">
									<div class="form-group">
										<button type="submit" class="btn btn-primary m10 w95p submit" data-toggle=".toggle-loading">
											<span class="fa fa-sign-in"></span> Sign In
										</button>
									</div>
								</div>
							</div>
						</form:form>
						<spring:url value="resetpassword" var="resetUrl"/>
						<form:form action="${resetUrl}" method="POST" id="mpxd-resetpass" cssClass="form-toggle" cssStyle="display:none">
<!-- 							<div class="loading"> -->
<!-- 								<div class="overlay"></div> -->
								<div class="panel-body bg-light p25 pb15 pt0">
	  								<h3 class="font-green">Forgot Password ?</h3>
	                            	<p> Enter your <code>username</code> or <code>e-mail address</code> below to reset your password. </p>
	                            	<div class="form-group">
	                            		<span class="input-icon"> 
<%-- 	                            			<form:input path="strUsername" id="strUsername" autocomplete="off" cssClass="form-control" placeholder="Username"/> --%>
	                            			<input type="text" name="strUsername" id="strUsername" autocomplete="off" class="form-control" placeholder="Username"/>
	                                		<i class="fa fa-user"></i>
	                                	</span>
	                                </div>
	                                <div class="row mb10 text-center">
	                                	<span class="text-primary fw600">OR</span>
	                                </div>
	                                <div class="form-group">
	                            		<span class="input-icon"> 
<%-- 	                            			<form:input path="strEmail" id="strEmail" autocomplete="off" cssClass="form-control" placeholder="Email Address"/>	 --%>
	                            			<input type="text" name="strEmail" id="strEmail" autocomplete="off" class="form-control" placeholder="Email Address"/>	                      
	                                		<i class="fa fa-envelope"></i>
	                                	</span>
	                                </div>
	                            </div>
	                            <div class="panel-footer clearfix">
	                            	<div class="section">
			                            <div class="form-actions">
			                                <button type="button" class="btn grey btn-default form-toggle-btn" data-toggle=".form-toggle">Back</button>
			                                <button type="submit" class="btn blue btn-success uppercase pull-right">Submit</button>
			                            </div>	
		                            </div>
	                            </div>
<!--                            </div>												 -->
							</form:form>
					</div>
				</div>
				<div class="admin-form theme-info mw500 toggle-loading" id="loading" style="display: none;">
					<div class="panel mt20p mb25 bc-transparent b0">
						<div class="panel-body b-none">
						  <div class="loading">
								<div class="overlay"><span id="l-status">Authenticating...</span></div>
						 </div>
					 	</div>
					</div>
				</div>

			</section>
			<!-- End: Content -->
		</section>
		<!-- End: Content-Wrapper -->
	</div>
	<script type="text/javascript" src="<spring:url value='resources/lib/jquery/jquery2.2.4.min.js'/>"></script>
	<script type="text/javascript" src="<spring:url value='resources/lib/jquery/jquery-ui.min.js'/>"></script>
	<script type="text/javascript" src="<spring:url value='resources/js/util.js'/>"></script>
	<script type="text/javascript" src="<spring:url value='resources/js/_sn.js'/>"></script>
	<script type="text/javascript" src="<spring:url value='resources/js/pages/login.js'/>"></script>
	<!-- END: PAGE SCRIPTS -->
</body>
</html>