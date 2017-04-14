function onCheckReservation(form)
{
	var cvv = /[0-9]+$/;
	var date = /\b(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})\b/;;
	
	if(!form.cvv.value.match(cvv))
		{
		  swal("CVV is must be valid");
	      form.cvv.focus();
	      return false;
		}
	if(form.cvv.value.length > 3 )
		{
		 swal("CVV must be only of 3 digits");
	      form.cvv.focus();
	      return false;
		}
	if(form.cvv.value.length < 3 )
	{
	 swal("CVV must be only of 3 digits");
      form.cvv.focus();
      return false;
	}
	if(form.expirydate.value.match(date))
		{
		swal("Expiry Date is invalid");
	      form.expirydate.focus();
	      return false;
		}
	return true
}