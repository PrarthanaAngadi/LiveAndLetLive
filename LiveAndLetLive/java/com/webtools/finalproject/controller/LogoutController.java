package com.webtools.finalproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doInitialize(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession session = req.getSession();
		if(session!=null)
		{
			session.invalidate();
			return "goodBye";
		}
		else
		{
			req.setAttribute("errorMessage", "Session timedout!");
			return "error";
		}
	}


}
