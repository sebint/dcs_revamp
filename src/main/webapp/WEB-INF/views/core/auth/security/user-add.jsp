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
	            <li class="crumb-link">
	              <a href='<spring:url value="/security/user/${!empty(strUserName)? strUserName :  'new'}"/>'>${!empty(strUserName)? strUserName :  'New'}</a>
	            </li>
	          </ol>
	        </div>
 	        <div class="topbar-right mt-5"> 
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">New User</label>
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
                		<c:choose>
                			<c:when test="${!empty(strUserName)}">
                				<spring:url value="/security/user/${strUserName}" var="url_alt"/>
                			</c:when>
                			<c:otherwise>
                				<spring:url value="/security/user/new" var="url_alt"/>
                			</c:otherwise>
                		</c:choose>
							<div class="mpxd theme-primary mw1000 center-block">
								<form:form method="post" action="${url_alt}" id="user-form" modelAttribute="user">
									<div class="panel-body pt0">
										<div class="section-divider mv40" id="spy4">
											<span class="desc_text"> <spring:message code="user.new.info"/> </span>
										</div>
										<!-- .section-divider -->
										<div class="col-md-6">
											<spring:bind path="strFirstName">
											   <c:if test="${status.error}">
											   		<span class="field-error ${strFirstName.error}" >
													<form:errors path="strFirstName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
											   		<span class="field-alt fw600">
														<spring:message code="user.new.firstname"/> <span class="text-danger">*</span> <div class="ico-help" title="First Name of the user."><i class="fa fa-question-circle"></i></div>
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
										<div class="col-md-6">																		 
											<spring:bind path="strLastName">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strLastName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.new.lastname"/> <div class="ico-help" title="Last Name of the user."><i class="fa fa-question-circle"></i></div>
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
										<div class="col-md-6">																				 
											<spring:bind path="strEmail">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strEmail" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.new.email"/> <div class="ico-help" title="Current active Email Address."><i class="fa fa-question-circle"></i></div>
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
										<div class="col-md-6">
											<spring:bind path="intRoleId">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="intRoleId" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.new.role"/> <div class="ico-help" title="User Role."><i class="fa fa-question-circle"></i></div>
												</span>	
											   </c:if>	
												<div class="section">
						                          <label class="field select">
						                          	 <c:forEach items="${user.role}" var="rol"> 
						                          			<c:set value="${rol.intRoleId}" var="roleId"/>
						                          	</c:forEach> 
						                          	<form:select path="intRoleId">
						                          		<form:option value="" label="Please Select" selected="selected"/>
						                          		 <c:choose>
						                          		 	<c:when test="${!empty(user)}">
								                          		<c:forEach items="${rolesOptions}" var="roles">
								                          			<c:if test="${roles.intRoleId eq roleId}">
								                          				<form:option value="${roles.intRoleId}" selected="selected">${roles.strRoleName}</form:option>
								                          			</c:if>
								                          			<c:if test="${roles.intRoleId ne roleId}">
								                          				<form:option value="${roles.intRoleId}">${roles.strRoleName}</form:option>
								                          			</c:if>
								                          		</c:forEach>						                          		 	
						                          		 	</c:when>
						                          		 	<c:otherwise>
																<form:options items="${rolesOptions}" itemValue="intRoleId" itemLabel="strRoleName"/> 
						                          		 	</c:otherwise>
						                          		 </c:choose>							                    
						                          	</form:select>
						                            <i class="arrow double"></i>
						                          </label>				                          
						                        </div>
					                        </spring:bind>
											<!-- end section -->
										</div>
										<spring:bind path="strDeptName">
											<div class="${!optn ? 'col-md-6' : 'col-md-12'}">
											   <c:if test="${status.error}">
											   		<span class="field-error">
														<form:errors path="strDeptName" />
													</span>
											   </c:if>
											   <c:if test="${not status.error}">
												<span class="field-alt fw600">
													<spring:message code="user.new.department"/> <div class="ico-help" title="Department user belongs to."><i class="fa fa-question-circle"></i></div>
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
											</div>
										</spring:bind>
										<!-- end section -->
										<spring:bind path="strUserName">
										<c:if test="${!optn}">
											<div class="col-md-6">
													   <c:if test="${status.error}">
													   		<span class="field-error">
																<form:errors path="strUserName" />
															</span>
													   </c:if>
													   <c:if test="${not status.error}">
														<span class="field-alt fw600">
															<spring:message code="user.new.username"/> <div class="ico-help" title="Username (This is used for login)."><i class="fa fa-question-circle"></i></div>
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
												<!-- end section -->
											</div>
											</c:if>
										</spring:bind>	
										<div class="col-md-6">
											<div class="section">
												<label for="boolPwdChange pr0">
												 <c:choose>
						                          <c:when test="${not empty(user.boolPwdChange)}">
						                          		<c:choose>
						                          			<c:when test="${user.boolPwdChange eq 1}">
						                          				<form:checkbox path="boolPwdChange" id="boolPwdChange" value="1" checked="checked"/>
						                          			</c:when>
						                          			<c:otherwise>
						                          				<form:checkbox path="boolPwdChange" id="boolPwdChange" value="1"/>
						                          			</c:otherwise>
						                          		</c:choose>
						                          	</c:when>
						                          	<c:otherwise>
						                          		<form:checkbox path="boolPwdChange" id="boolPwdChange" value="1" checked="checked"/>
						                          	</c:otherwise>
						                          </c:choose>		                             
		                              				<spring:message code="user.new.request.change.password"/>
		                              			</label>			                              			
		                              		</div>
										</div>
										<div class="col-md-6">
										</div>
										<div class="col-md-12">
											<div class="section">
												<label class="boolLockPwd pr0">
													<c:choose>
						                          		<c:when test="${not empty(user.boolLockPwd)}">
						                          			<c:choose>
						                          				<c:when test="${user.boolLockPwd eq 1}">
						                          					<form:checkbox path="boolLockPwd" id="boolLockPwd" value="1" checked="checked"/>
						                          				</c:when>
						                          				<c:otherwise>
						                          					<form:checkbox path="boolLockPwd" id="boolLockPwd" value="1"/>
						                          				</c:otherwise>
						                          			</c:choose>						                          									                          	
						                          		</c:when>
						                          		<c:otherwise>
						                          			<form:checkbox path="boolLockPwd" id="boolLockPwd" value="1" checked="checked"/>
						                          		</c:otherwise>
						                          	</c:choose>	
		                              				<spring:message code="user.new.request.activate1"/>                        
		                              			</label>
<%-- 		                              			<c:if test="${user.intPwdAttempt eq 0 }">
		                              			
		                              			</c:if> --%>
		                              			<form:input path="intPwdAttempt" id="intPwdAttempt" cssClass="gui-input br5 mt-10 w55" value="${not empty(user.intPwdAttempt)? user.intPwdAttempt : 5}" maxlength="1"></form:input>
		                              			<span><spring:message code="user.new.request.activate2"/></span>	
		                              		</div>
										</div>
										<!-- end section -->
									</div>
									<!-- end .form-body section -->
									<div class="panel-footer text-right">
										<button type="submit" name="mode" value="save" class="button btn-success br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save</span></button>
										<button type="submit" name="mode" value="save_continue" class="button btn-primary br3"><i class="fa fa-check"></i> 
											<span class="btn-text">Save and Continue</span></button>
										<a href="<spring:url value="/security/user/"/>" class="button br3">
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/dataTables/jquery.dataTables.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/user.js"></script>	  
	  <!-- END: PAGE SCRIPTS -->
	</body>
</html>