package com.webtools.finalproject.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Listing")
public class Listing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long listingID;
	
	@Column(name="PropertyType")
	private String propertyType;
	
	@Column(name="RoomType")
	private String roomType;
	
	@Column(name="Accomodates")
	private int accomodates;
	
	@Column(name="BedRooms")
	private int bedRooms;
	
	@Column(name="Beds")
	private int beds;
	
	@Column(name="Bathrooms")
	private int bathrooms;
	
	@Column(name="Summary")
	private String summary;
	
	@Column(name="AvailableFrom")
	private String availableFrom;
	
	@Column(name="AvailableTo")
	private String availableTo;
	
	@Column(name="PricePerDay")
	private int pricePerDay;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="PersonID")
	private Traveller traveller;

	@OneToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="AddressID")
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="listing")
	private Set<ListingPhotos> listingPhotos = new HashSet<ListingPhotos>();
	
	@Column(name="Status")
	private String status="active";
	
	
	
	
	public long getListingID() {
		return listingID;
	}

	public void setListingID(long listingID) {
		this.listingID = listingID;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getAccomodates() {
		return accomodates;
	}

	public void setAccomodates(int accomodates) {
		this.accomodates = accomodates;
	}

	public int getBedRooms() {
		return bedRooms;
	}

	public void setBedRooms(int bedRooms) {
		this.bedRooms = bedRooms;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(String availableFrom) {
		this.availableFrom = availableFrom;
	}

	public String getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(String availableTo) {
		this.availableTo = availableTo;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<ListingPhotos> getListingphotos() {
		return listingPhotos;
	}

	public void setListingphotos(Set<ListingPhotos> listingphotos) {
		this.listingPhotos = listingphotos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}