package models;
import java.util.Date;
import java.util.GregorianCalendar;

import utilities.LoanStatus;

public class Loan {
	private int id;
	private Customer customer;
	private Book book;
	private Date startDate;
	private Date dueDate;
	private Date retunDate;
	private LoanStatus status;
	
	public Loan(int id, Customer customer, Book book) {
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.startDate = new Date();
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);
		this.dueDate = gCal.getTime();;
		this.status = LoanStatus.CURRENT;
	}

	@Override
	public String toString() {
		return "customer " + customer.getMailingName() + "Has borrowed following, book " + book.getTitle() + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Loan other = (Loan) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public Book getBook() {
		return this.book;
	}
	
	public Date getDueDate() {
		return this.dueDate;
	}
	
	public void endLoan() {
		this.status= LoanStatus.HISTORIC;
		this.retunDate = new Date();

	}

	public LoanStatus getStatus() {
		return this.status;		
	}
	
	
	
}
