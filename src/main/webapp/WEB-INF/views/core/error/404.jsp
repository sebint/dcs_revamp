<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
<link rel="stylesheet" type="text/css" href="<spring:url value='/resources/css/theme/theme.css'/>"/>
</head>
<body class="error-page alt sb-l-c sb-r-c">
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
				<div class="center-block mt50 mw800">
          			<h1 class="error-title">${errorCode}!</h1>
          			<h2 class="error-subtitle">${errorMessage}</h2>
          			<div class="row mlmr100">
						<div class="col-sm-6">
							<a href="<spring:url value='/dashboard'/>" class="btn btn-primary btn-block content-group">
								<i class="fa fa-home"></i> Go to dashboard
							</a>
							<!-- Check Session and Enable this  -->
<!-- 							<a href="#" class="btn btn-primary btn-block content-group">
								<i class="icon-circle-left2 position-left"></i> Go to Login Page
							</a> -->
						</div>
						<div class="col-sm-6">
							<a href="#" class="btn btn-default btn-block content-group" onclick="history.go(-1);">
								<i class="fa fa-history"></i> Go to Previous Page
							</a>
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