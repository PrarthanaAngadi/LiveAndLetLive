package com.webtools.finalproject.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue
	private long reservationID;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hostID")
	private Person hostID;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="travellerID")
	private Person travellerID;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="listingID")
	private Listing listingID;
	
	@Column(name="CheckIn")
	private String checkIn;
	
	@Column(name="CheckOut")
	private String checkOut;

	@Column(name="Status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reservation() {
	}

	public long getReservationID() {
		return reservationID;
	}

	public void setReservationID(long reservationID) {
		this.reservationID = reservationID;
	}

	public Person getHostID() {
		return hostID;
	}

	public void setHostID(Person hostID) {
		this.hostID = hostID;
	}

	public Person getTravellerID() {
		return travellerID;
	}

	public void setTravellerID(Person travellerID) {
		this.travellerID = travellerID;
	}

	public Listing getListingID() {
		return listingID;
	}

	public void setListingID(Listing listingID) {
		this.listingID = listingID;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	
}
