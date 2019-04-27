package models;
import java.util.Date;
import java.util.GregorianCalendar;

import utilities.genderType;

public class Customer {
	// Variables
	private String title;
	private String firstName;
	private String surname;
	private String Address;
	private String phoneNo;
	private String Email;
	private genderType Gender;
	private boolean isValid;
	private int custNo;
	private Date expiryDate;
	

	// Constructors
	public Customer(String title, String firstName, String surname,
					String address, String phoneNo, String Email,int custmerNo,genderType gender) {
		this.setName(title, firstName, surname);		
		this.Address =address;
		this.phoneNo =phoneNo;
		this.Email =Email;
		this.custNo =custmerNo;
		this.Gender=gender;
		this.isValid =true;
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR,1);
		this.expiryDate =gCal.getTime();
	
	}

	// Methods
	private void setName(String title, String firstName, String surname) {
		this.title = title;
		this.firstName = firstName;
		this.surname = surname;
	}

	public String getMailingName() {
		return this.title + " " + this.firstName + " " + this.surname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.surname;
	}
	
	public genderType getGender() {
		return this.Gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getEmail() {
		return Email;
	}
	public String getAddress() {
		return Address;
	}
	public boolean getIsValid() {
		return isValid;
	}
	public int getCustNo() {
		return custNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}
}
