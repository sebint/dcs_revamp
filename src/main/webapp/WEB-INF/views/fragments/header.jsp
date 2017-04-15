<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
		  <!-- Simple splash screen-->
		<div class="splash"> 
<!-- 			<div class="color-line"></div> -->
			<div class="splash-title">
<!-- 				<h1>Homer - Responsive Admin Theme</h1> -->
<!-- 				<p>Special Admin Theme for small and medium webapp with very clean and aesthetic style and feel. </p> -->
				<div class="spinner"> 
					<div class="rect1"></div> 
					<div class="rect2"></div> 
					<div class="rect3"></div> 
					<div class="rect4"></div> 
					<div class="rect5"></div> 
				</div> 
				<h4>Loading..</h4> 
			</div> 
		</div>
			<!--[if lt IE 7]>
				<p class="alert alert-danger">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
			<![endif]-->
	    <!-- Start: Header -->
	    <header class="navbar navbar-fixed-top navbar-shadow">
	
	      <div class="navbar-branding mpxd_header">
	        <a class="navbar-brand mpxd_logo" href='<spring:url value="/dashboard"/>'>
	         	<span class="m_logo_image">
						<img src="${pageContext.request.contextPath}/resources/img/logo_sm.png" alt="MPXD" width="90px">
				</span>
				<span class="m_lt">MPXD 
						<span class="mpxd_t_title">Data Capture System
						</span>
				</span>
	        </a>
	      </div>	
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown menu-merge">
	          <a data-toggle="modal" data-target=".bd-alert-modal-lg" href="#">
	            <span class="fa fa-exclamation-triangle"></span>
	            <span class="badge badge-alert badge-hero">3</span>
	          </a>
	        </li>
	        <li class="dropdown menu-merge">
	          <a data-toggle="modal" data-target=".bd-reminder-modal-lg" href="#">
	            <span class="fa fa-bell"></span>
	            <span class="badge badge-alert badge-hero">99+</span>
	          </a>
	        </li>
	        <li class="menu-divider hidden-xs">
	          <i class="fa fa-circle"></i>
	        </li>
	        <li class="dropdown menu-merge">
	          <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown"> <img src="${pageContext.request.contextPath}/resources/img/avatars/av1.png" alt="avatar" class="mw30 br64 mr15"><security:authentication property="principal.firstName"/> <security:authentication property="principal.lastName"/>
	            <span class="caret caret-tp hidden-xs"></span>
	          </a>
	          <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
<%-- 	            <li class="dropdown-header clearfix">

	            </li>
	            <li class="list-group-item">
	              <a href="#" class="animated animated-short fadeInUp">
	                <span class="fa fa-power-off"></span>Logout </a>
	            </li> --%>
<%-- 				 <li>
					 <span class="dropdown-header fw600"><i class="fa fa-user"></i>  Active User</span>
				</li> --%>
				<li>
					<div class="drop-down-wrapper ps-container">
						<div class="no-margin">
							 <a class="media list-group-item" href="#">
								 <img src="${pageContext.request.contextPath}/resources/img/avatars/1.jpg" alt="avatar" class="mw60 br64 m066p">
										<span class="media-body ta-center block no-margin ln-hgt"><small class="p5 block text-grey"><security:authentication property="principal.username"/></small><small class="text-yellow"><security:authentication property="principal.email"/></small></span>
							</a>
						</div>
					</div>
				</li>
				<li class="list-group-item ta-center">
					<a class="lt" href='<spring:url value="/logout"/>'>
							 <span class="fa fa-power-off"></span> Logout 
					</a>
				</li>	            
	          </ul>
	        </li>
	        <li id="toggle_sidemenu_t">  
	        	<span class="fa fa-caret-up"></span>
	        </li>
	      </ul>
	
	    </header>
	    <!-- End: Header -->