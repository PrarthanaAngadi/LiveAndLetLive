package com.webtools.finalproject.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalproject.dao.TravellerDAO;
import com.webtools.finalproject.pojo.Person;
import com.webtools.finalproject.pojo.Traveller;
import com.webtools.finalproject.validator.TravellerFormValidator;

@Controller
@RequestMapping("/signup.htm")
public class SignUpController {
	@Autowired
	@Qualifier("travellerFormValidator")
	TravellerFormValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doSubmitForm(@ModelAttribute("traveller") Traveller traveller, BindingResult result,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		validator.validate(traveller, result);
		if (result.hasErrors()) {
			return "addTravellerForm";
		} else {
			
			TravellerDAO td = new TravellerDAO();
			td.create(traveller.getUserName(), traveller.getPassword(), traveller.getEmailID(),
					traveller.getFirstName(), traveller.getLastName(),
					traveller.getAddress().getStreetAddress(), traveller.getAddress().getAptNo(),
					traveller.getAddress().getZip(), traveller.getAddress().getCity());
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("traveller") Traveller traveller, BindingResult result) {

		return "addTravellerForm";
	}

}
