function checkPhotoForm(form)
{
	if(form.photo.value =="")
		{
		swal("Please choose a file to be uploaded");
		form.photo.focus();
		return false;
		}
	return true;
}