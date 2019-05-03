package models;

public class DVD extends Material {
	
	private String director;
	private String catalog;
	private int runnningTime;
	private boolean licence;
	
	public DVD(int id, String title, String branch, String director, String catalog, int runnningTime) {
		super(id, title, branch);
		this.director = director;
		this.catalog = catalog;
		this.runnningTime = runnningTime;
		this.licence=false;
	}
	
	public void licenced() {
		this.licence=true;

	}
	
	public boolean lend(Customer customer) {
		if(this.licence) {
			return super.lend(customer);
		}else {
			return false;
		}
		
	}
	

}
