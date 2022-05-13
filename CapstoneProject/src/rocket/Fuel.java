package rocket;
// Represents fuels. Rocket class will make fuel objects
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;
public class Fuel {
	
	private PImage image;
	private double x, y, width, height;
	private String name;
	private double weight;
	
	public Fuel(PImage image, double x, double y, double width, double height, String name) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	}
	
	public PImage getImage() {
		return image;
	}
	
	public String getName() {
		return name;
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
