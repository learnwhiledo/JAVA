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
	public Customer(String title, String firstName, String surname, String address, String phoneNo, String Email,
			int custmerNo, genderType gender) {
		this.setName(title, firstName, surname);
		this.Address = address;
		this.phoneNo = phoneNo;
		this.Email = Email;
		this.custNo = custmerNo;
		this.Gender = gender;
		this.isValid = true;
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR, 1);
		this.expiryDate = gCal.getTime();

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
		result = prime * result + custNo;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isValid ? 1231 : 1237);
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Gender != other.Gender)
			return false;
		if (custNo != other.custNo)
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isValid != other.isValid)
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
