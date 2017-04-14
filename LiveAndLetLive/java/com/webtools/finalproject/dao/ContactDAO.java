package com.webtools.finalproject.dao;


import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.webtools.finalproject.pojo.Contact;

public class ContactDAO extends DAO {
	
	public void addNewMessage(Contact contact) throws Exception
	{
		try
		{
		begin();
		getSession().save(contact);
		commit();
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while adding a new Message"+e.getStackTrace());
		}
	}
	public ArrayList<Contact> getAllMessages() throws Exception
	{
		try
		{
		begin();
		Query q = getSession().createQuery("from Contact");
		ArrayList<Contact> listOfMessages = (ArrayList<Contact>) q.list();
		commit();
		return listOfMessages;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while fetching all Messages"+e.getStackTrace());
		}
	}
	public Contact getMessageByMessageID(long id) throws Exception
	{
		try
		{
		begin();
		Query q = getSession().createQuery("from Contact where contactID = :id");
		q.setLong("id", id);
		Contact contact = (Contact)q.uniqueResult();
		commit();
		return contact;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while fetching Message using contactID : "+id,e);
		}
	}
	public int updateMessageStatusByID(long id) throws Exception
	{
		try
		{
		begin();
		Query q = getSession().createQuery("Update Contact set status = :status where contactID = :id");
		q.setLong("id", id);
		q.setString("status", "Query Addressed");
		int results = q.executeUpdate();
		commit();
		return results;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new Exception("Error while fetching Message using contactID : "+id,e);
		}
	}
	

}
