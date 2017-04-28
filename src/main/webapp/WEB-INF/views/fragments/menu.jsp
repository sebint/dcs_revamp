<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	    <!-- Start: Sidebar -->
	    <aside id="sidebar_left" class="p-fixed">
	
	      <!-- Start: Sidebar Left Content -->
	      <div class="sidebar-left-content nano-content">
	
	        <!-- Start: Sidebar Menu -->
	        <ul class="nav sidebar-menu">
	
	          <li class="active">
	            <a class="menu-open" href='<spring:url value="/dashboard"/>'>
	              <span class="glyphicon glyphicon-home"></span>
	              <span class="sidebar-title">Dashboard</span>
	            </a>
	          </li>
	          <li>
	            <a class="accordion-toggle" href="#">
	              <span class="glyphicon glyphicon-time"></span>
	              <span class="sidebar-title">Timeline</span>
	              <span class="caret"></span>
	            </a>  
	            <ul class="nav sub-nav">
	                  <li>
	                    <a href='<spring:url value="/timeline/template-status/"/>'>
	                    	<span class="fa fa-hourglass-half"></span>
	                      	Project Template Status 
	                      </a>
	                  </li>
	                  <li>
	                    <a href='<spring:url value="/timeline/journal-status/"/>'>
	                    	<span class="fa fa-info"></span>
	                      	Project Journal Status 
	                      </a>
	                  </li>
	           </ul>    
	          </li>
	          <li>
	            <a class="accordion-toggle" href="#">
	              <span class="fa fa-tasks"></span>
	              <span class="sidebar-title">Assessment</span>
	              <span class="caret"></span>
	            </a>
	            <ul class="nav sub-nav">
	              <li>
	                <a href='<spring:url value="/assessment/journal-entry/"/>'>
	                  <span class="fa fa fa-arrows-h"></span>
	                  	Journal Data Entry
<%-- 	                  <span class="caret"></span> --%>
	                </a>
	              </li>
	              <li>
	               <a href='<spring:url value="/assessment/progressive-validate/"/>'>
	                  <span class="fa fa-arrows-v"></span>
	                  Journal Validation - Progressive
<%-- 	                  <span class="caret"></span> --%>
	                </a>
	              </li>
	              <li>
	                 <a href='<spring:url value="/assessment/nonproressive-validate/"/>'>
	                  <span class="fa fa-hand-o-up"></span>
	                  Journal Validation - Non Progressive
<%-- 	                  <span class="caret"></span> --%>
	                </a>
	              </li>
	              <li>
	              	<a href='<spring:url value="/assessment/change-log/"/>'>
	                  <span class="fa fa-arrows-v"></span>
	                  Audit Data Change Log
<%-- 	                  <span class="caret"></span> --%>
	                </a>	         
	              </li>
	              <li>
	                <a href='<spring:url value="/assessment/pending-entry/"/>'>
	                  <span class="fa fa-pause"></span>
	                  Pending Journal Data Entry
<%-- 	                  <span class="caret"></span> --%>
	                </a>
	             </li>
	            </ul>
	          </li>
	          <li>
	            <a class="accordion-toggle" href="#">
	              <span class="fa fa-star"></span>
	              <span class="sidebar-title">Design</span>
	              <span class="caret"></span>
	            </a>
	            <ul class="nav sub-nav">
	              <li>
	                  <a href='<spring:url value="/design/templates/"/>'>
	                  	<span class="glyphicon glyphicon-book"></span> Project Templates 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/design/progressive/"/>'>
	                  	<span class="glyphicon glyphicon-modal-window"></span> Progressive Journal 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/design/non-progressive/"/>'>
	                  	<span class="glyphicon glyphicon-equalizer"></span> Non-Progressive Journal 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/design/change-owner/"/>'>
	                  	<span class="glyphicon glyphicon-modal-window"></span> Change Data Entry Owner 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/design/manage-template/"/>'>
	                  	<span class="glyphicon glyphicon-equalizer"></span> Manage Templates 
	                  </a>
	              </li>
	            </ul>
	          </li>
	          <li>
	            <a class="accordion-toggle" href="#">
	              <span class="fa fa-briefcase"></span>
	              <span class="sidebar-title">Administrator</span>
	              <span class="caret"></span>
	            </a>
	            <ul class="nav sub-nav">
	              <li>
	                  <a href='<spring:url value="/manage/attribute-group/"/>'>
	                  		<span class="glyphicon glyphicon-edit"></span> Data Attribute Group 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/manage/data-attribute/"/>'>
	                  		<span class="glyphicon glyphicon-calendar"></span> Progressive Data Attributes 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/manage/unit-measure/"/>'>
	                  		<span class="glyphicon glyphicon-check"></span> Unit of Measure 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/manage/lookup/"/>'>
	                  		<span class="fa fa-desktop"></span> Lookup Data 
	                  </a>
	              </li>
	            </ul>
	          </li>
	          <li>
	            <a class="accordion-toggle" href="#">
	              <span class="fa fa-lock"></span>
	              <span class="sidebar-title">Security</span>
	              <span class="caret"></span>
	            </a>
	            <ul class="nav sub-nav">
	              <li>
	                <a href='<spring:url value="/security/object/"/>'>
	                  <span class="glyphicon glyphicon-shopping-cart"></span> Object
	                  <span class="label label-xs bg-primary">New</span>
	                </a>
	              </li>
	              <li>
	               	  <a href='<spring:url value="/security/label/"/>'>
	                  		<span class="glyphicon glyphicon-tags"></span> Data Label 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/security/role/"/>'>
	                  		<span class="fa fa-money"></span> Role 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/security/user/"/>'>
	                  		<span class="fa fa-users"></span> User 
	                  </a>
	              </li>
	              <li>
	                  <a href='<spring:url value="/security/user/account/password-change"/>'>
	                  		<span class="fa fa-gears"></span> Change Password 
	                  </a>
	              </li>
	            </ul>
	          </li>
	          <li>
	            <a class="accordion-toggle" href="#">
	              <span class="glyphicon glyphicon-duplicate"></span>
	              <span class="sidebar-title">Report</span>
	              <span class="caret"></span>
	            </a>
	            <ul class="nav sub-nav">
	              <li>
	                <a href='<spring:url value="/report/photo/"/>'>
	                  <span class="glyphicon glyphicon-shopping-cart"></span> Photo Report 
	                  <span class="label label-xs bg-primary">${menuList}</span>
	                </a>
	              </li>
	             </ul>
	          </li>
	
	        </ul>
	        <!-- End: Sidebar Menu -->
	
	      </div>
	      <!-- End: Sidebar Left Content -->
	
	    </aside>