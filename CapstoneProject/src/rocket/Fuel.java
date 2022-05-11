package rocket;
// Represents fuels. Rocket class will make fuel objects
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;
public class Fuel {
	private static List<Fuel> fuel;
	private PImage image;
	private double x, y, width, height;
	public Fuel(PImage image, double x, double y) {
		fuel = new ArrayList<>();
		this.image = image;
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	public static List<Fuel> getFuel() {
		return fuel;
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
