package models;

public abstract class Material {
	private int id;
	private String title;
	private String branch;
	private Customer borrower;
	
	public Material(int id, String title, String branch) {
		this.id = id;
		this.title = title;
		this.branch = branch;
	}

	public String getTitle() {
		return title;
	}

	public String getBranch() {
		return branch;
	}
	
	public int getId() {
		return id;
	}
	public void relocate(String newBranch) {
		this.branch = newBranch;
	}
	public boolean lend(Customer customer) {
		if(borrower==null) {
			this.borrower=customer;
			return true;
		}else {
			return false;
		}
		
	}

	

}
