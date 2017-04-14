function checkForm(form)
  {
	
    if(form.username.value == "") {
      swal("Username cannot be blank!");
      form.username.focus();
      return false;
    }
    var re = /^\w+$/;
    if(!re.test(form.username.value)) {
      swal("Username must contain only letters, numbers and underscores!");
      form.username.focus();
      return false;
    }

    if(form.username.value.length > 15) {
        swal("Username must not contain more than 15 characters!");
        form.username.focus();
        return false;
      }
    if(form.password.value == "") {
        swal("Password cannot be blank!");
        form.password.focus();
        return false;
      }
    
      
     

    return true;
  }
