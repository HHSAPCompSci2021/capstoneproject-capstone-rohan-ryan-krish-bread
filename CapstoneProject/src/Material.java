import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

// represents materials. Rocket class will make material objects 
public class Material implements Sidebar {
	private List<Material> materials;
	public Material() {
		materials = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	public List<Material> getMaterials() {
		return materials;
	}
	@Override
	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		// use images

	}

}
