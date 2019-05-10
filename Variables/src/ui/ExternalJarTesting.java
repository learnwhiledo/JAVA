package ui;

import org.apache.commons.codec.language.Metaphone;

public class ExternalJarTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metaphone mph = new Metaphone();
		System.out.println(mph.encode("sunil"));
		System.out.println(mph.encode("suneel"));

	}

}
