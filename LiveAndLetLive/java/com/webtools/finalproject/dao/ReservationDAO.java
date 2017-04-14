package com.webtools.finalproject.dao;



import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.webtools.finalproject.pojo.PaymentDetails;
import com.webtools.finalproject.pojo.Reservation;

public class ReservationDAO extends DAO{
	
	public Reservation createReservation(Reservation r) throws Exception
	{
		try
		{
			System.out.println("Inside ReservationDAO createReservation");
			begin();
			getSession().save(r);
			commit();
			return r;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while creating a new reservation"+r,e);
		}
		
	}
	public PaymentDetails insertPaymentDetails(PaymentDetails pd) throws Exception
	{
		try
		{
			System.out.println("Inside ReservationDAO insertPaymentDetails");
			begin();
			getSession().save(pd);
			commit();
			return pd;
		}
		catch(HibernateException e)
		{
			rollback();
			return null;
		//	throw new Exception("Error while add a new payment details"+pd,e);
		}	
	}
	public ArrayList<Reservation> getReservationsByTravellerID(long id) throws Exception
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Reservation where travellerID = :id");
			q.setLong("id", id);
			ArrayList<Reservation> reservationList = (ArrayList<Reservation>) q.list();
			commit();
			return reservationList;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while retrieving Reservation by traveller id : "+id,e);
		}
	}
	
	
	
	public void updateCancellationStatus(long rid) throws Exception
	{
		try{
			begin();
			Query q = getSession().createQuery("Update Reservation set status = :status where reservationID = :rid");
			q.setString("status", "Cancelled");
			q.setLong("rid", rid);
			int results = q.executeUpdate();
			if(results>0)
			{
				updatePaymentStatus(rid);
			}
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while updating the cancellation status for reservation id : "+rid,e);
		}
	}
	public int updatePaymentStatus(long rid) throws Exception
	{
		try{
			begin();
			Query q = getSession().createQuery("Update PaymentDetails set status = :status where reservation = :rid");
			q.setString("status", "Refunded");
			q.setLong("rid", rid);
			int results = q.executeUpdate();
			commit();
			return results;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while updating the payment status for reservation id : "+rid,e);
		}
	}
	
	public ArrayList<Reservation> getReservationByListingID(long lid) throws Exception
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Reservation where listingID = :lid");
			q.setLong("lid", lid);
			ArrayList<Reservation> reservationList = (ArrayList<Reservation>) q.list();
			commit();
			return reservationList;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while fetching reservation for listing id : "+lid,e);

		}
	}
}
