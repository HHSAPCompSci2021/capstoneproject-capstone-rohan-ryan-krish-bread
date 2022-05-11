package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;

import buildClasses.BuildScreen;
import main.DrawingSurface;
import processing.core.PImage;
import rocket.Meteors;
import rocket.Rocket;

public class Launch1 extends LaunchScreen{

	private DrawingSurface surface;
	private Rectangle button;
	private Rocket rocket;
	private Meteors meteor;
	private double rocketX, rocketY;
	private double meteorX, meteorY;
	private boolean start;
	private int count;
	public Launch1(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		this.rocketX= 300;
		this.rocketY = 200;
		this.meteorX = 300;
		this.meteorY = 100;
		button = new Rectangle(800/2-100,600/2-50,200,100);
		start = false;
		count = 0;
	}
	public void spawnRocket() {
		//	img = surface.loadImage("img/rocket.png");
			rocket = new Rocket(surface.loadImage("img/rocket.png"), this.rocketX, this.rocketY);
	}
	public void spawnMeteors() {
		meteor = new Meteors(surface.loadImage("img/download.png"), this.meteorX, this.meteorY);
	}

	public void setup() {
		spawnRocket();
		spawnMeteors();
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
		meteor.draw(surface);
		
//		surface.image(rocket.getImage(), (float)this.x, (float)this.y+6);
		if (start) {
			rocket.setImageY(rocket.getY()-5);
			meteor.setMeteorY(meteor.getY()+5);
			if(touchMeteor(meteor.getY(), rocket.getY())) {
				start = false;
				count++;
				surface.loadImage("img/giphy.gif");
				surface.image(surface.loadImage("img/giphy.gif"),(float) rocket.getX(),(float) rocket.getY());
			}
		}
		
	
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) 
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);

		
	}
//	public void set() {
//		rocket.setImageY(rocket.getY()-20);
////		set();
//	}
	public void keyPressed() {
		if(count == 1 && !start) {
			return;
		}
		else {
			start = true;
			 if (surface.keyCode== surface.LEFT) {
			       rocketX= rocketX-20;
			     }
			 if (surface.keyCode==surface.RIGHT) {
			      rocketX = rocketX+20;
			    }
		}

//			if(!start) {
//				return;
//			}
			    
			
		}
	public boolean touchMeteor(double yMeteor, double yRocket) {
		   if (yMeteor==yRocket) { 
			   return true;
		 }
		return false;
	}
	
	public void moveBy(double amountX, double amountY) {
		double x1 = rocket.getX();
		double y1 = rocket.getY();
		this.rocket.setImageX(x1+=amountX);
		this.rocket.setImageY(y1+=amountY);
	}
}