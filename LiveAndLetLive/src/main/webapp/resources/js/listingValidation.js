function checkListingForm(form)
  {
	
    if(form.summary.value == "") {
      swal("Summary cannot be blank!");
      form.summary.focus();
      return false;
    }
    var re = /(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))/;

    if(!form.availableFrom.value.match(re)) {
      swal("Available From Date is invalid");
      form.availableFrom.focus();
      return false;
    }

    if(!form.availableTo.value.match(re)) {
        swal("Available To Date is invalid");
        form.availableTo.focus();
        return false;
      }
    var y = /^\d+$/;
    if(!form.pricePerDay.value.match(y)) {
        swal("Price Per Day must be numeric");
        form.pricePerDay.focus();
        return false;
      }
    var z = /(^\d{5}$)|(^\d{5}-\d{4}$)/;
      if(!form.zip.value.match(z)) {
        swal("Zip Code is invalid");
        form.zip.focus();
        return false;
      }
      var a = /^[a-zA-Z0-9\s]+$/;
      if(!form.streetAddress.value.match(a))
    	  {
          swal("Street Address invalid");
          form.streetAddress.focus();
          return false;
    	  }
      
     

    return true;
  }
