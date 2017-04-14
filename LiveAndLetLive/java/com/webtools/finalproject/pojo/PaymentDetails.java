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
@Table(name="PaymentDetails")
public class PaymentDetails {
	
	@Id
	@GeneratedValue
	private long paymentID;
	
	@Column(name="CardNumber")
	private long cardNumber;
	
	@Column(name="ExpiryDate")
	private String expiryDate;
	
	@Column(name="CVV")
	private int cvv;
	
	@Column(name="Amount")
	private int amount;
	
	@Column(name="Status")
	private String status;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ReservationID")
	private Reservation reservation;
	
	public PaymentDetails() {
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
}
