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
	            <li class="crumb-trail">Design</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/design/templates/"/>'>Project Templates</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Project Templates</label>
	          </div>
	        </div>
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
	
	       <div class="row">
	        <div class="col-md-12">
	        	 	<div class="panel panel-visible bt-gray">
	        	 		<div class="panel-body">
	        	 			<div class="col-xs-12 col-sm-9 col-md-9">
                                 <div class="forum-icon">
                                     <i class="glyphicon glyphicon-equalizer"></i>
                                  </div>
                                  <span class="forum-item-title">Project Template</span>
                                  <div class="forum-sub-title">Manage Project Templates.</div>
                             </div>
                             <div class="col-xs-12 col-sm-3 col-md-3">
	        	           		<a href='<spring:url value="/design/templates/new"/>' class="btn btn-success br3 fw600 pull-right"><span class="fa fa-plus"></span> Add New Project </a>
	        	           	</div>	
	        	 		</div>
	        	 	</div>
	        </div>
	          <div class="col-md-12">
	             <div class="panel panel-visible bt-green" id="spy1"> 
	                <div class="panel-body">
		                <spring:url value="/security/object/update" var="url"/>
		                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
		                    <thead>
		                      <tr>
		                        <th width="5%">No</th>
		                        <th>Project Name</th>
		                        <th>Owner</th>
		                        <th width="10%">Start Date</th>
		                        <th width="10%">End Date</th>
		                        <th width="5%">Edit</th>
		                        <th width="5%">Delete</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                      <tr>
		                        <td>1</td>
		                        <td>qqwd</td>
		                        <td>qwrdwefdewfe</td>           
		                        <td>12-10-2017</td>
		                        <td>12-10-2018</td>
		                        <td><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
		                      </tr>
		                      <tr>
		                        <td>1</td>
		                        <td>qqwd</td>
		                        <td>qwrdwefdewfe</td>           
		                        <td>12-10-2017</td>
		                        <td>12-10-2018</td>
		                        <td><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
		                      </tr>
		                      <tr>
		                        <td>1</td>
		                        <td>qqwd</td>
		                        <td>qwrdwefdewfe</td>           
		                        <td>12-10-2017</td>
		                        <td>12-10-2018</td>
		                        <td><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
		                      </tr>
		                      <tr>
		                        <td>1</td>
		                        <td>qqwd</td>
		                        <td>qwrdwefdewfe</td>           
		                        <td>12-10-2017</td>
		                        <td>12-10-2018</td>
		                        <td><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
		                      </tr>
		                      <tr>
		                        <td>1</td>
		                        <td>qqwd</td>
		                        <td>qwrdwefdewfe</td>           
		                        <td>12-10-2017</td>
		                        <td>12-10-2018</td>
		                        <td><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
		                      </tr>
		                      <tr>
		                        <td>1</td>
		                        <td>qqwd</td>
		                        <td>qwrdwefdewfe</td>           
		                        <td>12-10-2017</td>
		                        <td>12-10-2018</td>
		                        <td><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
		                      </tr>	                      		                      		                      
		                    </tbody>
		                  </table>
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
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/dataTables/jquery.dataTables.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/_sn.js'/>"></script>
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>