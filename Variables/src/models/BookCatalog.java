package models;

import java.util.HashMap;

public class BookCatalog {
	private HashMap< Integer, Book> bookMap;
	
	
	public BookCatalog() {
		this.bookMap = new HashMap<Integer,Book>();
	}

	
	public HashMap< Integer, Book> getBookMap() {
		return bookMap;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookMap.put(book.getId(),book);
	}

	public Book searchBook(String title) throws BookNotFoundException {
		for(Book nextBook : bookMap.values()) {
			if ( nextBook.getTitle().contains(title))
				return nextBook;
		}
		throw new BookNotFoundException();
		
	}
	public int getBooksCount() {
		// TODO Auto-generated method stub
		return bookMap.size();
	}
	public Book findBook(String title) throws BookNotFoundException {
		title = title.trim();
		for(Book nextBook : bookMap.values()) {
			if ( nextBook.getTitle().equalsIgnoreCase(title))
				return nextBook;
		}
		throw new BookNotFoundException();
	}


}
