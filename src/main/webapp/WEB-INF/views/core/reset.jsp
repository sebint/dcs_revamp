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
	                <img src="assets/img/logos/logo.png" title="AdminDesigns Logo" class="img-responsive w250">
	              </a>
	            </div>
	
	            <div class="col-xs-6 va-b pr5">
	              <div class="login-links text-right">
	                <a href="#" class="" title="False Credentials">Not Michael Rowls?</a>
	              </div>
	
	            </div>
	
	          </div>
	          <div class="panel">
	
	            <!-- end .form-header section -->
	            <form method="post" action="http://admindesigns.com/" id="contact">
	              <div class="panel-body bg-light pn">
	
	                <div class="row table-layout">
	                  <div class="col-xs-3 p20 pv15 va-m br-r bg-light">
	                    <img class="br-a bw4 br-grey img-responsive center-block" src="assets/img/avatars/3.jpg" title="AdminDesigns Logo">
	                  </div>
	                  <div class="col-xs-9 p20 pv15 va-m bg-light">
	                    <h3 class="mb5"> Michael Rowls
	                      <small> - logged out for
	                        <b> 5 hours </b>
	                    </h3>
	                    <p class="text-muted">michaelrowls@company.com</p>
	
	                    <div class="section mt25">
	                      <label for="password" class="field prepend-icon">
	                        <input type="text" name="password" id="password" class="gui-input" placeholder="Enter password">
	                        <label for="password" class="field-icon">
	                          <i class="fa fa-lock"></i>
	                        </label>
	                      </label>
	                    </div>
	                    <!-- end section -->
	
	                  </div>
	                </div>
	              </div>
	              <!-- end .form-body section -->
	
	            </form>
	          </div>
	          <button type="submit" class="button btn-info pull-right">Unlock</button>
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