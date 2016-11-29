/**
 * 
 */
$(".sr-update").on("click",function(){
	$this=$(this), $modal = $('.label_modal');
	var v = JSON.parse($this.prev().val());
	console.log(v);
	$.each(v, function(k,c) {
		$modal.find('#'+k).val(c);
	})
	$modal.find("form").attr("action",$this.data('action'));
});