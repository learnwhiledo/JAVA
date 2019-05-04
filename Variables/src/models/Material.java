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
		if (borrower == null) {
			this.borrower = customer;
			return true;
		} else {
			return false;
		}

	}

	// Must be implement in child class
	public abstract int getLoanPeriod();

	// this is an overridden method from java.lan.obj class
	@Override
	public String toString() {
		return "Material [getTitle()=" + getTitle() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
