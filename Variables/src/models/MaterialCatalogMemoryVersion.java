package models;

import java.util.TreeMap;

public class MaterialCatalogMemoryVersion implements MaterialCatalogeInterface{

	private TreeMap< Integer, Material> materials;

	public MaterialCatalogMemoryVersion() {
		this.materials = new TreeMap<Integer,Material>();
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
	
	public int getNumberOfMaterials() {
		return materials.size();
	}

	public TreeMap<Integer, Material> getMaterialMap() {
		return materials;
	}

}
