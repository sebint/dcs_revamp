<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	            <li class="crumb-trail">Assessment</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/assessment/journal-entry"/>'>Journal Data Entry</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Journal Data Entry</label>
	          </div>
	        </div>
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
	
	        <div class="row">
	       	<c:if test="${ not empty error}">
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
	        <c:if test="${ not empty message}">
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
        	 	<div class="panel panel-visible bt-blue" id="spy1">
        	 		<div class="panel-body">
        	 			<div class="col-xs-12 col-sm-9 col-md-9">
                                <div class="forum-icon">
                                    <i class="glyphicon glyphicon-equalizer"></i>
                                 </div>
                                 <span class="forum-item-title">Journal Data Entry</span>
                                 <div class="forum-sub-title">Data Entry for Journals</div>
                            </div>
        	 		</div>
        	 	</div>
	        </div>		        
	          <div class="col-md-3">
	            <div class="panel bt-green">
	             	<div class="panel-heading">
	                   <span class="panel-icon"></span>
	                   <span class="panel-title"> Journal Types</span>
	                </div> 
	                <div class="panel-body m-h-65vh">
						<div id="nav-spy">
			              <ul class="nav tray-nav tray-nav-border affix-top m-0--15" data-nav-animate="zoomIn" data-smoothscroll="-125" data-spy="affix" data-offset-top="240">
			                <li class="active animated animated-short zoomIn">
			                  <a href="#p0">
			                    <span class="fa fa-bar-chart fa-lg"></span> Progressive <span class="label badge-warning pull-right">22</span></a>
			                </li>
			                <li class="animated animated-short zoomIn">
			                  <a href="#p1">
			                    <span class="fa fa-eyedropper fa-lg"></span> Non-Progressive <span class="label badge-warning pull-right">17</span></a>
			                </li>
			              </ul>
			            </div>
	                </div>
	            </div>
	          </div>
	          <div class="col-md-9">
	             <div class="panel panel-visible bt-blue" id="spy1"> 
	                <div class="panel-body">
		                <spring:url value="/assessment/journal-entry" var="url"/>
		                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true" data-iDisplayLength="50">
		                    <thead>
		                      <tr>
		                        <th width="5%">No</th>
		                        <th>Journal Name</th>
		                        <th>Project Name</th>		                        
		                        <th>Owner</th>
		                        <th width="5%">Action</th>
		                      </tr>
		                    </thead>
		                    <tbody>
			                    <c:if test="${fn:length(nonProgressiveList) gt 0}">
				                    <c:forEach items="${nonProgressiveList}" var="nonList" varStatus="counter">
				                      <c:set var="rand" value="${100+random.nextInt(1000-(100+1))}"/>
				                      <tr>
				                        <td>${counter.index+1}</td>
				                        <td class="t-t-capt"><i class="fa fa-caret-right text-primary"></i> <a class="a-redocorated" href="${url}/${fn:replace(fn:toLowerCase(nonList.journalName),' ', '-')}-${rand}${nonList.project.projectMasterId}">${nonList.journalName}</a></td>
				                        <td class="t-t-capt">${nonList.project.projectName}</td>				                                   
				                        <td class="t-t-capt">${nonList.user.strFirstName} ${nonList.user.strLastName}</td>
				                        <td><a href="${url}/${fn:replace(fn:toLowerCase(nonList.journalName),' ', '-')}-${rand}${nonList.project.projectMasterId}" class="btn btn-hover btn-default btn-sm">Update</a></td>
				                      </tr>  
				                      </c:forEach>	
			                      </c:if>	                      		                      
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
	  	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/dataTables/jquery.dataTables.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/util.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() { "use strict"; _dataTable.init({"searchType":"Journals"});});
	  </script>
	</body>
</html>