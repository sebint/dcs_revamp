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
	
	      <!-- Start: Topbar-Dropdown -->
	     <div id="topbar-dropmenu">
	        <div class="topbar-menu row">
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-inbox"></span>
	              <p class="metro-title">Messages</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-user"></span>
	              <p class="metro-title">Users</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-headphones"></span>
	              <p class="metro-title">Support</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon fa fa-gears"></span>
	              <p class="metro-title">Settings</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-facetime-video"></span>
	              <p class="metro-title">Videos</p>
	            </a>
	          </div>
	          <div class="col-xs-4 col-sm-2">
	            <a href="#" class="metro-tile">
	              <span class="metro-icon glyphicon glyphicon-picture"></span>
	              <p class="metro-title">Pictures</p>
	            </a>
	          </div>
	        </div>
	      </div>
	      <!-- End: Topbar-Dropdown -->
	
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
	              <a href='<spring:url value="/security/account"/>'>Change Password</a>
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
			                <s:form method="post" action="user/change/1" namespace="/security" id="password-change-form">
			                  <div class="panel-body p0">
			                    <div class="section-divider mv40" id="spy4">
			                      <span> Provide the following information to change Password </span>
			                    </div>
			                    <!-- .section-divider -->
								<span class="field-alt fw600">
									Current Password <div class="ico-help" title="Current password of your account."><i class="fa fa-question-circle"></i></div>
								</span>				                    
			                    <div class="section">
			                      <label for="strExPassword" class="field prepend-icon">
			                        <s:password name="strExPassword" id="strExPassword" cssClass="gui-input br5" placeholder="Current Password"></s:password>
			                        <label for="strExPassword" class="field-icon">
			                          <i class="fa fa-lock"></i>
			                        </label>
			                      </label>
			                    </div>
				                 <!-- <div class="col-md-12">		 -->
					                 <div class="col-md-6 pl0">
										<span class="field-alt fw600">
											New Password <div class="ico-help" title="New Password for your account."><i class="fa fa-question-circle"></i></div>
										</span>						                 				
					                    <div class="section">
					                      <label for="strPassword" class="field prepend-icon">
					                       	<s:password name="strPassword" id="strPassword" cssClass="gui-input br5" placeholder="New Password"></s:password>
					                        <label for="strPassword" class="field-icon">
					                          <i class="fa fa-lock"></i>
					                        </label>
					                      </label>
					                    </div>
					                 </div>
				                    	<!-- end section -->
									 <div class="col-md-6 pr0">	
										<span class="field-alt fw600">
											Confirm Password <div class="ico-help" title="Confirm the given new password."><i class="fa fa-question-circle"></i></div>
										</span>										 
						                    <div class="section">
						                      <label for="strRePassword" class="field prepend-icon">
						                       <s:password name="strRePassword" id="strRePassword" cssClass="gui-input br5" placeholder="Confirm Password"></s:password>
						                        <label for="strRePassword" class="field-icon">
						                          <i class="fa fa-unlock-alt"></i>
						                        </label>
						                      </label>
						                    </div>
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
			                </s:form>
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