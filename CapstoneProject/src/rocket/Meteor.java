package rocket;

import processing.core.PApplet;
import processing.core.PImage;

public class Meteor {
	private PImage img;
	private double x, y;
	public Meteor(PImage img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public PImage img() {
		return img;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setMeteorY(double yVal) {
		this.y = yVal;
	}
	public void change() {
		this.y++;
	}
	public void draw(PApplet drawer) {
		
		if (img != null)
			drawer.image(img,(float)x,(float)y,(float)50,(float)50);
		else {
			drawer.fill(100);
			drawer.rect((float)x,(float)y,(float)50,(float)50);
		}
		
		// if material not null, then draw it
		
	}
}
