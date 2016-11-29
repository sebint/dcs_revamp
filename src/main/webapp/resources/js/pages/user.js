/**
 * 
 */
if ($("#has_field_error").val() == '1') {
	$("#user_modal").modal('show');
}

$('.dr-confirm').confirm({
	icon : "fa fa-question-circle",
	confirmButton : "Delete",
	confirmButtonClass : "btn-info add-loader",
	cancelButton : "Cancel",
	autoClose : 'cancel|8000',
	keyboardEnabled : true,
});

$(".sr-update").on( "click", function() {
			$this = $(this), $modal = $('#user_modal');
			var v = JSON.parse($this.prev().val());
			$modal.find(".head_text").text(" Update User");
			$modal.find(".btn-text").text(" Update Role");
			$modal.find(".desc_text").text(
					'Provide the following information to update role');
			$.each(v, function(k, c) {
				$modal.find('#' + k).val(c);
			})
			$modal.find("form").attr("action", $this.data('action'));
})

$('#user_modal').on('hidden.bs.modal', function(e) {
			$c = $(e.currentTarget);
			$c.find("form")[0].reset();
			$c.find(".head_text").text(" New Role");
			$c.find(".btn-text").text(" Add Role");
			$c.find(".desc_text").text(
					'Provide the following information to create new role');
			$c.find("form").attr("action", $c.find("#url_add").val());
});
$('.sr-reset').on("click",function(){
	$this = $(this), $modal = $('#password_reset_modal');
	$modal.find("form").attr("action", $this.data('action'));
});