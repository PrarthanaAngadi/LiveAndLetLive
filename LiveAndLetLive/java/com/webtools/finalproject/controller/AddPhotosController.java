package com.webtools.finalproject.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.webtools.finalproject.dao.ListingDAO;
import com.webtools.finalproject.dao.ListingPhotosDAO;
import com.webtools.finalproject.pojo.Listing;
import com.webtools.finalproject.pojo.ListingPhotos;

@Controller
@RequestMapping("/addPhotos.htm")
public class AddPhotosController {
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String doSubmit(@ModelAttribute("listingphotos")ListingPhotos listingphotos, BindingResult result, @RequestParam("photo")MultipartFile photoFile, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		long listingID = Long.parseLong(req.getParameter("param1"));
		listingphotos.setPhoto(photoFile);
		File file;
	       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
	       String path = null;
	       if(check.equalsIgnoreCase("\\")) {
	        path = req.getSession().getServletContext().getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
	    }
	    
	        if(check.equalsIgnoreCase("/")) {
	       path = req.getSession().getServletContext().getRealPath("").replace("build/","");
	       path += "/"; //Adding trailing slash for Mac systems.

	    }
	        System.out.println("check"+listingphotos.getPhoto());
	        if(listingphotos.getPhoto() != null) {
	            
	            String fileNameWithExt = System.currentTimeMillis() + listingphotos.getPhoto().getOriginalFilename();
	            file = new File(path+fileNameWithExt);
	            String context = req.getSession().getServletContext().getContextPath();
	            listingphotos.getPhoto().transferTo(file);
	            listingphotos.setPhotoPath(context +"/" + fileNameWithExt);
	        	
	            ListingDAO ld=new ListingDAO();
	            Listing listing = ld.searchListingByListingID(listingID);
	            listingphotos.setListing(listing);
	            ListingPhotosDAO lpd = new ListingPhotosDAO();
	            ListingPhotos lp = lpd.addListingPhotos(listingphotos);
	            if(lp==null)
	            {
	            	req.setAttribute("errorMessage", "Hibernate Issue while add listing photos");
	            	return "error";
	            }
	            req.setAttribute("listingid", listing.getListingID());
	        }
	        
		return "addPhotos";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String doInitializeForm(@ModelAttribute("listingphotos")ListingPhotos listingphotos, BindingResult result,HttpServletRequest req, HttpServletResponse res)
	{
		
		req.setAttribute("listingid", req.getParameter("param1"));
		return "addPhotos";
	}
}
