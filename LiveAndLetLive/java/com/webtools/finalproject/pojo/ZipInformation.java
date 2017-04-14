package com.webtools.finalproject.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ZipInformation")
public class ZipInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Zip",unique=true,nullable=false)
	private int zip;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Country")
	private String country;
	
	//@OneToMany(fetch=FetchType.EAGER,mappedBy="zipinformation",cascade=CascadeType.ALL)
	//private Set<Person> person;
	
	
	public ZipInformation() {
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
	/*public Set<Person> getPerson() {
		return person;
	}
	public void setPerson(Set<Person> person) {
		this.person = person;
	}*/
	
	

}
