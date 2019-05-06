package models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Customer;
import models.CustomerNotFoundException;
import models.CustomerRecords;
import utilities.genderType;

class CustomerRecordsTest {
	private CustomerRecords customers;
	public CustomerRecordsTest() {
		this.customers = new CustomerRecords();
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		customers.addCustomer(suneel);	
	}

	@Test
	void addCustomerTest() {
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(sridevi);	
		assertEquals(2, customers.getNoOfCustomers());		
	}
	
	@Test
	void notAddingDuplicatedTest() {		
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		customers.addCustomer(suneel);	
		assertEquals(1, customers.getNoOfCustomers());	
	}
	@Test
	void addingMoreCustomers() {
		Customer suneel = new Customer("Mr", "hari", "Manyam", "Hyderabad", "9705984789", "",0,genderType.M);	
		Customer sridevi = new Customer("Miss", "Sridevi", "manyam", "Hyderabad", "8985989808", "",0,genderType.F);	
		customers.addCustomer(suneel);
		customers.addCustomer(sridevi);
		assertEquals(3, customers.getNoOfCustomers());	
	}
	
	@Test
	void getnoOfCustomerTest() {
		assertEquals(1, customers.getNoOfCustomers());	
	}
	@Test
	void findCustomerTest() {
		try {
			Customer findedCust = customers.findCustomer("Suneel");
			assertEquals("Suneel", findedCust.getFirstName());
		} catch (CustomerNotFoundException e) {
			fail("Searching Filed");
		}
		
	}
	
	@Test
	void findCustomerWihtSpacesTest() {
		try {
			Customer findedCust = customers.findCustomer(" Suneel  ");
			assertEquals("Suneel", findedCust.getFirstName());
		} catch (CustomerNotFoundException e) {
			fail("Searching Filed");
		}
		
	}
	
	@Test
	void customerNotFoundTest() {
		try {
			Customer findedCust = customers.findCustomer(" sdsadsadsa  ");
			fail("found customer with invalid data");
		} catch (CustomerNotFoundException e) {
			
		}
		
	}

}
