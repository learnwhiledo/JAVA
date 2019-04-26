
public class UI {
	public void printHeader() {
		// TODO Auto-generated method stub
		System.out.println("BookID"+"  "+"Title               "+"  "+"Author");

	}
	
	public void printBookDetails(Book book) {
		System.out.println(this.formatString(book.getBookID(), 6)+"  "+formatString(book.getTitle(), 20)+"  "+formatString(book.getAuthor(), 20));		
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

	public void printBookCatalog(Book[] books) {
		// TODO Auto-generated method stub
		for(int counter=0;counter<books.length;counter++) {
			if(books[counter]!=null) {
				this.printBookDetails(books[counter]);
			}	
		}		
		
	}
	

}
