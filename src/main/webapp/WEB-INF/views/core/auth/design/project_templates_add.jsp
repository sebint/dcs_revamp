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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/forms-theme.css">
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
	            <li class="crumb-link">
	              <a class="t-t-capt" href='<spring:url value="/design/templates/${!empty(projectName)? projectName :  'new'}"/>'>${!empty(projectName)? (fn:replace(fn:toLowerCase(projectName),'-', ' ')) :  'New'}</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	             <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">
            	   <c:choose>
               			<c:when test="${!empty(projectName)}">
               				<span class="t-t-capt">${(fn:replace(fn:toLowerCase(projectName),'-', ' '))}</span>
               			</c:when>
               			<c:otherwise>
               				<spring:message code="prj.new.header"/>
               			</c:otherwise>
               		</c:choose>
	             </label>
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
	            <div class="panel panel-visible">
                	<div class="panel-body">              		
	                	<div class="well-box" id="${!empty(projectName)? 'view-port' :  'update-port'}" style="${empty(projectName)? 'display: none;' :  ''}">
							<div id="search" class="tab-pane active search-results-page">					
			                    <!-- Begin Search Result Entries -->
			                    <div class="search-result">
			                    <jsp:useBean id="now" class="java.util.Date" scope="request"/>
			                    <fmt:parseNumber value="${ now.time / (1000*60*60*24) }" integerOnly="true" var="nowDays" scope="request"/>
			                    <fmt:parseNumber value="${ project.dtDateCreated.time / (1000*60*60*24) }" integerOnly="true" var="otherDays" scope="page"/>
			                    <c:set value="${nowDays - otherDays}" var="dateDiff"/>
				                    <div class="view-header">
										<div class="media">
					                      <a class="pull-left" href="#"> <img class="media-object mn thumbnail thumbnail-sm rounded mw50" src="${pageContext.request.contextPath}/resources/img/head-logo/project.png" alt="..."> </a>
					                      <div class="media-body mb5">
					                        <h5 class="media-heading view-title">${project.projectName}
					                          <small class="view-sub-title"> - Created <a title="<fmt:formatDate value="${project.dtDateCreated}" pattern="dd-MMM-YYYY hh:mm:ss" />">
					                          <c:choose>
												    <c:when test="${dateDiff eq 0}">today</c:when>
												    <c:when test="${dateDiff eq 1}">yesterday</c:when>
												    <c:otherwise>${dateDiff} day(s) ago</c:otherwise>
											  </c:choose></a> by <a href='<spring:url value="/security/user/${project.createdUser.strUserName}"/>' class="t-t-capt">${project.createdUser.strFirstName} ${project.createdUser.strLastName}</a></small>
					                        </h5>
					                        <p> ${project.projectDesc}</p>
					                      </div>
					                    </div>				                    
				                    	<div class="panel-header-menu pull-right mt-45">
				                    		<div class="btn-group mb10">
						                      <a class="btn btn-default light no-loader btn-update" title="Edit Project">
						                        <i class="fa fa-edit"></i>
						                      </a>
						                      <a class="btn btn-default light no-loader" title="Delete Project">
						                        <i class="fa fa-trash"></i>
						                      </a>
						                      <a class="btn btn-default light dropdown-toggle ph8 no-loader" data-toggle="dropdown" aria-expanded="false">
						                          <span class="glyphicon glyphicon-cog"></span>
						                          <span class="caret ml5"></span>
						                      </a>
						                       <ul class="dropdown-menu pull-right" role="menu">
								                  <li>
										              <a href="javascript:window.print()" class="no-loader">
										                <i class="fa fa-print fs13"></i> Print
										              </a>
								                  </li>
								                  <li>
								                    <a>
								                      <i class="fa fa-envelope-o"></i> Message </a>
								                  </li>
						                          <li class="divider"></li>
						                          <li>
						                            <a href="#">
						                              <span class="fa fa-plus pr5"></span> Create New</a>
						                          </li>
						                        </ul>
						                    </div>
							            </div>
				                    </div>
			                       <hr class="short alt">
			                       <div class="row">
										<div class="bg-light">
						                  <div class="col-xs-12 col-lg-6">
						                  	<div class="table-responsive">
												<table class="table table-striped table-view">
								                  <tbody>
								                    <tr>
								                      <td  width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Project Starts <span class="pull-right">:</span></strong></td>
								                      <td><fmt:formatDate value="${project.startDate}" pattern="dd-MMM-YYYY" /></td>
								                    </tr>
								                    <tr>
								                      <td width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Project Ends <span class="pull-right">:</span></strong></td>
								                      <td><fmt:formatDate value="${project.endDate}" pattern="dd-MMM-YYYY" /></td>
								                    </tr>
								                  </tbody>
								                </table>
							                </div>
						                  </div>
						                  <div class="col-xs-12 col-lg-6 br-l">
						                  	<div class="table-responsive">
												<table class="table table-striped table-view">
								                  <tbody>
								                    <tr>
								                      <td width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Project Owner <span class="pull-right">:</span></strong></td>
								                      <td>${project.user.strFirstName} ${project.user.strLastName}</td>
								                    </tr>
								                    <tr>
								                      <td width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Created On <span class="pull-right">:</span></strong></td>
								                      <td><fmt:formatDate value="${project.dtDateCreated}" pattern="dd-MMM-YYYY" /></td>
								                    </tr>
								                  </tbody>
								                </table>
							                </div>
						                  </div>
						                </div>
									</div>
									<ul class="result-meta mt10 pull-right">
			                          <li><i class="glyphicon glyphicon-time"></i> Last Modified on <code><fmt:formatDate value="${project.dtDateModified}" pattern="dd-MMM-YYYY" /></code> by <code>${project.modifiedUser.strFirstName} ${project.modifiedUser.strLastName}</code></li>
			                       </ul>
			                    </div>
			                </div>	
			               <hr>
			               <h5>Referenced Journals</h5>
							<div class="panel b-none">
							  <div class="panel-heading">
							    <ul class="nav panel-tabs-border panel-tabs panel-tabs-left tab-mpxd">
							      <li class="active">
							        <a href="#tab2_1" class="no-loader" data-toggle="tab" aria-expanded="true"><span class="glyphicon glyphicon-equalizer"></span> Non Progressive</a>
							      </li>
							      <li class="">
							        <a href="#tab2_2" class="no-loader" data-toggle="tab" aria-expanded="false"><span class="glyphicon glyphicon-modal-window"></span> Progressive</a>
							      </li>
							    </ul>
							  </div>
							  <div class="panel-body b-none">
							    <div class="tab-content pn br-n">
							      <div id="tab2_1" class="tab-pane active">
							        <div class="row">
										<div class="table-responsive">
							                <table class="table table-striped table-hover table-bordered" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
							               		<thead>
							               			<tr class="bg-light">
							               				<th>Journal Name</th>
							               				<th>Journal Owner</th>
							               				<th>Data Entry</th>
							               				<th>Validator</th>
							               				<th>Status</th>
							               			</tr>
							               		</thead>
									            <tbody>
									              <c:forEach items="${journal}" var="journal" varStatus="counter">
										              <tr class="message-unread">
										                <td>${journal.journalName}</td>
										                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
										                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
										                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
										                <td><span class="label label-success">IN PROGRESS</span></td>
										              </tr>
									              </c:forEach>
							                  </tbody>
							                </table>
							              </div>							        
							        </div>
							      </div>
							      <div id="tab2_2" class="tab-pane">
							        <div class="row">
							        </div>
							      </div>
							    </div>
							  </div>
							</div>							
<%-- 			               <table id="message-table" class="table tc-checkbox-1 mpxd theme-warning br-t b-1-s-grey">
			               		<thead>
			               			<tr>
			               				<td>Journal Name</td>
			               				<td>Journal Owner</td>
			               				<td>Data Entry</td>
			               				<td>Validator</td>
			               				<td>Status</td>
			               			</tr>
			               		</thead>
					            <tbody>
					              <c:forEach items="${journal}" var="journal" varStatus="counter">
						              <tr class="message-unread">
						                <td>${journal.journalName}</td>
						                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
						                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
						                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
						                <td><span class="label label-success">IN PROGRESS</span></td>
						              </tr>
					              </c:forEach> --%>
<!-- 					              <tr class="message-unread">
					                <td class="hidden-xs">
					                  <label class="option block mn">
					                    <input type="checkbox" name="mobileos" value="FR">
					                    <span class="checkbox mn"></span>
					                  </label>
					                </td>
					                <td class="hidden-xs">
					                  <span class="rating block mn pull-left">
					                    <input class="rating-input" id="r1" type="radio" name="custom">
					                    <label class="rating-star" for="r1">
					                      <i class="fa fa-star va-m"></i>
					                    </label>
					                  </span>
					                </td>
					                <td class="">Disney</td>
					                <td class="hidden-xs"></td>
					                <td class="">Lorem ipsum dolor sit amet, adipiscing eli</td>
					                <td class="hidden-xs">
					                  <i class="fa fa-paperclip fs15 text-muted va-b"></i>
					                </td>
					                <td class="text-right fw600">March 11</td>
					              </tr> -->
<!-- 					            </tbody>
					          </table>	 -->				
	                  	</div>
                	 		<c:choose>
	                			<c:when test="${!empty(projectName)}">
	                				<spring:url value="/design/templates/${projectName}" var="url_alt"/>
	                			</c:when>
	                			<c:otherwise>
	                				<spring:url value="/design/templates/new" var="url_alt"/>
	                			</c:otherwise>
	                		</c:choose>
							<div class="mpxd theme-primary mw1000 center-block" style="${!empty(projectName)? 'display: none;' :  'view-port'}" id="${!empty(projectName)? 'update-port' :  'view-port'}">								
								<form:form method="post" action="${url_alt}" id="project-form" modelAttribute="project">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> <spring:message code="prj.new.info"/> </span>
										</div>
										<form:hidden path="projectMasterId" />					
										<!-- .section-divider -->
										<div class="col-md-6">
											<spring:bind path="projectName">
											   <c:if test="${status.error}">
											   		<span class="field-error" >
														<form:errors path="projectName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
											   		<span class="field-alt fw600">
														<spring:message code="npj.new.projectname"/> <span class="text-danger">*</span> <span class="ico-help" title="New Project Name"><i class="fa fa-question-circle"></i></span>
													</span>	
											   </c:if>								
												<div class="section">												
													<label for="projectName" class="field prepend-icon"> 
													   <form:input path="projectName" id="projectName" cssClass="gui-input br5" placeholder="Project Name"></form:input>
															<label for="projectName" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>	
										</div>
										<div class="col-md-6">																		 
											<spring:bind path="projectDesc">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="projectDesc" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="prj.new.desc"/> <span class="ico-help" title="Description of your project"><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="projectDesc" class="field prepend-icon"> 
													   <form:input path="projectDesc" id="projectDesc" cssClass="gui-input br5" placeholder="Description"></form:input>
															<label for="projectDesc" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>
										</div>
										<!-- <div class="col-md-12">		 -->
										<div class="col-md-6">																				 
											<spring:bind path="userMasterId">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="userMasterId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.owner"/> <span class="ico-help" title="Select the Project Owner."><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
											<div class="section">
												<label class="field select">
													<form:select path="userMasterId">
					                          			<form:option value="" label="Please Select" selected="selected"/>
					                          			<form:options items="${userList}" itemValue="intUserId" itemLabel="strUserName"/> 
					                          		</form:select> 
					                          		<i class="arrow double"></i>
												</label>										
											</div>
											</spring:bind>
										</div>
										<!-- end section -->
										<div class="col-md-6">
											<spring:bind path="startDate">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="startDate" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="prj.new.startdate"/> <span class="ico-help" title="Date of the Project Begins"><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="startDate" class="field prepend-icon"> 
													   <form:input path="startDate" id="startDate" cssClass="gui-input br5 datepicker theme-primary" readonly="readonly" placeholder="Start Date"></form:input>
									                          <label class="field-icon">
									                            <i class="fa fa-calendar-o"></i>
									                          </label>
													</label>			                          
						                        </div>
					                        </spring:bind>
											<!-- end section -->
										</div>
										<spring:bind path="endDate">
											<div class="col-md-6">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="endDate" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="prj.new.enddate"/> <span class="ico-help" title="Date of Project completetion"><i class="fa fa-question-circle"></i></span>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="endDate" class="field prepend-icon"> 
													   <form:input path="endDate" id="endDate" cssClass="gui-input br5 datepicker" readonly="readonly" placeholder="End Date"></form:input>
															<label for="endDate" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>													
												</div>											
											</div>
										</spring:bind>
										<!-- end section -->
										<!-- end section -->
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" name="mode" value="save" class="button btn-success br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save</span></button>
										<button type="submit" name="mode" value="save_continue" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save and Continue</span></button>
										<a href="#" class="button br3 btn-cancel">
											<i class="fa fa-close"></i> Cancel
									   </a>
									</div>
									<!-- end .form-footer section -->
								</form:form>
							</div>
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-ui-datepicker/jquery-ui-datepicker.min.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() {"use strict";  _datePicker.init(); _toggleUpdate.init(); });
	  </script>
	</body>
</html>