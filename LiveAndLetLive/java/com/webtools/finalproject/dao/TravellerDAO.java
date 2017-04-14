package com.webtools.finalproject.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.webtools.finalproject.pojo.Address;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.Person;
import com.webtools.finalproject.pojo.Traveller;

public class TravellerDAO extends DAO {

	public TravellerDAO() {
	}

	public int setIsHost(long pi) throws Exception {

		try {
			begin();

			SQLQuery q = getSession().createSQLQuery("Update Traveller set IsHost = 'Yes' where PersonID = :pi");
			q.setLong("pi", pi);
			int result = q.executeUpdate();
			commit();
			return result;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not set isHost" + e.getMessage());
		}
	}

	public Traveller getUser(String username, String password) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Traveller where UserName = :username and Password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Traveller traveller = (Traveller) q.uniqueResult();
			System.out.println(traveller);
			commit();
			return traveller;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}

	public Traveller create(String userName, String password, String emailID, String firstName, String lastName,
			 String streetAddress, String aptNo, int zip, String city) throws Exception {
		try {
			begin();
			System.out.println("inside TravellerDAO create");
			Traveller traveller = new Traveller();
			Address address = new Address();

			address.setAptNo(aptNo);
			address.setCity(city);
			address.setStreetAddress(streetAddress);
			address.setState("MA");
			address.setCountry("USA");
			address.setZip(zip);
			traveller.setAddress(address);
			/*traveller.setBirthDate(birthDate);*/
			traveller.setEmailID(emailID);
			traveller.setFirstName(firstName);
			traveller.setIsHost("No");
			traveller.setLastName(lastName);
			traveller.setPassword(DigestUtils.md5Hex(password));
			traveller.setUserName(userName);

			getSession().save(address);
			getSession().save(traveller);
			commit();
			return traveller;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}

	public int getTotalNumberOfUsers() {
		begin();
		Query q = getSession().createQuery("Select count(PersonID) from Person");
		int results = ((Number) q.uniqueResult()).intValue();
		return results;
	}

	public Person checkAlreadyExistingUserByUserName(String un) throws Exception
    {
    	try{
    	begin();
    	Query q = getSession().createQuery("from Person where userName = :un");
    	q.setString("un", un);
    	Person p = (Person) q.uniqueResult();
    	commit();
    	return p;
    	}
    	catch(HibernateException e)
    	{
    		rollback();
    		throw new Exception("Exception occurred while fetching Person for username"+un,e);
    	}
    }
	public Person checkAlreadyExistingUserByEmailID(String eid) throws Exception
    {
    	try{
    	begin();
    	Query q = getSession().createQuery("from Person where emailID = :eid");
    	q.setString("eid", eid);
    	Person p = (Person) q.uniqueResult();
    	commit();
    	return p;
    	}
    	catch(HibernateException e)
    	{
    		rollback();
    		throw new Exception("Exception occurred while fetching Person for emailID"+eid,e);
    	}
    }

}