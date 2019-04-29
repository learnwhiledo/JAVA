package models;

public class DVD extends Material {
	
	private String director;
	private String catalog;
	private int runnningTime;
	public DVD(int id, String title, String branch, String director, String catalog, int runnningTime) {
		super(id, title, branch);
		this.director = director;
		this.catalog = catalog;
		this.runnningTime = runnningTime;
	}

}
