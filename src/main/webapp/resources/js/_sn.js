'use strict';
var _sn = function(options) {
	
	   var Window = $(window);
	   var Body = $('body');
	   var Navbar = $('.navbar');
	   var Topbar = $('#topbar');
	   var Splash = $('.splash');
	   
	   // Constant Heights
	   var windowH = Window.height();
	   var bodyH = Body.height();
	   var navbarH = 0;
	   var topbarH = 0;
	   
	   // Variable Heights
	   if (Navbar.is(':visible')) { navbarH = Navbar.height(); }
	   if (Topbar.is(':visible')) { topbarH = Topbar.height(); }
	   
	   var contentHeight = windowH - (navbarH + topbarH);
	   var runCustom = function(options) {
			$('form').submit(function() {
				Splash.fadeIn('slow');
			})
//			$(document).keydown(function(event){
//			    if(event.which=="17")
//			        cntrlIsPressed = true;
//			});
//			
//			$(document).keyup(function(){
//			    cntrlIsPressed = false;
//			});
			$('a').click(function() {
				if (($(this).attr('href') != '#')) {
					if (!$(this).hasClass('no-loader')) {
//						if(!cntrlIsPressed){
							Splash.fadeIn('slow');
//						}
					}
				}
			})
			$(document).on("click", ".add-loader", function(){
//				if(!cntrlIsPressed){
					Splash.fadeIn('slow');
//				}
			})
			Window.bind("load", function() {
				// Remove splash screen after load
				Splash.fadeOut('slow');
			});
			
			Window.bind("pageshow", function(event) {
				Splash.fadeOut('slow');
			});
			
	   }	   

	   var runSideMenu = function(options) {
		   
	      var sidebarTopToggle = function() {
	         Body.toggleClass('sb-top-collapsed');
	      };

	      // Sidebar Left Collapse Entire Menu event
	      $('.sidebar-toggle-mini').on('click', function(e) {
	         e.preventDefault();
	         if ($('body.sb-top').length) { return; }   
	         Body.addClass('sb-l-c');
	         triggerResize();
	         if (!Body.hasClass('mobile-view')) {
	            setTimeout(function() {
	               Body.toggleClass('sb-l-m sb-l-o');
	            }, 250);
	         }
	      });

	      // Check window size on load
	      // Adds or removes "mobile-view" class based on window size
	      var sbOnLoadCheck = function() {
	         if ($('body.sb-top').length) {            
	            if ($(window).width() < 900) {
	               Body.addClass('sb-top-mobile').removeClass('sb-top-collapsed');
	            }
	            return; 
	         }
	         if (!$('body.sb-l-o').length && !$('body.sb-l-m').length && !$('body.sb-l-c').length) {
	            $('body').addClass(options.sbl);
	         }
	         if (!$('body.sb-r-o').length && !$('body.sb-r-c').length) {
	            $('body').addClass(options.sbr);
	         }
	         if (Body.hasClass('sb-l-m')) { Body.addClass('sb-l-disable-animation'); }
	         else { Body.removeClass('sb-l-disable-animation'); }
	         if ($(window).width() < 1080) {
	            Body.removeClass('sb-r-o').addClass('mobile-view sb-l-m sb-r-c');
	         }

	         resizeBody();
	      };


	      // Check window size on resize
	      // Adds or removes "mobile-view" class based on window size
	      var sbOnResize = function() {
	         if ($('body.sb-top').length) {            
	            if ($(window).width() < 900 && !Body.hasClass('sb-top-mobile')) {
	               Body.addClass('sb-top-mobile');
	            } else if ($(window).width() > 900) {
	               Body.removeClass('sb-top-mobile');
	            }
	            return; 
	         }
	         if ($(window).width() < 1080 && !Body.hasClass('mobile-view')) {
	            Body.removeClass('sb-r-o').addClass('mobile-view sb-l-m sb-r-c');
	         } else if ($(window).width() > 1080) {
	            Body.removeClass('mobile-view');
	         } else {
	            return;
	         }

	         resizeBody();
	      };

	      // Function to set the min-height of content
	      // to that of the body height. Ensures trays
	      // and content bgs span to the bottom of the page
	      var resizeBody = function() {

	         var sidebarH = $('#sidebar_left').outerHeight();
	         var cHeight = (topbarH + navbarH + sidebarH);

	         Body.css('min-height', cHeight);
	      };  

	      // Most CSS menu animations are set to 300ms. After this time
	      // we trigger a single global window resize to help catch any 3rd 
	      // party plugins which need the event to resize their given elements
	      var triggerResize = function() {
	         setTimeout(function() {
	            $(window).trigger('resize');

	            if(Body.hasClass('sb-l-m')) {
	               Body.addClass('sb-l-disable-animation');
	            }
	            else {
	               Body.removeClass('sb-l-disable-animation');
	            }
	         }, 300)
	      };

	      // Functions Calls
	      sbOnLoadCheck();
	      $("#toggle_sidemenu_t").on('click', sidebarTopToggle);
	      var rescale = function() {
	         sbOnResize();
	      }
	      var lazyLayout = _.debounce(rescale, 300);
	      $(window).resize(lazyLayout);

	      // 3. LEFT MENU LINKS TOGGLE
	      $('.sidebar-menu li a.accordion-toggle').on('click', function(e) {
	         e.preventDefault();
	         if ($('body').hasClass('sb-l-m') && !$(this).parents('ul.sub-nav').length) { return; }
	         if (!$(this).parents('ul.sub-nav').length) {
	            if ($(window).width() > 900) {
	               if ($('body.sb-top').length) { return; }
	            }
	            $('a.accordion-toggle.menu-open').next('ul').slideUp('fast', 'swing', function() {
	               $(this).attr('style', '').prev().removeClass('menu-open');
	            });
	         }
	         else {
	            var activeMenu = $(this).next('ul.sub-nav');
	            var siblingMenu = $(this).parent().siblings('li').children('a.accordion-toggle.menu-open').next('ul.sub-nav')

	            activeMenu.slideUp('fast', 'swing', function() {
	               $(this).attr('style', '').prev().removeClass('menu-open');
	            });
	            siblingMenu.slideUp('fast', 'swing', function() {
	               $(this).attr('style', '').prev().removeClass('menu-open');
	            });
	         }
	         if (!$(this).hasClass('menu-open')) {
	            $(this).next('ul').slideToggle('fast', 'swing', function() {
	               $(this).attr('style', '').prev().toggleClass('menu-open');
	            });
	         }

	      });
	   }
	   return {
		   init: function(options) {
			   runCustom();
			   runSideMenu();

	   }
	}
}();

jQuery(document).ready(function() {
    "use strict";  
    _sn.init();
    
 });

$(".alert").fadeTo(4000, 1500).slideUp(1000, function(){
    $(".alert").slideUp(1000);
});

$.fn.toggleDiv = function(){
	$($(this).data("toggle")).each(function(){
		if($(this).is(":visible")){
			$(this).fadeOut().hide();
		}else{
			$(this).fadeIn().show();
		}
	})
}

$.fn.disable = function(){
	$(this).attr("disabled","disabled");
}
var _confirm = function(options) {
	var deleteConfirm = function() {
		$('.dr-confirm').confirm({
			icon : "fa fa-question-circle",
			confirmButton : "Delete",
			confirmButtonClass : "btn-info add-loader",
			cancelButton : "Cancel",
			autoClose : 'cancel|8000',
			keyboardEnabled : true,
		});
	}
	return {
		   init: function(options) {
			   deleteConfirm();
	   }
	}
}();

var _datePicker = function(options) {
	var datepicker = function() {
	    $(".datepicker").datepicker({
	    	dateFormat : "dd-mm-yy",
		 	prevText: '<i class="fa fa-chevron-left"></i>',
	        nextText: '<i class="fa fa-chevron-right"></i>',
	        showButtonPanel: false,
	        beforeShow: function(input, inst) {
	          var newclass = 'admin-form';
	          var themeClass = $(this).parents('.admin-form').attr('class');
	          var smartpikr = inst.dpDiv.parent();
	          if (!smartpikr.hasClass(themeClass)) {
	            inst.dpDiv.wrap('<div class="' + themeClass + '"></div>');
	          }
	        }
	      });
	}
	return {
		   init: function(options) {
			   datepicker();
	   }
	}
}();

var _toggleUpdate = function(options) {
		var showedit = function() {
			$(".btn-update").on("click", function(){
				/*$("#view-port").fadeOut("slow");*/
//				$("#update-port").fadeIn("slow");
				 $("#update-port").show();
				 $('html, body').animate({scrollTop: $("#update-port").offset().top}, 100);
			});
		}
		var showview = function(){
			$(".btn-cancel").on("click",function(){
				$("#update-port").hide();
				$('html, body').animate({scrollTop: $("#view-port").offset().top}, 100);
			});
		}
	return {
		   init: function(options) {
			   showedit();
			   showview();
	   }
	}
}();
var _slimScroll = function(options) {
	var initialize = function() {
		$('.scroller').slimScroll({
			color: 'rgb(27, 134, 183)',
		    alwaysVisible: false,
		    railVisible: false,
		    height: '500px',
		    opacity: 0.8
		});
	}
return {
	   init: function(options) {
		   initialize();
   }
}
}();
var _dataTable = function(options){
	   var runDataTables = function(options){

		    // Table setup
		    // ------------------------------

		    // Setting datatable defaults
		    $.extend( $.fn.dataTable.defaults, {
		        autoWidth: false,
		        columnDefs: [{ 
		            orderable: false,
		            width: '100px',
		            'checkboxes': {
		                'selectRow': true
		             }
//		            targets: [ 5 ]
		        }],
		        dom: '<"datatable-header"fl><"datatable-scroll"t><"datatable-footer"ip>',
		        language: {
		            search: '<span> Search From '+options.searchType +':</span> _INPUT_',
		            lengthMenu: '<span>Show:</span> _MENU_',
		            paginate: { 'first': 'First', 'last': 'Last', 'next': '&rarr;', 'previous': '&larr;' }
		        },
		        drawCallback: function () {
		            $(this).find('tbody tr').slice(-3).find('.dropdown, .btn-group').addClass('dropup');
		        },
		        preDrawCallback: function() {
		            $(this).find('tbody tr').slice(-3).find('.dropdown, .btn-group').removeClass('dropup');
		        }
		    });
		    function ck(option){
	    		return $("#datatable").attr('data-'+option);
	    	}
		    
		    // Basic datatable
		    $('#datatable').DataTable({
		    	"bFilter": ck('bFilter'),
		    	"bSort": ck('bSort'),
		    	"bLengthChange": ck('bLengthChange'),
		    	"iDisplayLength": ck('iDisplayLength'),
		    });
		    // Alternative pagination
//		    $('.datatable-pagination').DataTable({
//		        pagingType: "simple",
//		        language: {
//		            paginate: {'next': 'Next &rarr;', 'previous': '&larr; Prev'}
//		        }
//		    });


		    // Datatable with saving state
		    $('.datatable-save-state').DataTable({
		        stateSave: true
		    });


		    // Scrollable datatable
		    $('.datatable-scroll-y').DataTable({
		        autoWidth: true,
		        scrollY: 300
		    });



		    // External table additions
		    // ------------------------------

		    // Add placeholder to the datatable filter option
		    $('.dataTables_filter input[type=search]').attr('placeholder','Type to Search...');

		    // Enable Select2 select for the length option
//		    $('.dataTables_length select').select2({
//		        minimumResultsForSearch: "6"
//		    });
	   }
	return {
	   init: function(options) {
		   runDataTables(options);
	   }
	}
}();

