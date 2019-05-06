package models;

import java.util.HashSet;
import java.util.Iterator;

public class CustomerRecords {
	private HashSet<Customer> customers;

	public CustomerRecords() {
		this.customers = new HashSet<Customer>();
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public Customer findCustomer(String name) throws CustomerNotFoundException {
		name = name.trim();
		for (Customer customer : this.customers) {
			if (customer.getMailingName().contains(name)) {
				return customer;
			}
		}

		throw new CustomerNotFoundException();

	}

	public int getNoOfCustomers() {
		return customers.size();
	}
}
