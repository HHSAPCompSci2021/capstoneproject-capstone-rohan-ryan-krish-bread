package rocket;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

// Represents engines. Rocket class will make engine objects 
public class Engine  {
	
	//private static List<Engine> engine;
	private PImage image;
	private double x, y, width, height;
	private String name;
	
	public Engine(PImage image, double x, double y, double width, double height, String name) {
		
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	
		// TODO Auto-generated constructor stub
	}
	
//	public static List<Engine> getEngine() {
//		return engine;
//	}
	
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
