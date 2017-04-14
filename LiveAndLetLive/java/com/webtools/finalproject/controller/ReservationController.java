package com.webtools.finalproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.webtools.finalproject.dao.ReservationDAO;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.PaymentDetails;
import com.webtools.finalproject.pojo.Reservation;
import com.webtools.finalproject.pojo.Traveller;

@Controller
public class ReservationController {

	@RequestMapping(value = "/reservation.htm", method = RequestMethod.GET)
	public String doInitializeForm1(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("traveller") Traveller traveller, BindingResult result) throws Exception {
		HttpSession session = req.getSession();
		long selectedListingID = Long.parseLong(req.getParameter("Listingid"));
		session.setAttribute("selectedListingID", selectedListingID);
		Traveller loggedInTraveller = null;
		if (session != null) {
			loggedInTraveller = (Traveller) session.getAttribute("traveller");

		}
		if (loggedInTraveller == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);
			return null;
		} else {
			long listingID = (Long) (session.getAttribute("selectedListingID"));
			ListingDAO ld = new ListingDAO();
			Listing selectedListing = ld.searchListingByListingID(listingID);
			if (loggedInTraveller.getPersonID() != selectedListing.getTraveller().getPersonID()) {
				int days = calculateDays(session);
				int price = selectedListing.getPricePerDay();
				int amount = days * price;
				req.setAttribute("amount", amount);
				req.setAttribute("selectedListing", selectedListing);
			} else {
				session.removeAttribute("checkin");
				session.removeAttribute("checkout");
			}
			return "reservation";
		}
	}

	@RequestMapping(value = "/reservation.htm", method = RequestMethod.POST)
	public String doSubmitForm1(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession httpSession = req.getSession();
		Traveller t = (Traveller) httpSession.getAttribute("traveller");
		long listingID = (Long) (httpSession.getAttribute("selectedListingID"));

		ListingDAO ld = new ListingDAO();
		Listing selectedListing = ld.searchListingByListingID(listingID);

		ReservationDAO rd = new ReservationDAO();
		Reservation r = new Reservation();
		r.setCheckIn(String.valueOf(httpSession.getAttribute("checkin")));
		r.setCheckOut(String.valueOf(httpSession.getAttribute("checkout")));
		r.setTravellerID(t);
		r.setHostID(selectedListing.getTraveller());
		r.setListingID(selectedListing);
		r.setStatus("Confirmed");

		PaymentDetails pd = new PaymentDetails();
		pd.setAmount(selectedListing.getPricePerDay());
		pd.setCardNumber(Long.parseLong(req.getParameter("cardnumber")));
		pd.setCvv(Integer.parseInt(req.getParameter("cvv")));
		pd.setExpiryDate(req.getParameter("expirydate"));
		pd.setReservation(r);
		pd.setStatus("paid");
		rd.createReservation(r);
		PaymentDetails paydet = rd.insertPaymentDetails(pd);
		if (paydet == null) {
			req.setAttribute("errorMessage", "Hibernate Issue while insert payment details");
			return "error";
		}

		httpSession.removeAttribute("checkin");
		httpSession.removeAttribute("checkout");
		req.removeAttribute("selectedListing");
		req.setAttribute("reservationid", r.getReservationID());
		return "reservation";

	}

	@RequestMapping(value = "/viewReservations.htm", method = RequestMethod.GET)
	public String doInitializeForm2(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession httpSession = req.getSession();
		Traveller t = null;
		if (httpSession != null) {
			t = (Traveller) httpSession.getAttribute("traveller");
		}
		long id = t.getPersonID();
		ReservationDAO rd = new ReservationDAO();
		ArrayList<Reservation> reservationList = rd.getReservationsByTravellerID(id);
		ArrayList<String> reservationStatus = null;
		if (reservationList != null && !reservationList.isEmpty()) {
			reservationStatus = new ArrayList<String>();
			Date date = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(modifiedDate);
			for (Reservation reservation : reservationList) {
				String checkOutDate = reservation.getCheckOut();
				Date checkOut = new SimpleDateFormat("yyyy-MM-dd").parse(checkOutDate);
				if (reservation.getStatus().equalsIgnoreCase("Cancelled"))
					reservationStatus.add("historic");
				else if (checkOut.compareTo(currentDate) >= 0)
					reservationStatus.add("active");
				else if (checkOut.compareTo(currentDate) < 0)
					reservationStatus.add("historic");

			}
			req.setAttribute("reservationList", reservationList);
			req.setAttribute("reservationStatus", reservationStatus);
		}
		return "viewReservation";
	}

	@RequestMapping(value = "/cancellation.htm", method = RequestMethod.GET)
	public String doInitializeForm3(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long reservationID = Long.parseLong(req.getParameter("reservationID"));
		ReservationDAO rd = new ReservationDAO();
		rd.updateCancellationStatus(reservationID);
		doInitializeForm2(req, res);
		req.setAttribute("infoMessage", "Your request has been sent please re-login to check the status");
		return "viewReservation";
	}

	public int calculateDays(HttpSession session) {
		SearchController sc = new SearchController();
		Date sessionCheckIn = sc.formatDate(String.valueOf(session.getAttribute("checkin")));
		Date sessionCheckOut = sc.formatDate(String.valueOf(session.getAttribute("checkout")));
		long diff = sessionCheckOut.getTime() - sessionCheckIn.getTime();
		int days = (int) (diff / (1000 * 24 * 60 * 60));
		return days;
	}
}
