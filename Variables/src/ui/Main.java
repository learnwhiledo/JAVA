package ui;

import java.text.SimpleDateFormat;

import models.Book;
import models.MaterialCatalog;
import models.MaterialNotfoundException;
import models.Customer;
import models.DVD;
import models.Loan;
import models.LoanAlreadyExistsException;
import models.LoanRegistry;
import models.Material;
import utilities.genderType;

public class Main {

	public static void main(String[] args) {

		SimpleDateFormat SDF = new SimpleDateFormat("dd-MMM-yyyy");
		Customer suneel = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "sunilhari9@gmai.com", 1,
				genderType.M);
		Customer manyam = new Customer("Mr", "Suneel", "Manyam", "Hyderabad", "9705984789", "sunilhari9@gmai.com", 1,
				genderType.M);
		Customer sridevi = new Customer("Miss", "Sridevi", "Garapati", "Hyderabad", "8985989808", "sunilhari9@gmai.com",
				1, genderType.F);
		// System.out.println(suneel.getGender());

		// System.out.println(suneel.getMailingName()+" Account expiry date is "+
		// SDF.format(suneel.getExpiryDate()));
		// System.out.println(sridevi.getMailingName()+" Account expiry date is "+
		// sridevi.getExpiryDate());

		Book book1 = new Book(1, "My First book on JAVA", "Suneel Manyam", "123456", "hyderbad", 200);
		Book book2 = new Book(2, "Advanced JAVA", "DSL", "234456", "Sec", 600);
		// System.out.println(book1.lend(suneel));
		// System.out.println(book1.getLoanPeriod());
		DVD dvd1 = new DVD(3, "Avengenres", "Hyd", "Speel burg", "Action", 123);
		DVD dvd2 = new DVD(4, "JOHN", "Hyd", "Gale", "Action", 123);
		dvd1.relocate("Sec");
		// System.out.println(dvd1.getBranch());
		dvd1.licenced();
		// System.out.println(dvd1.lend(suneel));
		// System.out.println(dvd1.getLoanPeriod());
		MaterialCatalog materials = new MaterialCatalog();
		materials.addMaterial(book1);
		materials.addMaterial(book2);
		materials.addMaterial(dvd1);
		materials.addMaterial(dvd2);

		//System.out.println(suneel.equals(sridevi));

		//System.out.println(suneel.equals(manyam));

		UI ui = new UI();
		ui.printHeader();
		ui.printMaterialCatalog(materials.getMaterialMap());
		Material foundMaterial;
		try {
			foundMaterial = materials.findMaterial("My First book on JAVA");
			ui.printHeader();
			System.out.println(foundMaterial.toString());
		} catch (MaterialNotfoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No materials found");
		}
			

		try {
			foundMaterial = materials.findMaterial("JOHN");
			ui.printHeader();
			System.out.println(foundMaterial.toString());
		} catch (MaterialNotfoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant find book wiht java");
		}
		
		Loan loan = new Loan(1, suneel, book1);
		System.out.println(loan);
		System.out.println(loan.getDueDate());
		LoanRegistry registry = new LoanRegistry();
		try {
			registry.addLoan(loan);
			System.out.println("Loan added to registry");
		} catch (LoanAlreadyExistsException e) {
			System.out.println("Loan already Exists");
		}
		
		try {
			registry.addLoan(loan);
			System.out.println("Loan added to registry");
		} catch (LoanAlreadyExistsException e) {
			System.out.println("Loan already Exists");
		}

	}
	

}
