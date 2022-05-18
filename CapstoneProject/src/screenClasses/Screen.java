package screenClasses;
import javax.swing.JFrame;

import rocket.Rocket;

public abstract class Screen {

	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
//	public Rocket rocket;
	
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
		//rocket = new Rocket(300,200,50,250);
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		
	}
	
	public void mousePressed() {
		
	}
	
	public void mouseMoved() {
		
	}
	
	public void mouseDragged() {
		
	}
	
	public void mouseReleased() {
		
	}
	public void keyPressed() {
		
	}
	
	
}
