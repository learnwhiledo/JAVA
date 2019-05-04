package models;

public class BookCatalog {
	private Book[] books = new Book[100];
	private int nextPosition = 0;

	public Book[] getBooks() {
		return books;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		books[nextPosition] = book;
		nextPosition++;

	}

	public Book searchBook(String title) {
		for (int i = 0; i < books.length; i++) {

			if (books[i] != null && books[i].getTitle().contains(title))
				return books[i];
		}
		return null;
	}

	public Book findBook(String title) throws BookNotFoundException {
		for (int i = 0; i < books.length; i++) {

			if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title))
				return books[i];
		}
		throw new BookNotFoundException();
	}
}
