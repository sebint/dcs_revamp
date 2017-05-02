/**
 * 
 */
$(".sr-update").on(
		"click",
		function() {
			$this = $(this), $modal = $('.role_modal');
			var v = JSON.parse($this.prev().val());
			$modal.find(".head_text").text(" Update Role");
			$modal.find(".btn-text").text(" Update Role");
			$modal.find(".desc_text").text(
					'Provide the following information to update role');
			$.each(v, function(k, c) {
				$modal.find('#' + k).val(c);
			})
			$modal.find("form").attr("action", $this.data('action'));
		})

$('.role_modal').on(
		'hidden.bs.modal',
		function(e) {
			$c = $(e.currentTarget);
			$c.find("form")[0].reset();
			$c.find(".head_text").text(" New Role");
			$c.find(".btn-text").text(" Add Role");
			$c.find(".desc_text").text(
					'Provide the following information to create new role');
			$c.find("form").attr("action", $c.find("#url_add").val());
		});