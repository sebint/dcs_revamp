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
	        	           		<%-- <button type="button" data-toggle="modal" data-target="#user_modal" class="btn btn-success br3 fw600 pull-right"><span class="fa fa-plus"></span> <spring:message code="user.add"/> </button> --%>
	        	           		<a href="<spring:url value="/security/user/new" />" class="btn btn-success br3 fw600 pull-right"><span class="fa fa-plus"></span> <spring:message code="user.add"/> </a>
	        	           	</div>	
	        	 		</div>
	        	 	</div>
	        	</div>
	          <div class="col-md-12">
              <div class="panel panel-visible" id="spy1">
                <div class="panel-body">
                 <spring:url value="/security/user" var="url"/>
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
                        <td><a href="${url}/${user.strUserName}" class="sr-update"><span class="glyphicon glyphicon-edit"></span></a></td>
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