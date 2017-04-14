package com.webtools.finalproject.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="ListingPhotos")
public class ListingPhotos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PhotoID")
	private int photoID;
	
	@Column(name="PhotoPath")
	private String photoPath;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="ListingID")
	private Listing listing;

	@Transient
	private MultipartFile photo;
	
	public ListingPhotos() {
	}

	public int getPhotoID() {
		return photoID;
	}

	public void setPhotoID(int photoID) {
		this.photoID = photoID;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	
	
	
	}
