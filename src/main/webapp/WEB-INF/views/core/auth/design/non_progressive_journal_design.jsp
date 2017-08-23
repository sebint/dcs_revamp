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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/theme/theme.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/forms-theme.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.full.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/handsontable/pikaday/pikaday.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/fancy-box/jquery.fancybox.min.css"/>
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
	              <a id="crumblink" class="t-t-capt" href='<spring:url value="/design/non-progressive/${journalUrl}"/>'>${fn:replace(journalName,'-',' ')}</a>
	            </li>
	             <li class="crumb-trail">Design</li>
	          </ol>
	        </div>
	        <div class="topbar-right mt-5">
	          <div class="ib topbar-dropdown">
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted"><span class="t-t-capt">${(fn:replace(fn:toLowerCase(journalName),'-', ' '))}</span></label>
	          </div>
	        </div>
	      </header>
	      <!-- End: Topbar -->
	
	      <!-- Begin: Content -->
	      <section id="content" class="animated fadeIn">
			<input type="hidden" id="csrfToken" value="${_csrf.token}"/>
			<input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
			<input type="hidden" id="jounlId" value="${nonprogressive.nonProgressiveMasterId}"/>
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
        	 	<div class="panel panel-visible bt-gray" id="spy1">
        	 		<div class="panel-body">
        	 			<div class="col-xs-12 col-sm-9 col-md-9">
                                <div class="forum-icon">
                                    <i class="glyphicon glyphicon-equalizer"></i>
                                 </div>
                                 <span class="forum-item-title"><span class="t-t-capt">${fn:replace(journalName,'-',' ')}</span></span>
                                 <div class="forum-sub-title">Design  <span class="t-t-capt">${fn:replace(journalName,'-',' ')}</span></div>
                            </div>
                            <div class="col-xs-12 col-sm-3 col-md-3">	        	     
        	           		<a href="#" data-toggle="modal" data-target=".column_modal" class="btn btn-warning br3 fw600 pull-right"><span class="fa fa-plus"></span> <spring:message code="npj.dsign.row.add"/> </a>
        	           	</div>	
        	 		</div>
        	 	</div>
	        </div>
	          <div class="col-md-12">
	             <div class="panel panel-visible bt-blue" id="spy1"> 
	                <div class="panel-body mpxd">
	                	<div class="row">
	               			<div class="col-md-12">
								<div class="section-divider mb40" id="spy1">
			                      <span>Journal Information</span>
			                    </div>
			                    <ul class="icon-list">
						          <li>
						            <i class="fa fa-exclamation-circle text-warning fa-lg pr10"></i>
						            <b> Project Name :</b> ${nonprogressive.project.projectName }
						          </li>
						          <li>
						            <i class="fa fa-exclamation-circle text-warning fa-lg pr10"></i>
						            <b> Journal Name :</b> ${nonprogressive.journalName }
						          </li>
						          <li>
						            <i class="fa fa-exclamation-circle text-warning fa-lg pr10"></i>
						            <b> Owner :</b> ${nonprogressive.user.strFirstName} ${nonprogressive.user.strLastName}		         
						          </li>
						        </ul>
						        <hr class="short alt">
							</div>
						</div>
	               		<div class="row">
	               			<div class="col-md-12">
								<div id="scroll_container" style="overflow:hidden;">
									<div id="hottable_container" style="margin-bottom:15px"></div>									
								</div>
							</div>
							<div class="col-md-12">
								<div id="ctlSave" >
									<div class="col-md-6">
										<span >NOTE :</span>
										<blockquote class="blockquote-rounded m-b-0 f-s-12">
						                    <p class="text-danger m-b-0">* You are only allowed to design the journal.</p>
						                    <p class="text-danger m-b-0">* Click <a href="#">here</a> to add Data.</p>
						                  </blockquote>
									</div>
									<div class="text-right col-md-6">
										<button id="savedata" type="button" class="btn btn-success br3 btn-sm"><i class="fa fa-save"></i> 
											<span class="btn-text">Save Design</span></button>
										<a href='<spring:url value="/design/non-progressive"/>' class="btn btn-default br3 btn-sm dr-confirm no-loader" title="Cancel Design" data-content= "This will cancel the design built for <b><code>${nonprogressive.journalName }</code></b>. Continue?" data-title="Cancel Design">
											<i class="fa fa-close"></i> Cancel
									   </a>
								   </div>
							   </div>
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
	  <!-- Model -->
	 <div class="modal fade column_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header gradient-2">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		        <h4 class="modal-title" id="myLargeModalLabel"><span class="glyphicon glyphicon-education"></span><span class="head_text"> Add Column</span></h4>
		      </div>
		      <div class="modal-body pt0 gradient-2-modal-body">
					<div class="mpxd theme-primary mw1000 center-block">
						<form method="post" action="#" id="role-form">
							<div class="panel-body pt0">
								<div class="section-divider mv40" id="spy4">
									<span class="desc_text">Provide the following information to add new column</span>
								</div>
								<!-- .section-divider -->
								<div class="section">
									<span class="field-alt fw600">
										Column Title <span class="ico-help" title="Prefered Column Title"><i class="fa fa-question-circle"></i></span>
									</span>	
									<label for="strRoleName" class="field prepend-icon"> 
									   <input id="column_title" name="column_title" class="gui-input br5" placeholder="Column Title"/>
											<label for="strRoleName" class="field-icon"> 
												<i class="glyphicon glyphicon-education"></i>
											</label>
									</label>
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Column Type <span class="ico-help" title="Home page for this role."><i class="fa fa-question-circle"></i></span>
									</span>	
									 <label class="field select">
										<select class="form-control" id="column_type" name="column_type">
										 			<option value="" selected="selected">-- Please Select --</option>
													<option value="text">Text</option>
													<option value="date">Date</option>
													<option value="percentround2">Percent</option>
													<option value="price_myr">Ringgit</option>
													<option value="numeric">Number</option>
													<option value="decimal2">Decimal (2)</option>
													<option value="lookup">Lookup</option>
													<option value="progressive_link">Progressive Link</option>
													<option value="non_progressive_link">Non-Progressive Link</option>
													<option value="formula">Formula</option>
										 </select>
										<i class="arrow double"></i>
									</label>	                           								
								</div>
								<div class="section">
									<div id="lookup_container"></div>
									<div id="link_container"></div>
									<div id="nonp_link_container"></div>
									<div id="formula_container"></div>
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Unit of Measurement <span class="ico-help" title="Home page for this role."><i class="fa fa-question-circle"></i></span>
									</span>	
									 <label class="field select">
									 	<select class="form-control" id="uom" name="uom">
									 		<option value="" selected="selected">-- Please Select --</option>
									 		 <c:forEach items="${unitMeasure}" var="unit" varStatus="counter">
									 		 	<option value="${unit.uomId}">${unit.uomLabel}</option>
									 		 </c:forEach>
									 	</select>
										<i class="arrow double"></i>
									</label>	                           								
								</div>
								<div class="section">
									<span class="field-alt fw600">
										Read only
									</span>	
									<label class="checkbox-inline mr10" style="margin-top:-14px">
									  	<input type="checkbox" id="readonly" name="readonly">
									</label>                           								
								</div>
							</div>
							<!-- end .form-body section -->
							<div class="panel-footer text-right">
								<button id="add_new_column" type="button" class="button btn-primary br3"><i class="fa fa-check"></i> 
									<span class="btn-text">Add Column</span></button>
								<button type="reset" data-dismiss="modal" class="button br3">
									<i class="fa fa-close"></i> Cancel
							   </button>
							</div>
							<!-- end .form-footer section -->
						</form>
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-confirm/jquery-confirm.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.full.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/moment/moment.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/pikaday/pikaday.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery.json.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/rulejs/ruleJS.all.full.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.formula.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.config.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/fancy-box/jquery.fancybox.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() {"use strict"; _confirm.init(); });
	  
	  function hot_save_config(callback) {
			var c = hot_object.raw_config;
			var isReadonlyExist = false;
			for (var i = 0; i < c.length; i++) {
				if (c[i]["readonly"]) { isReadonlyExist = true; break; }
			}
			
			// Invalid data detected. Dont save
			if (isReadonlyExist) {
				if ($('.htInvalid').length > 0) { alert("Data is invalid. Please rectify the highlighted cells"); return false; }
			}
			/* showloader(); */
			var raw_config = hot_object.raw_config;
			var url = $("#crumblink").attr("href");
			var token = $('#csrfToken').val();
			var header = $('#csrfHeader').val();
			var jId = $("#jounlId").val();
			for(x = 0; x < raw_config.length; x++){
				raw_config[x]["journalId"] = parseInt(jId); 
			}
			$.ajax({				
			    type : 'POST',
			    contentType : "application/json",
			    url : url + '/design',
			    data: JSON.stringify(raw_config),
			    dataType : 'json',			    
			    beforeSend: function(xhr) { 
			        xhr.setRequestHeader(header, token); 
 			    }, 
			    success : function(data) {
			    	console.log("SUCCESS: ", data);
			    },
			    error : function(e) {
			    	console.log("ERROR: ", e);
			    }
			});
			
/* 			$.post(url+'/design', {config:$.toJSON(raw_config)}).always(function(data){
					console.log(data);
					var d = hot_object.hot_serialize_data();
					var data = $.toJSON(d); */
					//console.log(data);
					console.log("Saving read only data..");
/* 					$.post("<?php echo $this->config->base_url().'index.php/'.$cpagename; ?>/save_data?jid=<?php echo $details->journal_no; ?>&publish=false", {data:data}).always(function(data){
						console.log(data);
					}); */
				if (typeof callback == "function") { callback(); }
				
/* 			}); */
		}
	  
	  function initialize_hot() {
			if ((typeof hot_object == "undefined") || (hot_object == null)) {
				hot_object = new HOT(Handsontable, raw_config, [[]], 'design');
				hot_object.register_edit_callback(edit_callback);
				refresh_progressive_links();
				refresh_non_progressive_links();
			}
			
		}
	  
	  function add_new_column(title,type,uom,extra) {
			initialize_hot();
			hot_object.add_new_column(title,type,uom,extra);
			lockTable();
			if (type == "progressive_link") {
				load_progressive_link(hot_object.raw_config[hot_object.raw_config.length-1]);
				//refresh_progressive_links();
			} else if (type == "non_progressive_link") {
				load_non_progressive_link(hot_object.raw_config[hot_object.raw_config.length-1]);
			}
		}
	  //Needs Change
	  function load_progressive_link(obj) {
			$.getJSON("<?php echo $this->config->base_url().'index.php/api/get_progressive_attributes?jid='; ?>"+obj.progressive_link, function(data){
				hot_object.fill_column(obj.order, data);
				//console.log('object',obj);
			})
		}
	  
	  function refresh_progressive_links() {
			for (var i = 0; i < hot_object.raw_config.length; i++) {
				var obj = hot_object.raw_config[i];
				
				if (obj.type == "progressive_link") {
					load_progressive_link(obj);
					//(function(saved_obj){})(obj);
				}
			}
		}
	  //Needs Change
	  function load_non_progressive_link(obj) {
			var link = obj.non_progressive_link.split('|');
			var jid = link[0];
			var config_no = link[1];
			$.getJSON("<?php echo $this->config->base_url().'index.php/api/get_nonp_column_value?jid='; ?>"+jid+"&config_no="+config_no, function(data){
				hot_object.fill_column(obj.order, data);
				console.log('object',obj);
			})
		}

		function refresh_non_progressive_links() {
			for (var i = 0; i < hot_object.raw_config.length; i++) {
				var obj = hot_object.raw_config[i];
				
				if (obj.type == "non_progressive_link") {
					load_non_progressive_link(obj);
				}
			}
		}
		
		function edit_callback(object) {
			console.log(object);
		}
		
		function lockTable() {
			hot_object.lock_table();
		}
		
		function lockCells(){
			hot_object.lock_cells();
		}
		

		// Function to generate edit modal on the fly, so that hopefully you dont have to maintain 2 modals
		function generate_edit_modal() {
			$edit_modal = $('.column_modal').clone();
			
			$edit_modal.find('#column_title').attr('id','column_title_edit').attr('name','column_title_edit');
			$edit_modal.find('#column_type').attr('id','column_type_edit').attr('name','column_type_edit').on('change',function(e){
				//console.log('change',e);
				$t = $(this);
				var val = $t.val();
				
				if (val != "date") {
					$edit_modal.find('#uom_edit').val('12').removeAttr('disabled');
				}
				if (val != "lookup") {
					$edit_modal.find('#lookup_content_edit').appendTo($('#hiddenstuff_edit'));
				}
				if (val != "progressive_link") {
					$edit_modal.find('#link_content_edit').appendTo($('#hiddenstuff_edit'));
					$edit_modal.find('#uom_edit').removeAttr('disabled');
					$edit_modal.find('#readonly_edit').removeAttr('disabled').attr('checked',false);
				}
				if (val != "non_progressive_link") {
					$edit_modal.find('#nonp_link_content_edit').appendTo($('#hiddenstuff_edit'));
					$edit_modal.find('#uom_edit').removeAttr('disabled');
					$edit_modal.find('#readonly_edit').removeAttr('disabled').attr('checked',false);
				}
				if (val != "formula") {
					$edit_modal.find('#formula_content_edit').appendTo($('#hiddenstuff_edit'));
					//$edit_modal.find('#uom_edit').removeAttr('disabled');
					//$edit_modal.find('#readonly_edit').removeAttr('disabled').attr('checked',false);
				}
				
				
				
				switch(val) {
					case "date":
						$edit_modal.find('#uom_edit').val('3').attr('disabled','true');
						break;
					case "lookup":
						$edit_modal.find('#lookup_content_edit').appendTo($('#lookup_container_edit'));
						break;
					case "progressive_link":
						$edit_modal.find('#link_content_edit').appendTo($('#link_container_edit'));
						$edit_modal.find('#uom_edit').attr('disabled','disabled');
						$edit_modal.find('#readonly_edit').attr('disabled','disabled').attr('checked',true);
						break;
					case "non_progressive_link":
						$edit_modal.find('#nonp_link_content_edit').appendTo($('#nonp_link_container_edit'));
						$edit_modal.find('#uom_edit').attr('disabled','disabled');
						$edit_modal.find('#readonly_edit').attr('disabled','disabled').attr('checked',true);
						break;
					case "formula":
						$edit_modal.find('#formula_content_edit').appendTo($('#formula_container_edit'));
						//$edit_modal.find('#uom_edit').attr('disabled','disabled');
						//$edit_modal.find('#readonly_edit').attr('disabled','disabled').attr('checked',true);
						break;
						
				}
				
				/*
				if (val == "date") {
					$edit_modal.find('#uom_edit').val('3').attr('disabled','true'); /* Date *
				} else {
					$edit_modal.find('#uom_edit').val('12').removeAttr('disabled'); /* Not selected *
				}
				
				if (val == 'lookup') {
					$edit_modal.find('#lookup_content_edit').appendTo($('#lookup_container_edit'));
				} else {
					$edit_modal.find('#lookup_content_edit').appendTo($('#hiddenstuff_edit'));
				}
				
				if (val == 'progressive_link') {
					$edit_modal.find('#link_content_edit').appendTo($('#link_container_edit'));
					$edit_modal.find('#uom_edit').attr('disabled','disabled');
					$edit_modal.find('#readonly_edit').attr('disabled','disabled');
				} else {
					$edit_modal.find('#link_content_edit').appendTo($('#hiddenstuff_edit'));
					$edit_modal.find('#uom_edit').removeAttr('disabled');
					$edit_modal.find('#readonly_edit').removeAttr('disabled');
				}*/
				
				$edit_modal.find('#column_type').data('previous',val);
			});
			$edit_modal.find('#uom').attr('id','uom_edit').attr('name','uom_edit');
			$edit_modal.find('#readonly').attr('id','readonly_edit').attr('name','readonly_edit');
			$edit_modal.find('#hiddenstuff').attr('id','hiddenstuff_edit').attr('name','hiddenstuff_edit');
			$edit_modal.find('#lookup').attr('id','lookup_edit').attr('name','lookup_edit');
			$edit_modal.find('#lookup_content').attr('id','lookup_content_edit').attr('name','lookup_content_edit');
			$edit_modal.find('#lookup_container').attr('id','lookup_container_edit').attr('name','lookup_container_edit');
			
			$edit_modal.find('#link_jid').attr('id','link_jid_edit').attr('name','link_jid_edit');
			$edit_modal.find('#link_content').attr('id','link_content_edit').attr('name','link_content_edit');
			$edit_modal.find('#link_container').attr('id','link_container_edit').attr('name','link_container_edit');
			
			$edit_modal.find('#nonp_link_jid').attr('id','nonp_link_jid_edit').attr('name','nonp_link_jid_edit');
			$edit_modal.find('#nonp_link_content').attr('id','nonp_link_content_edit').attr('name','nonp_link_content_edit');
			$edit_modal.find('#nonp_link_container').attr('id','nonp_link_container_edit').attr('name','nonp_link_container_edit');
			$edit_modal.find('#nonp_link_column').attr('id','nonp_link_column_edit').attr('name','nonp_link_column_edit');
			
			$edit_modal.find('#formula_content').attr('id','formula_content_edit').attr('name','formula_content_edit');
			$edit_modal.find('#formula_container').attr('id','formula_container_edit').attr('name','formula_container_edit');
			$edit_modal.find('#formula').attr('id','formula_edit').attr('name','formula_edit');
			
			
			$edit_modal.find('.modal-title').text('Edit Column');
			$edit_modal.find('#add_new_column').attr('id','edit_column').text('Confirm Edit').on('click', function(){
				edit_column_click();
			})
			
			$edit_modal.append('<input type="hidden" id="original_title" value=""/>')
			
			$edit_modal.find('#nonp_link_jid_edit').on('change',function() {
				var $t = $(this);
				var val = $t.val();
				populate_nonp_columns($('#nonp_link_column_edit'), val);
			});
		}
	  
	  $(function(){
		  //Hide the Save Design and cancel buttons on load.
		  $("#ctlSave").hide();
			var formhandler = function() {
				var title = $.trim($('#column_title').val());
				var type = $('#column_type').val();
				var uom = $('#uom').val();
				var readonly = $("#readonly").is(":checked");
				
				var extra = {};
				
				if (type == "lookup") { extra["lookup_id"] = $("#lookup").val()}
				if (type == "progressive_link") { extra["progressive_link"] = $("#link_jid").val() }
				if (type == "non_progressive_link") { extra["non_progressive_link"] = $("#nonp_link_jid").val() +"|"+$("#nonp_link_column").val() }
				if (type == "formula") { extra["formula"] = $("#formula").val() }
				
				if (readonly != "undefined") { extra["readonly"] = readonly; }
				
				console.log(extra);
				add_new_column(title,type,uom,extra);
				
				$('.column_modal').modal('toggle');
				$('#column_title').val('');
				
				//Show the Save Design and cancel buttons onces a single header is created.
				$("#ctlSave").show();
			}
			$('#savedata').on('click', function(){
				hot_save_config();
			});
			$('#add_new_column').on('click', function(){
				formhandler();
			}); 			
			raw_config = ${design};
			data =  ${journalData};
			lookupdata = ${lookup};
			hot_lock = ${hotLock};
			hot_object = null;			
			if (raw_config.length > 0) {
				hot_object = new HOT(Handsontable, raw_config,data,'design');
				if (hot_lock) { $('#modaladd').attr('disabled','disabled'); $('#savedata').attr('disabled','disabled'); }
				hot_object.register_edit_callback(edit_callback)
				refresh_progressive_links();
				refresh_non_progressive_links();
				lockCells();
				$("#ctlSave").show();
			}
			else { 
				//initialize_hot(); 
			}
	  });
	  </script>
	</body>
</html>