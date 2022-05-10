package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;

import buildClasses.BuildScreen;
import main.DrawingSurface;
import rocket.Rocket;

public class Launch1 extends LaunchScreen{

	private DrawingSurface surface;
	private Rectangle button;
	private Rocket rocket;
	private double x, y;
	public Launch1(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		this.x = 300;
		
		this.y = 200;
		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	public void spawnRocket() {
		//	img = surface.loadImage("img/rocket.png");
			rocket = new Rocket(surface.loadImage("img/rocket.png"), this.x, this.y);
	}
	public void translateUp() {
		y+=2;
//		do {
//			translateUp();
//		} while() // Collisions with meteors
	}

	public void setup() {
		spawnRocket();
	}
	public void draw() {
		
		surface.background(100,100,255);
		
		surface.fill(0);
		surface.text("Launch 1", 10, 20);
		surface.fill(255);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Back To Level Select";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		surface.fill(255);
		rocket.draw(surface);
		surface.image(rocket.getImage(), (float)this.x, (float)this.y+6);
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) 
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);

		
	}
	public void keyPressed() {
		if(surface.key == 's') {
			moveBy(0, 40);
		}
//		if (keyCode == DOWN) {
//			movingRectangle.moveBy(0, 4);
//		}
}
	public void moveBy(double amountX, double amountY) {
		double x1 = rocket.getX();
		double y1 = rocket.getY();
		this.rocket.setImageX(x1+=amountX);
		this.rocket.setImageY(y1+=amountY);
	}

}