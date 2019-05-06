package ui;
import java.util.HashMap;

import models.Book;
import models.Material;

public class UI {
	public void printHeader() {
		// TODO Auto-generated method stub
		System.out.println("MaterialID"+"  "+"Title               "+"  "+"Author");

	}
	
	public void printBookDetails(Material material) {
		System.out.println(this.formatString(material.getId(), 6)+"  "+formatString(material.getTitle(), 20));		
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

	public void printMaterialCatalog(HashMap<Integer, Material> materialMap) {
		// TODO Auto-generated method stub

		for(Material material : materialMap.values()) {
				System.out.println(material.toString());
		}
	}
	

}
