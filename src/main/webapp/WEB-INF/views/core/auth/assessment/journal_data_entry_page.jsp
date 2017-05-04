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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/forms-theme.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/handsontable/handsontable.full.min.css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/handsontable/pikaday/pikaday.css"></link>
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
	            <label for="topbar-multiple" class="control-label pr10 fs20 text-muted">Non-Progressive Journal</label>
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
                                 <div class="forum-sub-title">Data Entry  <span class="t-t-capt">${fn:replace(journalName,'-',' ')}</span></div>
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
									<div class="text-right col-md-12">
										<button id="publishdata" type="button" class="btn btn-success br3 btn-sm"><i class="fa fa-check"></i> 
											<span class="btn-text">Publish</span></button>
										<button id="savedata" type="button" class="btn btn-primary br3 btn-sm"><i class="fa fa-save"></i> 
											<span class="btn-text">Save</span></button>
										<a href='<spring:url value="/assessment/journal-entry"/>' class="btn btn-danger br3 btn-sm dr-confirm no-loader" title="Cancel Data Entry" data-content= "This will cancel current entry for <b><code>${nonprogressive.journalName }</code></b>. Continue?" data-title="Cancel Data Entry">
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
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/_sn.js"></script>
	  <!-- END: PAGE SCRIPTS -->
	  <script type="text/javascript">
	  jQuery(document).ready(function() {"use strict"; _confirm.init(); });
	  
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
		
		$("#recordsearch").click(function () {
			var search = $('#search').val();
			var patt = new RegExp(/^[A-Za-z0-9 _\-\(\)\.]+$/);
			if(patt.test(search) || search=='')
			{
				var search = $('#search').val();
				$.post( "<?php echo base_url(); ?><?php echo $cpagename; ?>/searchrecord",{search:search}, function( data ) {
					location.href="<?php echo base_url(); ?><?php echo $cpagename; ?>/search";
				});
			}
			else
			{
				alert('The Search field may only contain alpha-numeric characters, underscores, dashes and bracket.');
			}
		});
		
		function notify(v) {
			var $div = $('<div class="alert alert-danger alert-dismissible fade in" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>'+v+'</div>');
			$div.appendTo($('#notification'));
		}
		
		function lockTable() {
			hot_object.lock_table();
		}
		
		function lockButton() {
			$('#publishdata').attr('disabled','disabled');
			$('#savedata').attr('disabled','disabled');
			$('#data_date').attr('disabled','disabled').css('border-color','#ccc');
			$('#data_date_button').attr('disabled','disabled');
			$('#today_button').attr('disabled','disabled');
		}
		
		function remove_read_only(data){
			
			for(i = 0; i < hot_object.hot_serialize_data().length; i++){
				//remove read only data from the last index.
				for(j = read_only_rows.length-2; j >= 0; j--){
					if(read_only_rows[j] === 1){
						data[i].splice(j,1);
					}
				}
			}
			return data;
		}
		
		function hot_save_data(publish, callback) {

			// Invalid data detected. Dont save
			if ($('.htInvalid').length > 0) { alert("Data is invalid. Please rectify the highlighted cells"); return false; }
			if ($('#data_date').val() == "") { alert("Data date is invalid. Please select a correct date"); if(p_data_date) p_data_date.show(); return false; }
			var d = hot_object.hot_serialize_data();
			var d = remove_read_only(d);
			var p = ((typeof publish == "boolean") && (publish));

			var data = $.toJSON(d);
			
			console.log(data);
			showloader();
			//console.log(<?php echo $details->journal_no; ?>);
			$.post("<?php echo $this->config->base_url().'index.php/'.$cpagename; ?>/save_data?jid=<?php echo $details->journal_no; ?>&publish="+p.toString(), {data:data, data_date:p_data_date.toString()}).always(function(data){
				console.log(data);
				if ((data == 1) && (p)) {
					// Published! Now we should lock the table
					lockTable();
					lockButton();
					//location.reload();
					location.href="<?php echo $this->config->base_url(); ?>journaldataentry";
				}
				else {
					hideloader();
				}
				if (typeof callback == "function") callback();
			});
			/*var form = $('<form action="'+location.href+'" method="post"style="display:none;"><input type="hidden" name="data" id="data"/></form>')
			form.children('input#data').attr('value',data);
			form.appendTo($('body'));
			console.log(form.html());
			form.submit();*/
		}
		
		function hot_publish_data() {
			if (confirm("Confirm publish?")) hot_save_data(true);
		}
		
		function show_comments() {
			if (comments.length == 0) return;
			total = comments.reduce(function(c,n,a,s) {
				return c+n;
			}, "");
			if (total != "") {
				draw_comments(comments, 'dataentry');
			}
		}
		$(function(){

			p_data_date = new Pikaday({
				field:$('#data_date')[0],
				format: 'DD-MMM-YYYY',
		        onSelect: function() {
		            //console.log(this.getMoment().format('Do MMMM YYYY'));
		        }
			});

			$('#today_button').on('click', function() {
				if (p_data_date) p_data_date.setDate(new Date());
			});
			
			$('#data_date_button').on('click', function() {
				/*if (p_data_date.isVisible()) {
					p.data_date
				}*/
				if (p_data_date) p_data_date.show();
			});
			
			$('#publishdata').on('click', function(){
				hot_publish_data();
			});
			
			$('#savedata').on('click', function(){
				hot_save_data();
			});
			
			lookupdata = [];
			
			// Function to populate lookup codes from database
			$.each(lookupdata, function(idx,i){
				j = transpose(i.data);
				//console.log(i.meta.id);
				addLookupCode(i.meta.id, j[0], j[1]);
				//console.log(j);
			});
			
			raw_config = ${design};
			hot_lock = ${hotLock};
			read_only_rows = [0];
			data =  ${journalData};
			//comments = <?php echo json_encode($hot_comments); ?>;
			comments = [];
			comments = $.map(comments,function(i,idx){return i.validate_comment_row});

			data_date = false;
			
//			if (data_date != false) {  p_data_date.setDate(data_date); }
			if (data_date != false) { p_data_date.setMoment(moment(data_date, 'DD-MMM-YYYY')); }
			else { p_data_date.setDate(new Date()); }
			
			var container = document.getElementById("hottable_container");
			var lastChange = null;
			
		 
			hot_object = new HOT(Handsontable, raw_config, data, 'dataentry');
			if ((typeof comments == "object") && (comments.length > 0)) {
				for (var i = 0; i < comments.length; i++) {
					hot_object.hot_add_comment(comments[i]['row'], comments[i]['col'], comments[i]['comment']);
				}
			}
			refresh_progressive_links();
			refresh_non_progressive_links();
			
			//hot_object.hot_render_comment();
			
			hot_object.hot_instance.updateSettings({
				afterCreateRow: function(idx,amt){
					var a = [idx, 0];
					for (var i = 0; i < amt; i++) { a.push(""); }
					[].splice.apply(comments, a);
					show_comments()
				},
				afterRemoveRow: function(idx,amt){
					comments.splice(idx,amt);
					show_comments()
				},
				cells: function (row, col, prop) {
					var cellProperties = {};
					if(read_only_rows[row] === 1){
						cellProperties.readOnly = true;
					}
					return cellProperties;
				}
			});
			
			show_comments();
			if (hot_lock) {
				lockTable();
				lockButton();
				notify("<strong>Validation for this journal is pending</strong>");
			}

		});
		
	  </script>
	</body>
</html>