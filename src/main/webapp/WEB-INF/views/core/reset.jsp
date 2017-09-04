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
	
	
	      <!-- Begin: Content -->
	      <section id="content">
	
	        <div class="admin-form theme-info mw600" style="margin-top: 11%;" id="login1">
	          <div class="row mb15 table-layout">
	
	            <div class="col-xs-6 pln">
	              <a href="dashboard.html" title="Return to Dashboard">
	                <img src="${pageContext.request.contextPath}/resources/img/logo.png" title="AdminDesigns Logo" class="img-responsive w125">
	              </a>
	            </div>
	
	            <div class="col-xs-6 va-b pr5">
	              <div class="login-links text-right">
	                <a href='<spring:url value="/logout"/>' class="" title="False Credentials">Not <security:authentication property="principal.firstName"/> <security:authentication property="principal.lastName"/>?</a>
	              </div>
	
	            </div>
	
	          </div>
	          <form:form method="post" action="reset" modelAttribute="reset" id="password-change-form">
	          <div class="panel">	
	            <!-- end .form-header section -->
	              <div class="panel-body bg-light pn">	
	                <div class="row table-layout">
	                  <div class="col-xs-3 p20 pv15 va-m br-r bg-light">
	                    <img class="br-a bw4 br-grey img-responsive center-block" src="${pageContext.request.contextPath}/resources/img/avatars/av1.png" title="AdminDesigns Logo">
	                  </div>
	                  <div class="col-xs-9 p20 pv15 va-m bg-light">
	                    <div class="section">
	                    <h4 class="text-muted">Change your password</h4>
						 	<spring:bind path="strPassword">
							   <c:if test="${status.error}">
							   		<span class="field-error">
										<form:errors path="strPassword" />
									</span>
							   </c:if>
								<div class="form-group">
									<span class="input-icon"> 
										<form:password path="strPassword" id="strPassword" cssClass="form-control" placeholder="New Password"/>
										<i class="fa fa-lock"></i>
									</span> 
								</div>
							</spring:bind>
							<security:authentication property="principal.userId" var="a_uid"/>
			                  <form:hidden path="intUserId" value="${a_uid}"/>
						</div>
	
	                    <div class="section">
	                    <spring:bind path="strConfirmPassword">
							   <c:if test="${status.error}">
							   		<span class="field-error">
										<form:errors path="strConfirmPassword" />
									</span>
							   </c:if>
							<div class="form-group">
								<span class="input-icon"> 
									 <form:password path="strConfirmPassword" id="strConfirmPassword" cssClass="form-control" placeholder="Confirm Password"/>
									<i class="fa fa-lock"></i>
								</span> 
							</div>
							</spring:bind>
						</div>
	                    <!-- end section -->
	
	                  </div>
	                </div>
	              </div>
	              <!-- end .form-body section -->
	          </div>
	          <div class="row">
	          	<div class="col-md-12 col-sm-12">
				    <c:if test="${ not empty error}">
						<div class="section animated fadeIn">
							<div class="alert alert-danger mt10">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
								<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>	
									<span>${error}</span>
							</div>
						</div>   
			        </c:if>
			        <c:if test="${ not empty message}">	
						<div class="section animated fadeIn">
							<div class="alert alert-success mt10">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
								<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>	
									<span>${message}</span>
							</div>
						</div>
			        </c:if>	
			     </div>   
	          	<div class="btn-group  pull-right mr15">
						<button type="submit" class="btn btn-primary submit" data-toggle=".toggle-loading">
							<span class="fa fa-unlock"></span> Change Password
						</button>
						<a href='<spring:url value="/logout"/>' class="btn btn-default btn-cancel">
							<i class="fa fa-power-off"></i> Logout
						</a>
				</div>
			</div>	
			 </form:form>	
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