package com.webtools.finalproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue
	private long addressID;
	
	@Column(name="StreetAddress")
	private String streetAddress;
	@Column(name="AptNo")
	private String aptNo;
	@Column(name="Zip")
	private int zip;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="Country")
	private String country;
	public long getAddressID() {
		return addressID;
	}
	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}