package rocket;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

// represents materials. Rocket class will make material objects 
public class Material {
	private static List<Material> materials;
	private PImage image;
	private double x, y, width, height;
	public Material(PImage image, double x, double y) {
		materials = new ArrayList<>();
		this.image = image;
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	public static List<Material> getMaterials() {
		return materials;
	}
	public PImage getImage() {
		return image;
	}
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}

}
