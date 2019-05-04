package ui;
import java.text.SimpleDateFormat;

import models.Book;
import models.BookCatalog;
import models.Customer;
import models.DVD;
import utilities.genderType;

public class Main {

	public static void main(String[] args) {

		SimpleDateFormat SDF =new SimpleDateFormat("dd-MMM-yyyy");
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "sunilhari9@gmai.com", 1,
				genderType.M);
		Customer manyam = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "sunilhari9@gmai.com", 1,
				genderType.M);
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "sunilhari9@gmai.com",
				1, genderType.F);
		//System.out.println(suneel.getGender());

		//System.out.println(suneel.getMailingName()+" Account expiry date is "+ SDF.format(suneel.getExpiryDate()));
		//System.out.println(sridevi.getMailingName()+" Account expiry date is "+ sridevi.getExpiryDate());
	

		Book book1 = new Book(1, "My First book on JAVA", "Suneel Manyam", "123456","hyderbad",200);
		Book book2 = new Book(2, "Advanced JAVA", "DSL", "234456","Sec",600);
		//System.out.println(book1.lend(suneel));
		//System.out.println(book1.getLoanPeriod());
		DVD dvd1 = new DVD(3,"Avengenres","Hyd","RH","Action",123);
		dvd1.relocate("Sec");
		//System.out.println(dvd1.getBranch());
		dvd1.licenced();
		//System.out.println(dvd1.lend(suneel));
		//System.out.println(dvd1.getLoanPeriod());
		BookCatalog books = new BookCatalog();
		books.addBook(book1);
		books.addBook(book2);
		
		System.out.println(suneel.equals(sridevi));

		System.out.println(suneel.equals(manyam));

		UI ui = new UI();
		ui.printHeader();
		ui.printBookCatalog(books.getBooks());
		Book foundbook = books.searchBook("JAVA");
		if (foundbook != null) {
			//System.out.println("Search results....!");
			ui.printHeader();
			ui.printBookDetails(foundbook);
		}
		else {
			System.out.println("No books found");
		}

	}

}
