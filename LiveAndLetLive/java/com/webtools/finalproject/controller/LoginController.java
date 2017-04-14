package com.webtools.finalproject.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalproject.dao.ContactDAO;
import com.webtools.finalproject.dao.ListingDAO;
import com.webtools.finalproject.dao.ReservationDAO;
import com.webtools.finalproject.dao.TravellerDAO;
import com.webtools.finalproject.pojo.Contact;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.Person;
import com.webtools.finalproject.pojo.Reservation;
import com.webtools.finalproject.pojo.Traveller;

@Controller
@RequestMapping("/login.htm")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String doInitializeForm() {
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession httpSession = req.getSession();

		String u = req.getParameter("username");
		String p = req.getParameter("password");
		if (u.equals("admin") && DigestUtils.md5Hex("admin123").equals(DigestUtils.md5Hex(p))) {
			TravellerDAO td = new TravellerDAO();
			httpSession.setAttribute("totalNumberOfUsers", td.getTotalNumberOfUsers());

			String page = doSubmit2(req, res);
			// return page;
			/*
			 * ContactDAO cd = new ContactDAO(); ArrayList<Contact>
			 * listOfMessages = cd.getAllMessages();
			 * req.setAttribute("listOfMessages", listOfMessages);
			 */
			return page;
		} else {
			TravellerDAO td = new TravellerDAO();
			String pwd = DigestUtils.md5Hex(req.getParameter("password"));
			Traveller t = (Traveller) td.getUser(req.getParameter("username"), pwd);
			if (t != null) {
				httpSession.setAttribute("traveller", t);
				if (httpSession.getAttribute("selectedListingID") == null)
					return "welcome";
				else {
					long listingID = (Long) (httpSession.getAttribute("selectedListingID"));
					ListingDAO ld = new ListingDAO();
					Listing selectedListing = ld.searchListingByListingID(listingID);
					if (t.getPersonID() != selectedListing.getTraveller().getPersonID()) {
						ReservationController rc = new ReservationController();
						int days = rc.calculateDays(httpSession);
						int price = selectedListing.getPricePerDay();
						int amount = days * price;
						req.setAttribute("amount", amount);
						req.setAttribute("selectedListing", selectedListing);
					} else {
						httpSession.removeAttribute("checkin");
						httpSession.removeAttribute("checkout");
					}
					return "reservation";
				}
			} else {
				req.setAttribute("invalidUser", "invalidUser");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, res);
			}
		}
		return null;

	}

	public String doSubmit2(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ContactDAO cd = new ContactDAO();
		ArrayList<Contact> listOfMessages = cd.getAllMessages();
		req.setAttribute("listOfMessages", listOfMessages);
		return "admin";

	}

}
