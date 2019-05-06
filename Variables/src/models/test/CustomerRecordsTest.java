package models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Customer;
import models.CustomerNotFound;
import models.CustomerRecords;
import utilities.genderType;

class CustomerRecordsTest {
	private CustomerRecords customers;
	public CustomerRecordsTest() {
		this.customers = new CustomerRecords();
	}

	@Test
	void addCustomerTest() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		customers.addCustomer(suneel);	
		assertEquals(1, customers.getNoOfCustomers());		
	}
	
	@Test
	void notAddingDuplicatedTest() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(suneel);
		customers.addCustomer(suneel);
		customers.addCustomer(suneel);
		assertEquals(1, customers.getNoOfCustomers());	
	}
	@Test
	void addingMoreCustomers() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(suneel);
		customers.addCustomer(sridevi);
		assertEquals(2, customers.getNoOfCustomers());	
	}
	
	@Test
	void getnoOfCustomerTest() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		customers.addCustomer(suneel);
		assertEquals(1, customers.getNoOfCustomers());	
	}
	@Test
	void findCustomerTest() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(suneel);
		customers.addCustomer(sridevi);
		try {
			Customer findedCust = customers.findCustomer("Suneel");
			assertEquals("Suneel", findedCust.getFirstName());
		} catch (CustomerNotFound e) {
			fail("Searching Filed");
		}
		
	}
	
	@Test
	void findCustomerWihtSpacesTest() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(suneel);
		customers.addCustomer(sridevi);
		try {
			Customer findedCust = customers.findCustomer(" Suneel  ");
			assertEquals("Suneel", findedCust.getFirstName());
		} catch (CustomerNotFound e) {
			fail("Searching Filed");
		}
		
	}
	
	@Test
	void customerNotFoundTest() {
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(suneel);
		customers.addCustomer(sridevi);
		try {
			Customer findedCust = customers.findCustomer(" sdsadsadsa  ");
			fail("found customer with invalid data");
		} catch (CustomerNotFound e) {
			
		}
		
	}

}
