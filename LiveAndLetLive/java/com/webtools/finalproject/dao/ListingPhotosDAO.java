package com.webtools.finalproject.dao;

import com.webtools.finalproject.pojo.ListingPhotos;

public class ListingPhotosDAO extends DAO{
	
	public ListingPhotosDAO()
	{
		
	}
	public ListingPhotos addListingPhotos(ListingPhotos listingphotos) throws Exception
	{
		try{
			begin();
			System.out.println("inside listing dao");
			getSession().save(listingphotos);
			commit();
			return listingphotos;
		}
		catch(Exception e)
		{
			rollback();
            throw new Exception("Exception while adding photos: " + e.getMessage());
		}
		
	}
}
