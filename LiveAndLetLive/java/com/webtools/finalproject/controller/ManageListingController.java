package com.webtools.finalproject.controller;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalproject.dao.ListingDAO;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.Traveller;

@Controller
public class ManageListingController {

	@RequestMapping(value = "/manageListing.htm", method = RequestMethod.GET)
	public String doInitializeForm1(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String action = req.getParameter("action");
		ListingDAO ld = new ListingDAO();
		if (action != null) {
			if (action.equalsIgnoreCase("delete")) {
				Long listingID = Long.parseLong(req.getParameter("param1"));
				ld.setListingStatus(listingID, "inactive");
			} else if (action.equalsIgnoreCase("update")) {
				Long listingID = Long.parseLong(req.getParameter("param1"));
				Listing listing = ld.searchListingByListingID(listingID);
				req.setAttribute("listing", listing);
				return "updateListing";
			} else {
				Long listingID = Long.parseLong(req.getParameter("param1"));
				ld.setListingStatus(listingID, "active");
			}
			req.setAttribute("infoMessage", "Your request has been sent please re-login to check the status of your listing");

		}
		HttpSession session = req.getSession();
		Traveller traveller = null;
		if (session != null) {
			traveller = (Traveller) session.getAttribute("traveller");
		}
		Set<Listing> hostListing = traveller.getListing();
		req.setAttribute("hostListing", hostListing);
		return "manageListing";

	}

	
	
	
	
}
