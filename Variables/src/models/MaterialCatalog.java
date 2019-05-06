package models;

import java.util.HashMap;

public class MaterialCatalog {

	private HashMap< Integer, Material> materials;

	public MaterialCatalog() {
		this.materials = new HashMap<Integer,Material>();
	}
	
	public void addMaterial(Material material) {		
		this.materials.put(material.getId(), material);
	}
	
	public Material findMaterial(String title) throws MaterialNotfoundException {
		title = title.trim();
		for(Material material: materials.values()) {
			if(material.getTitle().equalsIgnoreCase(title)) {
				return material;
			}
		}
		throw new MaterialNotfoundException();
	}
	
	public int getNoOfMaterials() {
		return materials.size();
	}

	public HashMap<Integer, Material> getMaterialMap() {
		return materials;
	}

}
