package sortingObjects;

public class Book implements Comparable<Book>{
	
	private int id;
	private String title;
	private String author;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public String toString() {
		return title + " by " + author;
	}

	@Override
	public int compareTo(Book book) {
		// TODO Auto-generated method stub
		int result = this.getTitle().compareTo(book.getTitle());
		if(result == 0) {
			return (this.getAuthor().compareTo(book.getAuthor()));
		}
		else {
			return result;
		}
		
	}
		
}
