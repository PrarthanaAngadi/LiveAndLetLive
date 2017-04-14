package com.webtools.finalproject.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Traveller")
@PrimaryKeyJoinColumn(name="PersonID")
public class Traveller extends Person{
	
	@Column(name="IsHost")
	private String isHost;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="traveller")
	private Set<Listing> listing = new HashSet<Listing>();

	public Traveller() {
	}

	public String getIsHost() {
		return isHost;
	}

	public void setIsHost(String isHost) {
		this.isHost = isHost;
	}

	public Set<Listing> getListing() {
		return listing;
	}

	public void setListing(Set<Listing> listing) {
		this.listing = listing;
	}

	

	
	
	
}
