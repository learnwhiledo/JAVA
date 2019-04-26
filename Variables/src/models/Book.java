package models;

public class Book {
	private int bookID;
	private String title;
	private String author;
	private String ISBID;
	
	public Book(int bookID,String title,String author,String ISBID) {
		this.bookID=bookID;
		this.title=title;
		this.author=author;
		this.ISBID=ISBID;
		
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getISBID() {
		return ISBID;
	}
}
