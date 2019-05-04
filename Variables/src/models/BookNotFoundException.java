package models;

public class BookNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book Not found";
	}

}
