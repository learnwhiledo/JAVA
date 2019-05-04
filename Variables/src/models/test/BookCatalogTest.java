package models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;

class BookCatalogTest {
	BookCatalog bc;
	Book book;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book = new Book(1, "Learning Java", "", "", "", 0);
		bc.addBook(book);
	}

	@Test
	public void testAddBook() {
		int initalBookcount = bc.getBooksCount();
		Book book1 = new Book(2, "", "", "", "", 0);
		bc.addBook(book1);
		assertTrue(initalBookcount == bc.getBooksCount() - 1);

	}

	@Test
	public void testFindBook() {
		try {
			bc.findBook("Learning Java");
		} catch (BookNotFoundException e) {
			fail("book not found");
		}

	}

	@Test
	public void testFindBookIgnoringCase() {
		try {
			bc.findBook("learning Java");
		} catch (BookNotFoundException e) {
			fail("book not found");
		}

	}

	@Test
	public void testFindBookIgnoringSpaces() {
		try {
			bc.findBook(" learning Java ");
		} catch (BookNotFoundException e) {
			fail("book not found");
		}

	}

	@Test
	public void testNotFoundBook() {
		try {
			bc.findBook(" learning more Java ");
			fail("book found");
		} catch (BookNotFoundException e) {
			
		}

	}

}
