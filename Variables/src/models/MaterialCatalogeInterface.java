package models;

import java.util.TreeMap;

public interface MaterialCatalogeInterface {
	public void addMaterial(Material newMaterial);
	public TreeMap<Integer, Material> getMaterialMap();
	public Material findMaterial(String title) throws MaterialNotfoundException;
	public int getNumberOfMaterials();
}
