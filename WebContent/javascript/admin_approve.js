function setSelectedId(submittedButton){
	var $submittedButton = $(submittedButton);
	$id = $submittedButton.parent().siblings(".current_id").html();
	document.getElementById("selected_id").value = $id;
}