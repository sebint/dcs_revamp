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
	                <img src="${pageContext.request.contextPath}/resources/img/logo.png" title="AdminDesigns Logo" class="img-responsive w150">
	              </a>
	            </div>
	
	            <div class="col-xs-6 va-b pr5">
	              <div class="login-links text-right">
	                <a href='<spring:url value="/logout"/>' class="" title="False Credentials">Not <security:authentication property="principal.firstName"/> <security:authentication property="principal.lastName"/>?</a>
	              </div>
	
	            </div>
	
	          </div>
	          <form method="post" action="#" id="contact">
	          <div class="panel">	
	            <!-- end .form-header section -->
	              <div class="panel-body bg-light pn">	
	                <div class="row table-layout h207">
	                  <div class="col-xs-3 p20 pv15 va-m br-r bg-light">
	                    <img class="br-a bw4 br-grey img-responsive center-block" src="${pageContext.request.contextPath}/resources/img/avatars/av1.png" title="AdminDesigns Logo">
	                  </div>
	                  <div class="col-xs-9 p20 pv15 va-m bg-light">
	                    <div class="section">
							<div class="form-group">
								<span class="input-icon"> 
									<input id="strUserName" name="strUserName" class="form-control" placeholder="New Password" value="" type="text">
									<i class="fa fa-lock"></i>
								</span> 
							</div>
						</div>
	
	                    <div class="section">
							<div class="form-group">
								<span class="input-icon"> 
									<input id="strUserName" name="strUserName" class="form-control" placeholder="Confirm Password" value="" type="text">
									<i class="fa fa-lock"></i>
								</span> 
							</div>
						</div>
	                    <!-- end section -->
	
	                  </div>
	                </div>
	              </div>
	              <!-- end .form-body section -->
	          </div>
				<div class="section">
					<div class="form-group">
						<button type="submit" class="btn btn-primary pull-right m10 submit" data-toggle=".toggle-loading">
							<span class="fa fa-unlock"></span> Change Password
						</button>
					</div>
				</div>
			 </form>	
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