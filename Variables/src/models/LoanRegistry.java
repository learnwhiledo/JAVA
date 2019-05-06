package models;

import java.util.ArrayList;

import utilities.LoanStatus;

public class LoanRegistry {
	private ArrayList<Loan> registry;

	public LoanRegistry() {
		this.registry = new ArrayList<Loan>();

	}

	public void addLoan(Loan loan) throws LoanAlreadyExistsException {

		if (registry.contains(loan)) {
			throw new LoanAlreadyExistsException();
		}

		registry.add(loan);
	}

	public Loan findLoan(int bookid) throws LoanNotFoundException {
		for (Loan loan : registry) {
			if (loan.getBook().getId() == bookid && loan.getStatus() == LoanStatus.CURRENT) {
				return loan;
			}
		}
		throw new LoanNotFoundException();
	}

	public boolean isBookOnLoan(Book book) {
		try {
			Loan foundLoan = findLoan(book.getId());
			return true;
		} catch (LoanNotFoundException e) {
			return false;

		}
	}
}
