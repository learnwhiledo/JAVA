package models.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import models.Book;
import models.MaterialCatalogMemoryVersion;
import models.MaterialNotfoundException;

class MaterialCatalogTest {
	MaterialCatalogMemoryVersion materialCatalog;
	Book book;

	public MaterialCatalogTest() {
		materialCatalog = new MaterialCatalogMemoryVersion();
		book = new Book(1, "Learning Java", "", "", "", 0);
		materialCatalog.addMaterial(book);
	}

	@Test
	public void testAddBook() {
		int initalBookcount = materialCatalog.getNumberOfMaterials();
		Book book1 = new Book(2, "", "", "", "", 0);
		materialCatalog.addMaterial(book1);
		assertTrue(initalBookcount == materialCatalog.getNumberOfMaterials() - 1);

	}

	@Test
	public void testFindBook() {
		try {
			materialCatalog.findMaterial("Learning Java");
		} catch (MaterialNotfoundException e) {
			fail("book not found");
		}

	}

	@Test
	public void testFindBookIgnoringCase() {
		try {
			materialCatalog.findMaterial("learning Java");
		} catch (MaterialNotfoundException e) {
			fail("book not found");
		}

	}

	@Test
	public void testFindBookIgnoringSpaces() {
		try {
			materialCatalog.findMaterial(" learning Java ");
		} catch (MaterialNotfoundException e) {
			fail("book not found");
		}

	}

	@Test
	public void testNotFoundBook() {
		try {
			materialCatalog.findMaterial(" learning more Java ");
			fail("book found");
		} catch (MaterialNotfoundException e) {
			
		}

	}

}
