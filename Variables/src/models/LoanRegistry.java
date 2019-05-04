package models;

import utilities.LoanStatus;

public class LoanRegistry {
	private Loan[] registry;
	private int nextPosition;

	public LoanRegistry() {
		this.registry = new Loan[100];
		this.nextPosition = 0;
	}

	public void addLoan(Loan loan) throws LoanAlreadyExistsException {
		for (int i = 0; i < nextPosition; i++) {
			if (registry[i].equals(loan)) {
				throw new LoanAlreadyExistsException();
			}
		}
		registry[nextPosition] = loan;
		nextPosition++;
	}

	public Loan findLoan(int bookid) throws LoanNotFoundException {
		for (int i = 0; i < nextPosition; i++) {
			if (registry[i].getBook().getId() == bookid && registry[i].getStatus() == LoanStatus.CURRENT) {
				return registry[i];
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
