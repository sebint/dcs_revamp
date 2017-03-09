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
		<link rel="stylesheet" type="text/css" href="<spring:url value='../../resources/css/theme/theme.css'/>">
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
	            <li class="crumb-trail">Administrator</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/manage/unit-measure/"/>'>Unit of Measure</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Unit of Measure</label>
	          </div>
	        </div>
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
	
	        <div class="row">
	          <div class="col-md-8">
	            <div class="panel">
	                <div class="panel-heading">
	                   <span class="panel-icon"></span>
	                   <span class="panel-title"> Panel One</span>
	                </div>    
	                <div class="panel-body">
	                  <p class="">
	                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	                  </p>
	                </div>
	            </div>
	          </div>
	          <div class="col-md-4">
	            <div class="panel">
	                <div class="panel-heading">
	                   <span class="panel-icon"></span>
	                   <span class="panel-title"> Panel Two</span>
	                </div>    
	                <div class="panel-body">
	                  <p class="">
	                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	                  </p>
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
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery/jquery2.2.4.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery/jquery-ui.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/util.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/_sn.js'/>"></script>
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>