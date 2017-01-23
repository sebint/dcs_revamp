 "use strict";  
/**
 * 
 */
$(".form-toggle-btn").click(function() {
	$(this).toggleDiv();
});
$(".submit").click(function() {
	$(this).disable();
	$(this).toggleDiv();
	setInterval(function() {
		$('#l-status').fadeOut(500, function() {
			var $this = $('#l-status');
	        $this.text($this.text() == 'Authenticating...' ? "   Please wait.. " : 'Authenticating...');     
	        $this.fadeIn(500);
		})
	}, 3000);
//	$("#mpxd-login").submit();
});
var $container = $(".loading");
$(".overlay").fadeIn().css("top", $container.scrollTop() + "px");
$container.css("overflow", "hidden");