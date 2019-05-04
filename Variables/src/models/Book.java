package models;

public class Book extends Material {
	private String author;
	private String ISBID;
	private int noOfPages;

	public Book(int id, String title, String author, String ISBID, String branch, int noOfPages) {
		super(id, title, branch);
		this.author = author;
		this.ISBID = ISBID;
		this.noOfPages = noOfPages;

	}
	public String getAuthor() {
		return author;
	}

	public String getISBID() {
		return ISBID;
	}
	public int getLoanPeriod() {
		return 7;
	}
}
