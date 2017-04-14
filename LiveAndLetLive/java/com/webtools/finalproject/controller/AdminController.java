package com.webtools.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.finalproject.dao.ContactDAO;
import com.webtools.finalproject.pojo.Contact;
import com.webtools.finalproject.pojo.EmailDetails;

@Controller
public class AdminController {
	
	@RequestMapping(value="/contact.htm", method = RequestMethod.POST)
	public void doSubmitAction1(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		Contact contact = new Contact();
		contact.setEmail(req.getParameter("email"));
		contact.setMessage(req.getParameter("message"));
		contact.setName(req.getParameter("name"));
		contact.setSubject(req.getParameter("subject"));
		contact.setStatus("Response Pending");
		ContactDAO cd = new ContactDAO();
		cd.addNewMessage(contact);
		
		res.sendRedirect("index.jsp");
	}
	@RequestMapping(value="/email.htm", method = RequestMethod.GET)
	public String doSubmitAction2(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		long messageID = Long.parseLong(req.getParameter("messageid"));
		ContactDAO cd = new ContactDAO();
		Contact contact = cd.getMessageByMessageID(messageID);
		req.setAttribute("contact",contact);
		return "admin";
		
	}
	@RequestMapping(value="/sendEmail.htm", method = RequestMethod.POST)
	public String doSubmitAction3(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		EmailDetails em = new EmailDetails();
		String q = "Submitted Query";
		String r = "Please find our response";
		String responseMessage = req.getParameter("responsemessage");
		String submittedQuery = req.getParameter("query");
		String message = q.concat("\n"+submittedQuery+"\n"+r+"\n"+responseMessage);
		em.sendMail(req.getParameter("from"), "apijavaproject", message, req.getParameter("to"),req.getParameter("subject"));
		ContactDAO cd=new ContactDAO();
		int results=cd.updateMessageStatusByID(Long.parseLong(req.getParameter("contactID")));
		if(results>0)
		{
			LoginController lc=new LoginController();
			return (lc.doSubmit2(req, res));
		}
		return null;
		
	}
	
}
