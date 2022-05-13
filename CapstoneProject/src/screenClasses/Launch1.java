package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;

import buildClasses.BuildScreen;
import main.DrawingSurface;
import processing.core.PImage;
import rocket.Meteor;
import rocket.Rocket;

public class Launch1 extends LaunchScreen{

	private DrawingSurface surface;
	private Rectangle button;
	private Rocket rocket;
	private Meteor meteor;
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
		this.meteorY = 0;
		button = new Rectangle(800/2-100,600/2-50,200,100);
		start = false;
		count = 0;
	}
	public void spawnRocket() {
		//	img = surface.loadImage("img/rocket.png");
			rocket = new Rocket(surface.loadImage("img/rocket.png"), this.rocketX, this.rocketY);
	}
	public void spawnMeteors() {
		meteor = new Meteor(surface.loadImage("img/download.png"), this.meteorX, this.meteorY);
	}
//	public void spawnMeteorImages() {
//		meteor = new Meteors(surface.loadImage("img/download.png"), this.meteorX, this.meteorY);
//		while(!touchMeteor(meteor.getY(), meteor.getX(), rocket.getX(), rocket.getY())) {
//			meteor = new Meteors(surface.loadImage("img/download.png"), this.meteorX+(int)(Math.random()*100), this.meteorY + (int)(Math.random()*100));
//		}
//	}
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
//		meteor = new Meteors(surface.loadImage("img/download.png"), this.meteorX+(int)(Math.random()*100), this.meteorY + (int)(Math.random()*100));
		meteor.draw(surface);
//		surface.image(rocket.getImage(), (float)this.x, (float)this.y+6);
		if (start) {
			rocket.setImageY(rocket.getY()-2);
			meteor.setMeteorY(meteor.getY()+3);
			if(touchMeteor(meteor.getY(), meteor.getX(), rocket.getX(), rocket.getY())) {
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
	public void keyPressed() {
		if(count == 1 && !start) {
			return;
		}
		else {
			start = true;
			 if (surface.keyCode== surface.LEFT) {
				 rocket.setImageX(rocket.getX()-25);
			     }
			 if (surface.keyCode==surface.RIGHT) {
				 	rocket.setImageX(rocket.getX()+25);
			   }
		}	
	}
	public boolean touchMeteor(double yMeteor, double xMeteor, double xRocket, double yRocket) {
		   if (xMeteor == xRocket && yMeteor==yRocket) { 
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