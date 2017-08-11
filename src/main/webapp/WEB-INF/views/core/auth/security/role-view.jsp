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
	            <li class="crumb-trail">Security</li>
	            <li class="crumb-link">
	              <a href='<spring:url value="/security/role"/>'>Roles</a>
	            </li>
	            <li class="crumb-link">
	              <a class="t-t-capt" href='<spring:url value="/security/role/${strRoleName}"/>'>${fn:replace(fn:toLowerCase(strRoleName),'-', ' ')}</a>
	            </li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	             <label for="topbar-multiple" class="control-label pr10 fs20 text-muted t-t-capt">
					${fn:replace(fn:toLowerCase(strRoleName),'-', ' ')}
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
	                	<div class="well-box" id="${!empty(strRoleName)? 'view-port' :  'update-port'}" style="${empty(strRoleName)? 'display: none;' :  ''}">
							<div id="search" class="tab-pane active search-results-page">					
			                    <!-- Begin Search Result Entries -->
			                    <div class="search-result">
			                    <jsp:useBean id="now" class="java.util.Date" scope="request"/>
			                    <fmt:parseNumber value="${ now.time / (1000*60*60*24) }" integerOnly="true" var="nowDays" scope="request"/>
			                    <fmt:parseNumber value="${ role.dtDateCreated.time / (1000*60*60*24) }" integerOnly="true" var="otherDays" scope="page"/>
			                    <c:set value="${nowDays - otherDays}" var="dateDiff"/>
				                    <div class="view-header">
										<div class="media">
					                      <a class="pull-left" href="#"> <img class="media-object mn thumbnail thumbnail-sm rounded mw50" src="${pageContext.request.contextPath}/resources/img/head-logo/role.png" alt="..."> </a>
					                      <div class="media-body mb5">
					                        <h5 class="media-heading view-title">${role.strRoleName}
					                          <small class="view-sub-title"> - Created <a title="<fmt:formatDate value="${role.dtDateCreated}" pattern="dd-MMM-YYYY hh:mm:ss" />">
					                          <c:choose>
												    <c:when test="${dateDiff eq 0}">today</c:when>
												    <c:when test="${dateDiff eq 1}">yesterday</c:when>
												    <c:when test="${(dateDiff gt 31)and(dateDiff lt 365)}"><fmt:parseNumber value="${dateDiff/30}" integerOnly="true" var="months" scope="page"/>${months} month(s) ago</c:when>
												    <c:when test="${dateDiff ge 365}"><fmt:parseNumber value="${dateDiff/365}" integerOnly="true" var="years" scope="page"/>${years} year(s) ago</c:when>
												    <c:otherwise>${dateDiff} day(s) ago</c:otherwise>
											  </c:choose></a> by <a href='<spring:url value="/security/user/${role.strRoleName}"/>' class="t-t-capt">${role.strRoleName}</a></small>
					                        </h5>
					                        <p> ${role.strRoleDesc}</p>
					                      </div>
					                    </div>				                    
				                    	<div class="panel-header-menu pull-right mt-45">
				                    		<div class="btn-group mb10">
						                      <a class="btn btn-default light no-loader btn-update" title="Edit Role">
						                        <i class="fa fa-edit"></i>
						                      </a>
						                      <a class="btn btn-default light dr-confirm no-loader" title="Delete Role" data-content= "This will remove <b><code>${role.strRoleName}</code></b> from the Roles permanantly .Continue deleting?" data-title="Delete Role" href="<spring:url value="/security/role/delete"/>/${role.intRoleId}">
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
						                            <a href="<spring:url value="/design/templates/new" />">
						                              <span class="fa fa-plus pr5"></span> Create New</a>
						                          </li>
						                        </ul>
						                    </div>
							            </div>
				                    </div>
			                       <hr class="short alt">
			                       <spring:url value="/security/role/${strRoleName}" var="url"/>
			                       <div class="row mpxd">
			                       	  <form:form method="post" action="${url}" id="role-perm-form">
										<div class="bg-light">
										 <figure class="highlight">
										       <div style="max-height: 400px; overflow-y: scroll; ">
										       <div class="table-responsive">
										      	<table class="table table-striped table-hover margin-t-b15">
															<thead>
																<tr>
																	<th>Object Name</th>
																	<th width="8%">View</th>
																	<th width="8%">Add</th>
																	<th width="8%">Edit</th>
																	<th width="8%">Delete</th>
																	<th width="8%">Export</th>
																	<th width="8%">Print</th>
																	<th width="8%">Email</th>
																</tr>
																<tr>
																	<th></th>
																	<th>
																		<label class="block switch switch-primary">
<%-- 																		<form:checkbox path="strRoleName" id="view_opt" value="all"/> --%>
												                          <input type="checkbox" name="tools" class="checkall" id="view_opt" data-corr="viewp" value="admin">
												                          <label for="view_opt" data-on="YES" data-off="NO"></label>
												                        </label>		                              			
																	</th>
																	<th>
																		<label class="block switch switch-primary">
												                          <input type="checkbox" name="tools" class="checkall" id="add_opt" data-corr="addp" value="admin">
												                          <label for="add_opt" data-on="YES" data-off="NO"></label>
												                        </label>
																	</th>
																	<th>
																		<label class="block switch switch-primary">
												                          <input type="checkbox" name="tools" class="checkall" id="edit_opt" data-corr="editp" value="admin">
												                          <label for="edit_opt" data-on="YES" data-off="NO"></label>
												                        </label>
																	</th>
																	<th>
																		<label class="block switch switch-primary">
												                          <input type="checkbox" name="tools" class="checkall" id="delete_opt" data-corr="deletep" value="admin">
												                          <label for="delete_opt" data-on="YES" data-off="NO"></label>
												                        </label>
																	</th>
																	<th>
																		<label class="block switch switch-primary">
												                          <input type="checkbox" name="tools" class="checkall" id="export_opt" data-corr="exportp" value="admin">
												                          <label for="export_opt" data-on="YES" data-off="NO"></label>
												                        </label>
																	</th>
																	<th>
																		<label class="block switch switch-primary">
												                          <input type="checkbox" name="tools" class="checkall" id="print_opt" data-corr="printp" value="admin">
												                          <label for="print_opt" data-on="YES" data-off="NO"></label>
												                        </label>
																	</th>
																	<th>
																		<label class="block switch switch-primary">
												                          <input type="checkbox" name="tools" class="checkall" id="email_opt" data-corr="emailp" value="admin">
												                          <label for="email_opt" data-on="YES" data-off="NO"></label>
												                        </label>
																	</th>																	
																</tr>
								        					</thead>
															<tbody>
																<c:forEach items="${object}" var="menu" varStatus="menuCounter">	
																	<tr>
																		<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">${menu.strMenuName}</th>
																	</tr>
																		<c:if test="${fn:length(menu.subMenu) gt 0}">
																			 <c:forEach items="${menu.subMenu}" var="submenu" varStatus="subMenuCounter">
																				<tr>
																					<td>${submenu.strMenuName}</td>
																					<td>
	<!-- 																					<label for="1_1"> -->
	<!-- 																							<input type="checkbox" name="1_1" id="1_1" value="1">  -->
	<!-- 																					</label>					 -->
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="view_${menuCounter.index+1}${subMenuCounter.index+1}" class="viewp s_m" data-corr="view_opt" value="admin">
																                          <label for="view_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>	
																					</td>
																					<td>
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="add_${menuCounter.index+1}${subMenuCounter.index+1}" class="addp s_m" data-corr="add_opt" value="admin">
																                          <label for="add_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>									
																					</td>
																					<td>
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="edit_${menuCounter.index+1}${subMenuCounter.index+1}" class="editp s_m" data-corr="edit_opt" value="admin">
																                          <label for="edit_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>									
																					</td>
																					<td>
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="delete_${menuCounter.index+1}${subMenuCounter.index+1}" class="deletep s_m" data-corr="delete_opt" value="admin">
																                          <label for="delete_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>									
																					</td>
																					<td>
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="export_${menuCounter.index+1}${subMenuCounter.index+1}" class="exportp s_m" data-corr="export_opt" value="admin">
																                          <label for="export_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>								
																				    </td>
																					<td>
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="print_${menuCounter.index+1}${subMenuCounter.index+1}" class="printp s_m" data-corr="print_opt" value="admin">
																                          <label for="print_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>
																					</td>
																					<td>
																						<label class="block switch switch-primary">
																                          <input type="checkbox" name="tools" id="email_${menuCounter.index+1}${subMenuCounter.index+1}" class="emailp s_m" data-corr="email_opt" value="admin">
																                          <label for="email_${menuCounter.index+1}${subMenuCounter.index+1}" data-on="YES" data-off="NO"></label>
																                        </label>																													
																					</td>
																				</tr>
																			</c:forEach>
																	</c:if>
																</c:forEach>								
															</tbody>
														</table>
													  </div>	
											     </div>										 
										 </figure>
											<div class="text-right">
												<button type="submit" class="btn btn-sm btn-primary br3"><i class="fa fa-check"></i> 
													<span class="btn-text">Save</span></button>
												<a href="/dcs/security/role" class="btn btn-sm btn-default br3 btn-cancel">
													<i class="fa fa-close"></i> Cancel
									   			</a>
											</div>
						                </div>
						                </form:form>
									</div>
			                    </div>
			                </div>	
			               <hr>
			               <figure class="highlight">
			               <h5>Users with <span class="t-t-capt">${fn:replace(fn:toLowerCase(strRoleName),'-', ' ')}</span> Privilege</h5>
							<div class="panel b-none">
							  <div class="panel-body b-none">
							        <div class="row">
							        <spring:url value="/design/non-progressive/new" var="journal_add"/>
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
<%-- 									            	<c:choose>
									            		<c:when test="${fn:length(nonProgressiveList) gt 0}">
											              <c:forEach items="${journal}" var="journal" varStatus="counter">
												              <tr class="message-unread">
												                <td>${journal.journalName}</td>
												                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
												                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
												                <td>${journal.user.strFirstName} ${journal.user.strLastName}</td>
												                <td><span class="label label-success">IN PROGRESS</span></td>
												              </tr>
											              </c:forEach>									            		
									            		</c:when>
									            		<c:otherwise>
									            			<tr>
									            				<td colspan="5" class="text-center">No Journals found.Click <a href="${journal_add}">Here</a> to Add.</td>
									            			</tr>
									            		</c:otherwise>
									            	</c:choose> --%>
							                  </tbody>
							                </table>
							              </div>							        
							        </div>
							      </div>
							</div>	
							</figure>				
					       <hr class="short alt">			
	                  	</div>
	                  <div class="well-box ${!empty(strRoleName)? 'well-edit' :  ''}" style="${!empty(strRoleName)? 'display: none;' :  ''}" id="${!empty(strRoleName)? 'update-port' :  'view-port'}">
                	 		<c:choose>
	                			<c:when test="${!empty(strRoleName)}">
	                				<c:set var="prj_sub_info"><spring:message code="prj.update.info"/></c:set>
	                				<spring:url value="/design/templates/${strRoleName}" var="url_alt"/>
	                			</c:when>
	                			<c:otherwise>
	                				<c:set var="prj_sub_info"><spring:message code="prj.new.info"/></c:set>
	                				<spring:url value="/design/templates/new" var="url_alt"/>
	                			</c:otherwise>
	                		</c:choose>
							<div class="mpxd theme-primary mw1000 center-block">								
								<form:form method="post" action="/security/role/add" id="role-form" modelAttribute="role">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text">Provide the following information to create new role</span>
										</div>
										<!-- .section-divider -->
										<div class="section">
											<span class="field-alt fw600">
												New Role <div class="ico-help" title="New Role Name"><i class="fa fa-question-circle"></i></div>
											</span>	
											<label for="strRoleName" class="field prepend-icon"> 
											   <form:input path="strRoleName" id="strRoleName" cssClass="gui-input br5" placeholder="New Role"/>
													<label for="strRoleName" class="field-icon"> 
														<i class="glyphicon glyphicon-education"></i>
													</label>
											</label>
										</div>
										<div class="section">
											<span class="field-alt fw600">
												Description <div class="ico-help" title="Describe the role functonality."><i class="fa fa-question-circle"></i></div>
											</span>											
											<label for="strRoleDesc" class="field prepend-icon"> 
											   <form:input path="strRoleDesc" id="strRoleDesc" cssClass="gui-input br5" placeholder="Role Description"/>
													<label for="strRoleDesc" class="field-icon"> 
														<i class="glyphicon glyphicon-pencil"></i>
													</label>
											</label>
										</div>
										<div class="section">
											<span class="field-alt fw600">
												Home Page <div class="ico-help" title="Home page for this role."><i class="fa fa-question-circle"></i></div>
											</span>	
											 <label class="field select">
											 <form:select path="intRoleHome">
											 		<form:option value="" label="Please Select" selected="selected"/>
											 		<c:forEach items="${listPages}" var="pages">
											 			<form:option value="${pages.intMenuSubId}">${pages.menu.strMenuName } >> ${pages.strMenuName }</form:option>											 			
											 		</c:forEach>
						                          	<%-- <form:options items="${menuOptions}" itemValue="intMenuMasterId" itemLabel="strMenuName"/>  --%>
											 </form:select>
<!-- 											  <s:select key="intRoleHome" id="intRoleHome"
													headerKey="-1" headerValue="Select Home url"
														list="lstMenu" listKey="intMenuMasterId" 
											       			listValue="strMenuName" />  -->
												<i class="arrow double"></i>
											</label>	                           								
										</div>
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Add Role</span></button>
										<button type="reset" data-dismiss="modal" class="button br3">
											<i class="fa fa-close"></i> Cancel
									   </button>
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-ui-datepicker/jquery-ui-datepicker.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() {"use strict";  _datePicker.init(); _toggleUpdate.init(); _confirm.init(); });
	  $('.checkall').click(function(event){ //on click
		  var $corr = $(this).data("corr");			
		    if(this.checked){ // check select status
				$('.'+$corr).each(function(){ //loop through each checkbox
					this.checked = true;  //select all checkboxes with class "checkbox1"
		        });
			}else{
				$('.'+$corr).each(function(){ //loop through each checkbox
					this.checked = false; //deselect all checkboxes with class "checkbox1"
		        });
			}
		 });
	   $('.s_m').click(function(event){
		   var $corr = $(this).data("corr");
		   var $first = $(this).attr('class').split(" ")[0];
		   var numItems = $('.'+$first).length;
		   var count = 0;
			$('.'+$first).each(function(){ //loop through each checkbox
				if($(this).is(":checked")){
					count++;
				}
	        });
			if(numItems == count){
				$('#'+$corr).prop('checked', true);
			}else{
				$('#'+$corr).prop('checked', false);
			}
	   });
	  </script>
	</body>
</html>