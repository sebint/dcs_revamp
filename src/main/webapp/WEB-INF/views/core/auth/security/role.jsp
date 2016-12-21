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
		<link rel="stylesheet" type="text/css" href="<spring:url value='../../resources/css/forms-theme.css'/>">
	<head>
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
	              <a href='<spring:url value="/security/role"/>'>Role</a>
	            </li>
	          </ol>
	        </div>
<!-- 	        <div class="topbar-right mt-5"> -->
<!-- 	          <div class="ib topbar-dropdown"> -->
<!-- 	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Role</label> -->
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
			  </s:if> -->
	        	<div class="col-md-12">
	        	 	<div class="panel panel-visible bt-red" id="spy1">
	        	 		<div class="panel-body">
	        	 			<div class="col-md-9">
                                 <div class="forum-icon">
                                     <i class="fa fa-tasks"></i>
                                  </div>
                                  <span class="forum-item-title">Manage Role</span>
                                  <div class="forum-sub-title">Create new roles / Remove existing role.</div>
                             </div>
                             <div class="col-md-3">
	        	           		<button type="button" data-toggle="modal" data-target=".role_modal" class="btn btn-danger br3 fw600 pull-right"><span class="fa fa-plus"></span> Add New Role </button>
	        	           	</div>	
	        	 		</div>
	        	 	</div>
	        	</div>
	          <div class="col-md-12">
              <div class="panel panel-visible bt-gray" id="spy1">
<!--                 <div class="panel-heading"> -->
<!--                   <div class="panel-title hidden-xs"> -->
<%--                     <span class="glyphicon glyphicon-tasks"></span>Basic Datatable</div> --%>
<!--                 </div> -->
                <div class="panel-body">
                <spring:url value="role/update" var="url"/>
                  <table class="table table-striped table-hover" id="datatable" data-bLengthChange="true" data-bSort="true" data-bFilter="true">
                    <thead>
                      <tr>
                        <th>No</th>
                        <th>Role</th>
                        <th>Description</th>
                        <th>Permission</th>
                        <th>Edit</th>
                        <th>Delete</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listRoles}" var="role" varStatus="counter">                   
                      <tr>
                        <td>${counter.index+1}</td>
                        <td>${role.strRoleName}</td>
                        <td>${role.strRoleDesc}</td>
                        <td><a href="#" data-toggle="modal" data-target="#permission_modal"><span class="fa fa-file-text"></span></a></td>
                        <td><input type="hidden" name="sr-prop" class="sr-info" value='{"strRoleName":"${role.strRoleName}","strRoleDesc":"${role.strRoleDesc}","intRoleHome":"${role.intRoleHome}"}'/><a href="#" class="sr-update" data-action="${url}/${role.intRoleId}" data-toggle="modal" data-target=".role_modal"><span class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a class="dr-confirm no-loader" data-content= "This will remove <b><code>${role.strRoleName}</code></b> from the roles permanantly .Continue deleting?" data-title="Delete Role" href="<spring:url value="/security/role/delete"/>/${role.intRoleId}"><span class="glyphicon glyphicon-trash">&nbsp;</span></a></td>
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
		<div class="modal fade role_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header gradient-2">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel"><span class="glyphicon glyphicon-education"></span><span class="head_text"> New Role</span></h4>
		      </div>
		      <div class="modal-body pt0 gradient-2-modal-body">
		                    <spring:url value="/security/role/add" var="url_alt"/>
		                    <input type="hidden" id="url_add" value="${url_alt}"/>
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
											 <form:select path="">
											 
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
		<div class="modal fade" id="permission_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header gradient-1">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel"><span class="glyphicon glyphicon-list-alt"></span><span class="head_text"> Permission</span></h4>
		      </div>
		      <div class="modal-body pt0 gradient-1-modal-body scroller">
		       <div class="mpxd">
		      	<table class="table table-striped table-hover margin-t-b15">
							<thead>
								<tr>
									<th>Object Name</th>
									<th>View</th>
									<th>Add</th>
									<th>Edit</th>
									<th>Delete</th>
									<th>Export</th>
									<th>Print</th>
									<th>Email</th>
								</tr>
								<tr>
									<th></th>
									<th>
										<%-- <form:checkbox path="checkallview" id="checkallview" value="1" checked="checked"/> --%>
										<input type="checkbox" name="checkallview" id="checkallview" value="1" checked="checked"> 
										<input type="hidden" id="rolepermid" name="rolepermid" value="1">
										<input type="hidden" class="form-control" id="roleupdate" name="roleupdate" value="Update">
									</th>
									<th>
										<label for="checkalledit">
                              				<input type="checkbox" name="checkalledit" id="checkalledit" value="1" checked="checked">
                              			</label>			                              			
									</th>
									<th>
										<label for="checkalledit">
												<input type="checkbox" name="checkalledit" id="checkalledit" value="1" checked="checked"> 
										</label>
									</th>
									<th>
										<label for="checkalldelete">
												<input type="checkbox" name="checkalldelete" id="checkalldelete" value="1" checked="checked"> 
										</label>
									</th>
									<th>
										<label for="checkallexport">
												<input type="checkbox" name="checkallexport" id="checkallexport" value="1" checked="checked"> 
										</label>
									</th>
									<th>
										<label for="checkallprint">
												<input type="checkbox" name="checkallprint" id="checkallprint" value="1" checked="checked"> 
										</label>
									</th>
									<th>
										<label for="checkallemail">
												<input type="checkbox" name="checkallemail" id="checkallemail" value="1" checked="checked"> 
										</label>
									</th>
								</tr>
        					</thead>
							<tbody>

								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">Timeline</th>
								</tr>
								<tr>
									<td>Project Template Status</td>
									<td>
										<label for="1_1">
												<input type="checkbox" name="1_1" id="1_1" value="1" checked="checked"> 
										</label>					
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>									
								    </td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>									
									</td>
								</tr>
								<tr>
									<td>Project Journal Status</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">

										Assessment</th>
								</tr>
								<tr>
									<td>Journal Data Entry</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Journal Data Entry Non Progressive</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Journal Validation</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Journal Validation Non Progressive</td>
								<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Audit Data Change Log</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Pending Journal Data Entry</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">

										Design</th>
								</tr>
								<tr>
									<td>Project Template</td>
										<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Progressive Journal</td>
										<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Non Progressive Journal</td>
										<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Change Data Entry Owner</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Manage Templates</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">

										Admin</th>
								</tr>
								<tr>
									<td>Data Attributes Group</td>
										<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Progressive Data Attributes</td>
										<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Non Progressive Data Attributes</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Unit of Measure</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Lookup Data</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">

										Security</th>
								</tr>
								<tr>
									<td>Object</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Data Label</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Role</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>User</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Change Password</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">

										Other</th>
								</tr>
								<tr>
									<td>Reminders</td>
										<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<td>Alert</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>
								<tr>
									<th colspan="8" style="padding-top: 15px; padding-bottom: 5px;">

										Report</th>
								</tr>
								<tr>
									<td>Photo Report</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>								
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
									<td>
										<label for="1_2">
												<input type="checkbox" name="1_2" id="1_2" value="1" checked="checked"> 
										</label>										
									</td>
								</tr>

							</tbody>
						</table>
			     </div>
			 </div>
			 <div class="modal-footer">
			 	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
			  	<button type="submit" class="btn btn-success btn-sm">Save Changes</button>
			  </div>
		    </div>
		  </div>
		</div>			      	
	  <!-- BEGIN: PAGE SCRIPTS -->	
	  <!-- jQuery -->
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery/jquery2.2.4.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery/jquery-ui.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/util.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/dataTables/jquery.dataTables.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/lib/jquery-confirm/jquery-confirm.min.js'/>"></script>
	  <script type="text/javascript" src="<spring:url value='../../resources/js/_sn.js'/>"></script>
	  <script type="text/javascript" src="<s:url value='../../assets/js/pages/role.js'/>"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
		  $('.scroller').slimScroll({
			  color: 'rgb(27, 134, 183)',
	          alwaysVisible: true,
	          railVisible: true,
	          height: '500px',
	          opacity: 0.8
	      });
	  </script>
	</body>
</html>