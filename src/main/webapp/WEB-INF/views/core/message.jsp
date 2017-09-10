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
	      <section id="content" class="table-layout">
			<div class="tray tray-center" style="height: 620px;">
	          <div class="mw1000 center-block" style="margin-top: 16%;">
	            <!-- Begin: Content Header -->
	            <div class="content-header">
	              <h2><i class="fa fa-smile-o fa-2x pr10 text-success va-middle"></i>${headerText}</h2>
	              <p class="lead">${subText}</p>
	              <a href='<spring:url value="${redirectUrl}"/>' class="btn btn-primary" data-toggle=".toggle-loading"><span class="fa fa-sign-in"></span> Login Now</a>
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
	<!-- END: PAGE SCRIPTS -->
</body>
</html>