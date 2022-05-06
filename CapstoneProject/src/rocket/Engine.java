package rocket;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

// Represents engines. Rocket class will make engine objects 
public class Engine implements Sidebar {
	private List<Engine> engine;
	private PImage image;
	private double x, y, width, height;
	public Engine(PImage image) {
		this.image = image;
		// TODO Auto-generated constructor stub
	}
	public List<Engine> getEngine() {
		return engine;
	}
	public PImage getImage() {
		return image;
	}
	@Override
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}

}
