function checkContactForm(form) {

	if (form.name.value == "") {
		swal("Name cannot be blank!");
		form.name.focus();
		return false;
	}
	var re = /^[a-zA-Z\s]+$/;
	if (!re.test(form.name.value)) {
		swal("Name must contain only characters!");
		form.name.focus();
		return false;
	}

	if (form.email.value == "") {
		swal("Email cannot be blank!");
		form.email.focus();
		return false;
	}
	var rep = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (!rep.test(form.email.value)) {
		swal("Email ID must be in the correct format");
		form.email.focus();
		return false;
	}
	if (form.subject.value == "") {
		swal("Subject cannot be blank!");
		form.subject.focus();
		return false;
	}
	if (form.subject.value.length > 100) {
		swal("Subject cannot be more than 100 characters");
		form.subject.focus();
		return false;
	}

	if (form.message.value == "") {
		swal("Message cannot be blank!");
		form.message.focus();
		return false;
	}
	if (form.message.value.length > 255) {
		swal("Message cannot be more than 255 characters");
		form.subject.focus();
		return false;
	}
	return true;
}
