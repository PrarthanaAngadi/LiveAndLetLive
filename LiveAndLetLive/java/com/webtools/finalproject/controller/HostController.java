package com.webtools.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webtools.finalproject.pojo.Listing;

@Controller
@RequestMapping("/host.htm")
public class HostController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String doInitializeForm()
	{
		return "host";
	}
}
