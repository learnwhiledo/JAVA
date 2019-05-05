package ui;
import java.util.HashMap;

import models.Book;

public class UI {
	public void printHeader() {
		// TODO Auto-generated method stub
		System.out.println("BookID"+"  "+"Title               "+"  "+"Author");

	}
	
	public void printBookDetails(Book book) {
		System.out.println(this.formatString(book.getId(), 6)+"  "+formatString(book.getTitle(), 20)+"  "+formatString(book.getAuthor(), 20));		
	}
	private String formatString(String start, int end) {
		if(start.length()>=end) {
			return start.substring(0,end);
		}
		else {
			while(start.length()<end) {
				start+=" ";
			}
			return start;
		}
	}
	private String formatString(int start,int end) {
		String convertedToString = String.valueOf(start);
		return this.formatString(convertedToString, end);
	}

	public void printBookCatalog(HashMap<Integer,Book> books) {
		// TODO Auto-generated method stub
		
		for(Book nextBook : books.values()) {
				this.printBookDetails(nextBook);
		}
		
	}
	

}
