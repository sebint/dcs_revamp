<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>MPXD Data Capture System</title>
		<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/fav.ico" />
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/theme/theme.css">
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
       		<c:if test="${not empty error}">
	        	<div class="col-md-12">	
					<div class="section animated fadeIn">
						<div class="alert alert-danger alert-dismissable mt10">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>	
								<span>${error}</span>
						</div>
					</div>
				</div>        
	        </c:if>
	        <c:if test="${not empty message}">
	        	<div class="col-md-12">	
					<div class="section animated fadeIn">
						<div class="alert alert-success alert-dismissable mt10">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>	
								<span>${message}</span>
						</div>
					</div>
				</div>	        
	        </c:if>	 
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
		                <spring:url value="/design/templates" var="url"/>
		                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
		                    <thead>
		                      <tr>
		                        <th width="5%">No</th>
		                        <th>Project Name</th>
		                        <th>Owner</th>
		                        <th width="10%">Start Date</th>
		                        <th width="10%">End Date</th>
		                        <!-- <th width="5%">Edit</th> -->
		                        <th width="5%">Delete</th>
		                      </tr>
		                    </thead>
		                    <tbody>
							<c:forEach items="${projectList}" var="project" varStatus="counter">
							 	<tr>
									<td>${counter.index+1}</td>
									<td><a href="${url}/${fn:replace(fn:toLowerCase(project.projectName),' ', '-')}">${project.projectName}</a></td>
									<td>${project.user.strFirstName} ${project.user.strLastName}</td>
									<td><fmt:formatDate value="${project.startDate}" pattern="dd-MMM-YYYY" /></td>
									<td><fmt:formatDate value="${project.endDate}" pattern="dd-MMM-YYYY" /></td>
									<%-- <td><a href="${url}/${fn:replace(fn:toLowerCase(project.projectName),' ', '-')}" class="sr-update"><span class="glyphicon glyphicon-edit"></span></a></td> --%>
									<td><a class="dr-confirm no-loader" data-content= "This will remove <b><code>${project.projectName}</code></b> from the users permanantly .Continue deleting?" data-title="Delete Project" href="<spring:url value="/design/templates/delete"/>/${project.projectMasterId}"><span class="glyphicon glyphicon-trash">&nbsp;</span></a></td>
								</tr>
							</c:forEach>                   		                      		                      
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery2.2.4.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-ui.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/util.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/dataTables/jquery.dataTables.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() { "use strict"; _dataTable.init(); _confirm.init(); });
	  </script>
	</body>
</html>