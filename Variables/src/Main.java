
public class Main {

	public static void main(String[] args) {		
		
		Customer suneel = new Customer("Mr", "Suneel" ,"Manyam","Hyderabad","9705984789","sunilhari9@gmai.com",1,genderType.M);
		Customer sridevi = new Customer("Miss", "Sridevi" ,"Garapati","Hyderabad","8985989808","sunilhari9@gmai.com",1,genderType.F);
		System.out.println(suneel.getGender());
		System.out.println(suneel.getMailingName());
		System.out.println(sridevi.getMailingName());
		
		Book book1= new Book(1, "My First book on JAVA", "Suneel Manyam", "123456");
		Book book2 = new Book(2, "Advanced JAVA", "DSL", "234456");
		UI ui = new UI();
		ui.printHeader();
		ui.printBookDetails(book1);
		ui.printBookDetails(book2);

	}

}
