package models.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import models.Book;

class BookTest {

	@Test
	void testBookEquals() {
		Book book1 = new Book(0,"Suneel","","","",0);
		Book book2 = new Book(0, "suneel", "", "", "", 1);
		assertTrue("Testing Equals method",book1.equals(book2));		
	}

	@Test
	void testBookNotEquals() {
		Book book1 = new Book(0,"Suneel","","","",0);
		Book book2 = new Book(1, "suneel", "", "", "", 1);
		assertFalse("Testing book Not Equals",book1.equals(book2));		
	}
}
