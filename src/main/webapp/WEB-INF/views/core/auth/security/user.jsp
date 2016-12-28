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
	              <a href='<spring:url value="/security/user"/>'>User</a>
	            </li>
	          </ol>
	        </div>
<!-- 	        <div class="topbar-right mt-5"> -->
<!-- 	          <div class="ib topbar-dropdown"> -->
<!-- 	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">User</label> -->
<!-- 	          </div> -->
<!-- 	        </div> -->
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
			
	        <div class="row">
<!--  			  <s:if test="hasActionMessages()">
	        	<div class="col-md-12">	
					<div class="section animated fadeIn">
						<div class="alert alert-success alert-dismissable mt10">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>								  
							<s:iterator value="actionMessages">
								<span><s:property escapeHtml="false" />
								</span>
							</s:iterator> 
						</div>
					</div>
				</div>
			  </s:if>	
 			  <s:if test="hasActionErrors()">
	        	<div class="col-md-12">	
					<div class="section animated fadeIn">
						<div class="alert alert-danger alert-dismissable mt10">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							<i class="fa fa-check-circle fa-2x pr10 va-middle"></i>								  
							<s:iterator value="actionErrors">
								<span><s:property escapeHtml="false" />
								</span>
							</s:iterator> 
						</div>
					</div>
				</div>
			  </s:if>		 -->		          
	        	<div class="col-md-12">
	        	 	<div class="panel panel-visible bt-green" id="spy1">
	        	 		<div class="panel-body">
	        	 			<div class="col-md-9">
                                 <div class="forum-icon">
                                     <i class="fa fa-users"></i>
                                  </div>
                                  <span class="forum-item-title"><spring:message code="user.header"/></span>
                                  <div class="forum-sub-title"><spring:message code="user.subheader"/></div>
                             </div>
                             <div class="col-md-3">
	        	           		<button type="button" data-toggle="modal" data-target="#user_modal" class="btn btn-success br3 fw600 pull-right"><span class="fa fa-plus"></span> <spring:message code="user.add"/> </button>
	        	           	</div>	
	        	 		</div>
	        	 	</div>
	        	</div>
	          <div class="col-md-12">
              <div class="panel panel-visible bt-yellow" id="spy1">
<!--                 <div class="panel-heading"> -->
<!--                   <div class="panel-title hidden-xs"> -->
<%--                     <span class="glyphicon glyphicon-tasks"></span>Basic Datatable</div> --%>
<!--                 </div> -->
                <div class="panel-body">
                 <spring:url value="/security/user/update" var="url"/>
                 <spring:url value="/security/user/reset" var="urlReset"/>
                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
                    <thead>
                      <tr>
                      	<th>No</th>
                        <th>User Full Name</th>
                        <th>Role</th>
                        <th>Email</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Edit</th>
                        <th>Delete</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="counter">
                       <c:forEach items="${user.role}" var="role">
                            <c:set value="${role.strRoleName}" var="roleName"/>
                            <c:set value="${role.intRoleId}" var="roleId"/>
                       	</c:forEach>   
                     <tr>
                      	<td>${counter.index+1}</td>
                        <td>${user.strFirstName} ${user.strLastName}</td>  
                        <td>${roleName}</td>          
                        <td>${user.strEmail}</td>
                        <td>${user.strUserName}</td>
                        <td><a href="#" class="td-none sr-reset" data-toggle="modal" data-target="#password_reset_modal" data-action="${urlReset}/${user.intUserId}" ><i class="fa fa-unlock-alt"></i> Reset</a></td>
                        <td><input type="hidden" name="sr-prop" class="sr-info" value='{"strFirstName":"${user.strFirstName}","strLastName":"${user.strLastName}","strEmail":"${user.strEmail}","intRoleId":"${roleId}","strDeptName":"${user.strDeptName}","strUserName":"${user.strUserName}","boolPwdChange":"${user.boolPwdChange}","boolLockPwd":"${user.boolLockPwd}","intPwdAttempt":"${user.intPwdAttempt}"}'/><a href="#" class="sr-update" data-action="${url}/${user.intUserId}" data-toggle="modal" data-target="#user_modal"><span class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a class="dr-confirm no-loader" data-content= "This will remove <b><code>${user.strUserName}</code></b> from the users permanantly .Continue deleting?" data-title="Delete User" href="<spring:url value="/security/user/delete"/>/${user.intUserId}"><span class="glyphicon glyphicon-trash">&nbsp;</span></a></td>
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
		<div class="modal fade" id="user_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header gradient-1">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel"><span class="fa fa-user-plus"></span><span class="head_text"> New User</span></h4>
		      </div>
		      <div class="modal-body pt0 gradient-1-modal-body">
		                    <spring:url value="/security/user/add" var="url_alt"/>
		                    <input type="hidden" name="url_add" id="url_add" value="${url_alt}"/>      
							<div class="mpxd theme-primary mw1000 center-block">
								<form:form method="POST" action="${url_alt}" id="user-form" modelAttribute="user">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> Provide the following information to create new user </span>
										</div>
										<!-- .section-divider -->
										<div class="col-md-6 pl0">
											<spring:bind path="strFirstName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strFirstName" /> 
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
											   		<span class="field-alt fw600">
														<spring:message code="user.firstname"/> <div class="ico-help" title="First Name of the user."><i class="fa fa-question-circle"></i></div>
													</span>	
											   </c:if>								
												<div class="section">												
													<label for="strFirstName" class="field prepend-icon"> 														
													   	<form:input path="strFirstName" id="strFirstName" cssClass="gui-input br5" placeholder="First Name"></form:input>
															<label for="strFirstName" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>												
													</label>
												</div>
											</spring:bind>	
										</div>
										<div class="col-md-6 pr0">																		 
											<spring:bind path="strLastName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strLastName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.lastname"/> <div class="ico-help" title="Last Name of the user."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="strLastName" class="field prepend-icon"> 
													   <form:input path="strLastName" id="strLastName" cssClass="gui-input br5" placeholder="Last Name"></form:input>
															<label for="strLastName" class="field-icon"> 
																<i class="glyphicon glyphicon-pencil"></i>
															</label>
													</label>
												</div>
											</spring:bind>
										</div>
										<!-- <div class="col-md-12">		 -->
										<div class="col-md-6 pl0">																				 
											<spring:bind path="strEmail">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strEmail" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.email"/> <div class="ico-help" title="Current active Email Address."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
											<div class="section">
												<label for="strEmail" class="field prepend-icon"> 
												<form:input path="strEmail" id="strEmail" cssClass="gui-input br5" placeholder="Email Address (Ex:Muhammadhilmi@mrt.com)"/>
													<label for="strEmail" class="field-icon"> 
														<i class="fa fa-envelope"></i>
													</label>
												</label>										
											</div>
											</spring:bind>
										</div>
										<!-- end section -->
										<div class="col-md-6 pr0">
											<spring:bind path="intRoleId">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="intRoleId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.role"/> <div class="ico-help" title="User Role."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
						                          <label class="field select">
						                          <span></span>
						                          	<form:select path="intRoleId">
						                          		<form:option value="" label="Please Select" selected="selected"/>
	      												<form:options items="${rolesOptions}" itemValue="intRoleId" itemLabel="strRoleName"/>
						                          	</form:select>
						                            <i class="arrow double"></i>
						                          </label>				                          
						                        </div>
					                        </spring:bind>
											<!-- end section -->
										</div>
										<div class="col-md-6 pl0">
											<spring:bind path="strDeptName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strDeptName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.department"/> <div class="ico-help" title="Department user belongs to."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
													<label for="strDeptName" class="field prepend-icon"> 
														<form:input path="strDeptName" id="strDeptName" cssClass="gui-input br5" placeholder="Department (Ex:Strategic & Planning)"></form:input>
														<label for="strDeptName" class="field-icon"> 
															<i class="fa fa-university"></i>
														</label>
													</label>													
												</div>
											</spring:bind>
										</div>
										<!-- end section -->
										<div class="col-md-6 pr0">
											<spring:bind path="strUserName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strUserName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.username"/> <div class="ico-help" title="Username (This is used for login)."><i class="fa fa-question-circle"></i></div>
												</span>
											   </c:if>	
												<div class="section">
													<label for="strUserName" class="field prepend-icon">
														<form:input path="strUserName" id="strUserName" cssClass="gui-input br5" placeholder="Username"></form:input> 
														<label for="strUserName" class="field-icon"> 
															<i class="fa fa-user"></i>
														</label>
													</label>													
												</div>
											</spring:bind>
											<!-- end section -->
										</div>
										<div class="col-md-6 pr0">
											<div class="section">
												<label for="boolPwdChange pr0">
		                              				<form:checkbox path="boolPwdChange" id="boolPwdChange" value="1" checked="checked"/>
		                              				<spring:message code="user.request.change.password"/>
		                              			</label>			                              			
		                              		</div>
										</div>
										<div class="col-md-6 pr0">
										</div>
										<div class="col-md-12 pr0">
											<div class="section">
												<label class="boolLockPwd pr0">
		                              				<form:checkbox path="boolLockPwd" id="boolLockPwd" value="1" checked="checked"/>
		                              				<spring:message code="user.request.activate1"/>                        
		                              			</label>
		                              			<form:input path="intPwdAttempt" id="intPwdAttempt" cssClass="gui-input br5 mt-10 w55" value="5" placeholder="5" readonly="true"></form:input>
		                              			<span><spring:message code="user.request.activate2"/></span>	
		                              		</div>
										</div>
										<!-- end section -->
										<!-- </div> -->
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Add User</span></button>
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
		  <spring:hasBindErrors name="user">
		 	 <input type="hidden" name="has_error" id="has_field_error" value="1">
		  </spring:hasBindErrors>
		</div>
		<div class="modal fade" id="password_reset_modal" tabindex="-1" role="dialog" aria-labelledby="myMediumModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-md">
		    <div class="modal-content">
		      <div class="modal-header gradient-2">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="password_resetLabel"><span class="fa fa-unlock-alt"></span> Reset Password</h4>
		      </div>
		      <div class="modal-body pt0 gradient-2-modal-body">
					<div class="mpxd theme-primary mw1000 center-block">
							<spring:url value="/security/user/change" var="url_cpass"/>
								<form:form method="POST" action="${url_cpass}" id="reset-password-form" modelAttribute="user">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> Provide the following information to Reset Password </span>
										</div>
										<!-- .section-divider -->
										<div class="col-md-12 pl0">
<!-- 											<s:if test="fieldErrors.get('strPassword').size() > 0">
												<span class="field-error">
													<s:property value="fieldErrors.get('strFirstName').get(0)" />
												</span>	
											</s:if>
											<s:else> -->
												<span class="field-alt fw600">
													Password <div class="ico-help" title="New Password for the User."><i class="fa fa-question-circle"></i></div>
												</span>													
<!-- 											</s:else> -->
											<div class="section">												
												<label for="strPassword" class="field prepend-icon"> 														
												   	<form:password path="strPassword" id="strPassword" cssClass="gui-input br5" placeholder="Password"></form:password>
														<label for="strPassword" class="field-icon"> 
															<i class="fa fa-lock"></i>
														</label>												
												</label>
											</div>
<!-- 										</div> -->
<!-- 										<div class="col-md-6 pr0"> -->
<!-- 											<s:if test="fieldErrors.get('strRePassword').size() > 0">
												<span class="field-error">
													<s:property value="fieldErrors.get('strRePassword').get(0)" />
												</span>	
											</s:if>
											<s:else> -->
												<span class="field-alt fw600">
													Confirm Password <div class="ico-help" title="Confirm the new password."><i class="fa fa-question-circle"></i></div>
												</span>																							
<!-- 											</s:else>																		 -->
											<div class="section">
												<label for="strRePassword" class="field prepend-icon"> 
												   <form:password path="strRePassword" id="strRePassword" cssClass="gui-input br5" placeholder="Confirm Password"></form:password>
														<label for="strLastName" class="field-icon"> 
															<i class="fa fa-lock"></i>
														</label>
												</label>
											</div>
										</div>
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save</span></button>
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
	  <!-- BEGIN: PAGE SCRIPTS -->	
	  <!-- jQuery -->
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery2.2.4.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-ui.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/util.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/dataTables/jquery.dataTables.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/user.js"></script>	  
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>