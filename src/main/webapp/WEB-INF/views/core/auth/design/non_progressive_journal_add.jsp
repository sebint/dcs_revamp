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
		<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval()%>;url=logout"/>
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
	              <a href='<spring:url value="/design/non-progressive/"/>'>Non-Progressive Journal</a>
	            </li>
	            <li class="crumb-link">
	            	<a class="t-t-capt" href='<spring:url value="/design/non-progressive/${!empty(journalUrl)? journalUrl :  'new'}"/>'>${!empty(journalUrl)? (fn:replace(fn:toLowerCase(journalName),'-', ' ')) :  'New'}</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Non-Progressive Journal</label>
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
	            <div class="panel panel-visible" id="spy1">
                	<div class="panel-body">
	                	<div class="well-box" id="${!empty(journalUrl)? 'view-port' :  'update-port'}" style="${empty(journalUrl)? 'display: none;' :  ''}">
							<div id="search" class="tab-pane active search-results-page">					
			                    <!-- Begin Search Result Entries -->
			                    <div class="search-result">
			                    <jsp:useBean id="now" class="java.util.Date" scope="request"/>
			                    <fmt:parseNumber value="${ now.time / (1000*60*60*24) }" integerOnly="true" var="nowDays" scope="request"/>
			                    <fmt:parseNumber value="${ nonprogressive.dtDateCreated.time / (1000*60*60*24) }" integerOnly="true" var="otherDays" scope="page"/>
			                    <c:set value="${nowDays - otherDays}" var="dateDiff"/>
				                    <div class="view-header">
										<div class="media">
					                      <a class="pull-left" href="#"> <img class="media-object mn thumbnail thumbnail-sm rounded mw50" src="${pageContext.request.contextPath}/resources/img/head-logo/journal.png" alt="..."> </a>
					                      <div class="media-body mb5">
					                        <h5 class="media-heading view-title">${nonprogressive.journalName}
					                          <small class="view-sub-title"> - Created <a title="<fmt:formatDate value="${nonprogressive.dtDateCreated}" pattern="dd-MMM-YYYY hh:mm:ss" />">
					                          <c:choose>
												    <c:when test="${dateDiff eq 0}">today</c:when>
												    <c:when test="${dateDiff eq 1}">yesterday</c:when>
												    <c:otherwise>${dateDiff} day(s) ago</c:otherwise>
											  </c:choose></a> by <a href='<spring:url value="/security/user/${nonprogressive.createdUser.strUserName}"/>' class="t-t-capt">${nonprogressive.createdUser.strFirstName} ${nonprogressive.createdUser.strLastName}</a></small>
					                        </h5>
					                        <p>Project : <a href="#"><i class="fa fa fa-caret-right"></i> ${nonprogressive.project.projectName}</a></p>
					                      </div>
					                    </div>		
					                    <c:set var="rand" value="${100+random.nextInt(1000-(100+1))}"/>		                    
				                    	<div class="panel-header-menu pull-right mt-45">
				                    		<div class="btn-group mb10">
						                      <a class="btn btn-default light no-loader btn-update" title="Edit Journal">
						                        <i class="fa fa-edit"></i>
						                      </a>
						                      <a class="btn btn-default light dr-confirm no-loader" title="Delete Journal" data-content= "This will remove <b><code>${nonprogressive.journalName}</code></b> permanantly .Continue deleting?" data-title="Delete Non Progressive Journal" href="<spring:url value="/design/non-progressive/delete"/>/${rand}${nonprogressive.nonProgressiveMasterId}">
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
						                            <a href="<spring:url value="/design/non-progressive/new" />">
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
								                      <td  width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Journal Owner <span class="pull-right">:</span></strong></td>
								                      <td>${nonprogressive.user.strFirstName} ${nonprogressive.user.strLastName}</td>
								                    </tr>
								                    <tr>
								                      <td width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Validator <span class="pull-right">:</span></strong></td>
								                      <td>${nonprogressive.validator.strFirstName} ${nonprogressive.validator.strLastName}</td>
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
								                      <td width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Data Entry <span class="pull-right">:</span></strong></td>
								                      <td>${nonprogressive.dataentry.strFirstName} ${nonprogressive.dataentry.strLastName}</td>
								                    </tr>
								                    <tr>
								                      <td width="40%"><i class="fa fa-exclamation-circle text-primary fa-lg pr10"></i> <strong>Created On <span class="pull-right">:</span></strong></td>
								                      <td><fmt:formatDate value="${nonprogressive.dtDateCreated}" pattern="dd-MMM-YYYY" /></td>
								                    </tr>
								                  </tbody>
								                </table>
							                </div>
						                  </div>
						                </div>
									</div>
									<ul class="result-meta mt25 pull-right">
			                          <li><i class="glyphicon glyphicon-time"></i> Last Modified on <code><fmt:formatDate value="${nonprogressive.dtDateModified}" pattern="dd-MMM-YYYY" /></code> by <code>${nonprogressive.modifiedUser.strFirstName} ${nonprogressive.modifiedUser.strLastName}</code></li>
			                       </ul>
			                    </div>
			                   
			                </div>	
			               <hr>
			               <h5>DATA HISTORY</h5>
			                <figure class="highlight">
								<div class="panel b-none">
								  <div class="panel-body b-none">
								    <div class="tab-content pn br-n">
								      <div id="tab2_1" class="tab-pane active">
								        <div class="row">
								        <spring:url value="/design/non-progressive" var="journal_design"/>
											<div class="table-responsive">
								                <table class="table table-striped table-hover table-bordered" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
								               		<thead>
								               			<tr class="bg-light">
								               				<th>Data Date</th>
								               				<th>Data Entry</th>
								               				<th>Validated(Yes/No)</th>
								               				<th>Status</th>
								               			</tr>
								               		</thead>
										            <tbody>
								            			<tr>
								            				<td colspan="5" class="text-center">No Data History found.Click <a href="${journal_design}/${fn:replace(fn:toLowerCase(nonprogressive.journalName),' ', '-')}-${rand}${nonprogressive.project.projectMasterId}/design">Here</a> to Add New Data.</td>
								            			</tr>
								                  </tbody>
								                </table>
								              </div>							        
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
							</figure>							
					       <hr class="short alt">			
	                  	</div>     
	                  	<div class="well-box ${!empty(journalUrl)? 'well-edit' :  ''}" style="${!empty(journalUrl)? 'display: none;' :  ''}" id="${!empty(journalUrl)? 'update-port' :  'view-port'}">           	
	                       	<c:choose>
	                			<c:when test="${!empty(journalUrl)}">
	                				<spring:url value="/design/non-progressive/${journalUrl}" var="url_alt"/>
	                			</c:when>
	                			<c:otherwise>
	                				<spring:url value="/design/non-progressive/new" var="url_alt"/>
	                			</c:otherwise>
	                		</c:choose>
							<div class="mpxd theme-primary mw1000 center-block">
								<form:form method="post" action="${url_alt}" id="user-form" modelAttribute="nonprogressive">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> <spring:message code="npj.new.info"/> </span>
										</div>
										<!-- .section-divider -->
										<div class="col-md-6">
											<spring:bind path="projectMasterId">
											   <c:if test="${status.error}">
											   		<span class="field-error ${projectMasterId.error}" >
													<form:errors path="projectMasterId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
											   		<span class="field-alt fw600">
														<spring:message code="npj.new.projectname"/> <span class="text-danger">*</span> <div class="ico-help" title="Select the Project Name."><i class="fa fa-question-circle"></i></div>
													</span>	
											   </c:if>								
												<div class="section">												
													<label class="field select">
														<form:select path="projectMasterId">
						                          			<form:option value="" label="Please Select" selected="selected"/>
						                          			<form:options items="${projectList}" itemValue="projectMasterId" itemLabel="projectName" />
						                          		</form:select> 	
						                          		<i class="arrow double"></i>																							
													</label>
												</div>
											</spring:bind>	
										</div>
										<form:hidden path="nonProgressiveMasterId"/>
										<div class="col-md-6">																		 
											<spring:bind path="journalName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="journalName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.journalname"/> <div class="ico-help" title="Name your new Journal."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="journalName" class="field prepend-icon"> 
													   <form:input path="journalName" id="journalName" cssClass="gui-input br5" placeholder="Journal Name"></form:input>
															<label for="journalName" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>
										</div>
										<!-- <div class="col-md-12">		 -->
										<div class="col-md-6">																				 
											<spring:bind path="jounralOwner">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="jounralOwner" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.owner"/> <div class="ico-help" title="Select the Journal Owner."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
											<div class="section">
												<label class="field select">
													<form:select path="jounralOwner">
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
											<spring:bind path="validatorId">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="validatorId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.validator"/> <div class="ico-help" title="Select the Validator."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
						                          <label class="field select">
													<form:select path="validatorId">
					                          			<form:option value="" label="Please Select" selected="selected"/>
					                          			<form:options items="${userList}" itemValue="intUserId" itemLabel="strUserName"/>
					                          		</form:select> 
					                          		<i class="arrow double"></i>
						                          </label>				                          
						                        </div>
					                        </spring:bind>
											<!-- end section -->
										</div>
										<spring:bind path="dataEntryId">
											<div class="${!optn ? 'col-md-6' : 'col-md-12'}">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="dataEntryId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.dataentryuser"/> <div class="ico-help" title="Selec the Data Entry."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
													<label class="field select">
														<form:select path="dataEntryId">
						                          			<form:option value="" label="Please Select" selected="selected"/>
						                          			<form:options items="${userList}" itemValue="intUserId" itemLabel="strUserName"/>
						                          		</form:select> 
						                          		<i class="arrow double"></i>
													</label>													
												</div>											
											</div>
										</spring:bind>
										<!-- end section -->
										<spring:bind path="reminderFreq">
										<c:if test="${!optn}">
											<div class="col-md-6">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="reminderFreq" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="npj.new.reminderfrequency"/> <div class="ico-help" title="Select the reminder Frequency."><i class="fa fa-question-circle"></i></div>
												</span>
											   </c:if>	
												<div class="section">
													<label class="field select">
														<form:select path="reminderFreq">
						                          			<form:option value="" label="Please Select" selected="selected"/>
						                          			<form:options items="${frequencyList}" itemValue="frequencyMasterId" itemLabel="frequencyName"/>
						                          		</form:select> 
						                          		<i class="arrow double"></i>
													</label>													
												</div>									
										<!-- end section -->
											</div>
											</c:if>
										</spring:bind>	
										<!-- end section -->
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" name="mode" value="save" class="button btn-success br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save</span></button>
										<button type="submit" name="mode" value="save_continue" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save and Continue</span></button>
											<spring:url value="/design/non-progressive" var="list_url"></spring:url>
										<a href="${!empty(journalUrl)? '#' :  list_url}" class="button br3 btn-cancel">
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
<%-- 	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/user.js"></script>	  --%> 
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() {"use strict"; _toggleUpdate.init(); _confirm.init(); });
	  </script>	  
	</body>
</html>