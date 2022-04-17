import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Build2 extends BuildScreen {

	private DrawingSurface surface;
	private Rectangle button;
	
	public Build2(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		
		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	public void draw() {
		
		surface.background(0,255,0);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String str = "Click me!";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
	
		
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) 
			surface.switchScreen(ScreenSwitcher.BUILD_1);
	}

}
