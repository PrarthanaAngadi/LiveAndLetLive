function onCheckSearch(form)
{
	var re = /(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))/;

    if(!form.checkin.value.match(re)) {
      swal("Check-In Date is invalid");
      form.checkin.focus();
      return false;
    }

    if(!form.checkout.value.match(re)) {
        swal("Check-Out Date is invalid");
        form.checkout.focus();
        return false;
      }
    return
}