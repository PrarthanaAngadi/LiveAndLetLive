package com.webtools.finalproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalproject.dao.ListingDAO;
import com.webtools.finalproject.dao.ReservationDAO;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.Reservation;
import com.webtools.finalproject.pojo.Traveller;

@Controller
public class SearchController {

	@RequestMapping(value = "/search.htm", method = RequestMethod.POST)
	public String doSubmitAction(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Traveller t = null;
		if (session != null) {
			t = (Traveller) session.getAttribute("traveller");

		}
		Date checkin = formatDate(req.getParameter("checkin"));
		Date checkout = formatDate(req.getParameter("checkout"));

		if (checkin.compareTo(checkout) > 0) {
			req.setAttribute("dateMessage", "Check-In Date is greater than Check-Out Date");
			if (t == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, res);

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
				rd.forward(req, res);

			}
		}

		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(modifiedDate);

		if (checkin.compareTo(currentDate) < 0) {
			req.setAttribute("dateMessage", "Check-In Date is less than current date");
			if (t == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, res);

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
				rd.forward(req, res);

			};
		
		}

		String city = req.getParameter("cityname");

		ListingDAO ld = new ListingDAO();
		ArrayList<Listing> listingByCity = ld.searchListingByCity(city);
		List<Listing> fetchedList = null;

		if (listingByCity != null && !listingByCity.isEmpty()) {
			fetchedList = new ArrayList<Listing>();

			for (Listing listing : listingByCity) {
				if (listing.getStatus().equalsIgnoreCase("active")) {
					boolean alreadyBooked = checkAvailabilityforListing(listing, checkin, checkout);

					if (!alreadyBooked) {
						Date availableFrom = formatDate(listing.getAvailableFrom());

						Date availableTo = formatDate(listing.getAvailableTo());

						if (checkin.compareTo(availableFrom) >= 0 && checkin.compareTo(availableTo) <= 0
								&& checkout.compareTo(availableFrom) >= 0 && checkout.compareTo(availableTo) <= 0) {
							fetchedList.add(listing);
						}
					}
				}
			}
		}
		session.setAttribute("checkin", req.getParameter("checkin"));
		session.setAttribute("checkout", req.getParameter("checkout"));
		req.setAttribute("fetchedList", fetchedList);
		return "searchListing";
	}

	public Date formatDate(String inputDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Date date = formatter.parse(inputDate);
			return date;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean checkAvailabilityforListing(Listing listing, Date checkin, Date checkout) throws Exception {
		long lid = listing.getListingID();
		ReservationDAO rd = new ReservationDAO();
		ArrayList<Reservation> reservationList = rd.getReservationByListingID(lid);
		if (reservationList == null)
			return false;
		else {
			for (Reservation reservation : reservationList) {
				Date rcin = formatDate(reservation.getCheckIn());
				Date rcout = formatDate(reservation.getCheckOut());
				if ((checkin.compareTo(rcin) >= 0 && checkin.compareTo(rcout) <= 0) && (checkout.compareTo(rcin) >= 0
						&& checkout.compareTo(rcout) <= 0)) {
					return true;
				}

			}
			return false;
		}
	}

}
