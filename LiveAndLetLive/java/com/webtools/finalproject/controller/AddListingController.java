package com.webtools.finalproject.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalproject.dao.ListingDAO;
import com.webtools.finalproject.dao.ListingPhotosDAO;
import com.webtools.finalproject.dao.TravellerDAO;
import com.webtools.finalproject.pojo.Address;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.ListingPhotos;
import com.webtools.finalproject.pojo.Traveller;

@Controller
@RequestMapping("/addListing.htm")
public class AddListingController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String doSubmit( HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		PrintWriter out= res.getWriter();
		HttpSession session=req.getSession();
		Traveller traveller=null;
		if(session!=null)
		{
			traveller = (Traveller) session.getAttribute("traveller");
		}
		else
		{
			req.setAttribute("errorMessage", "Session is TimedOut!!");
			return "error";
		}
		SearchController sc = new SearchController();
		Date af = sc.formatDate(req.getParameter("availableFrom"));
		Date at = sc.formatDate(req.getParameter("availableTo"));
		if(af.compareTo(at)<0)
		{
		Listing listing = new Listing();
		Address address = new Address();
		address.setZip(Integer.parseInt(req.getParameter("zip")));
		address.setCity(req.getParameter("city"));
		address.setState("MA");
		address.setCountry("USA");
		address.setStreetAddress(req.getParameter("streetAddress"));
		listing.setAddress(address);
		listing.setTraveller(traveller);
		listing.setStatus("active");
		listing.setAccomodates(Integer.parseInt(req.getParameter("accomodates")));
		listing.setAvailableFrom(req.getParameter("availableFrom"));
		listing.setAvailableTo(req.getParameter("availableTo"));
		listing.setBathrooms(Integer.parseInt(req.getParameter("bathrooms")));
		listing.setBedRooms(Integer.parseInt(req.getParameter("bedrooms")));
		listing.setBeds(Integer.parseInt(req.getParameter("beds")));
		listing.setPricePerDay(Integer.parseInt(req.getParameter("pricePerDay")));
		listing.setPropertyType(req.getParameter("propertyType"));
		listing.setRoomType(req.getParameter("roomType"));
		listing.setSummary(req.getParameter("summary"));
		ListingDAO listingDAO = new ListingDAO();
		Listing l = listingDAO.createListing(listing, address);
		if(l==null)
		{
			req.setAttribute("errorMessage", "Hibernate Issue while creating a listing");
			return "error";
		}
		if(traveller.getIsHost().equalsIgnoreCase("No"))
		{
			TravellerDAO travellerDAO=new TravellerDAO();
			int r=travellerDAO.setIsHost(traveller.getPersonID());
			if(r<1)
			{
				req.setAttribute("errorMessage", "Hibernate Issue while Updating the Traveller as Host");
				return "error";
			}
			
		}
		req.setAttribute("listing", listing);
		//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/addListing.jsp");
		//rd.forward(req, res);
		return "addListing";
		}
		else
		{
			req.setAttribute("dateMessage", "Available From is greater than Available To!!!!");
			return "addListing";
		}
	}

	@RequestMapping(method=RequestMethod.GET)
	public String doInitializeForm()
	{	
		return "addListing";
	}

}
