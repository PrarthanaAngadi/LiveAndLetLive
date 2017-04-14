package com.webtools.finalproject.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.webtools.finalproject.pojo.Address;
import com.webtools.finalproject.pojo.Listing;

public class ListingDAO extends DAO{
	
	public ListingDAO(){
		
	}
	public Listing createListing(Listing listing, Address address)throws Exception{
		
		try{
			begin();
			getSession().save(address);
			getSession().save(listing);
			commit();
			return listing;
		}
		catch(HibernateException e)
		{
            rollback();
            throw new Exception("Exception while creating listing: " + e.getMessage());

		}
		
	}
	public int setListingStatus(long li, String status) throws Exception{
		try
		{
			begin();
			SQLQuery q=getSession().createSQLQuery("Update Listing set status = :status where listingID = :li");
			q.setLong("li", li);
			q.setString("status", status);
			int result = q.executeUpdate();
			commit();
			return result;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Update failed for listingID"+li+" " +e.getMessage());
		}
	}
	
	public Listing searchListingByListingID(long li)throws Exception{
		try
		{
			System.out.println("inside listingdao searchlistingByListingid method");
			begin();
			Query q = getSession().createQuery("from Listing where listingID = :li");
			q.setLong("li",li);
			Listing listing = (Listing)q.uniqueResult();
			commit();
			return listing;
		}
		catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get Listing for ListingID : " + li, e);
        }
	}
	public ArrayList<Listing> searchListingByCity(String inputCity)throws Exception{
		try
		{
			System.out.println("inside listingdao searchlistingByCity method");
			begin();
			Query q = getSession().createQuery("from Listing where address IN (from Address where city = :inputCity)");
			q.setString("inputCity",inputCity);
			ArrayList<Listing> listing= (ArrayList<Listing>) q.list();
			commit();
			return listing;
		}
		catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get Listing for City : " + inputCity, e);
        }
	}

}
