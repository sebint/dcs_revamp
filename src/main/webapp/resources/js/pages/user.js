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

$("#boolLockPwd").change(function(){
	$(this).is(":checked")? $("#intPwdAttempt").removeAttr("readonly").val(5): $("#intPwdAttempt").attr("readonly","readonly").val(0);
});