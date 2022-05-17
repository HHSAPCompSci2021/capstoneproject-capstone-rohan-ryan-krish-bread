package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import buildClasses.BuildScreen;
import main.DrawingSurface;
import processing.core.PImage;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import rocket.Meteor;
import rocket.Rocket;

public class Launch1 extends LaunchScreen{

	private DrawingSurface surface;
	private Rectangle button;
	private Shape s;
	private Rocket rocket;
	private Meteor meteor;
	private double rocketX, rocketY;
	private double meteorX, meteorY;
	private boolean start;
	private int count;
	private Rectangle win;
	private int draws; // number of times draw() has been called
	
	public Launch1(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		this.rocketX= 300;
		this.rocketY = 200;
		this.meteorX = 300;
		this.meteorY = 0;
		button = new Rectangle(650,-40,125, 150);
		start = false;
		count = 0;
		win = new Rectangle(0, 0 , 800, 600);
		draws = 0;
	}
	
	public void spawnRocket() {
		
		rocket = new Rocket(this.rocketX, this.rocketY, 50,250);
	//	rocket.setEngine(new Engine(surface.loadImage("img/rocket.png"), 20,20,20,20, "pressureFed", 500, 0.95, 100000));
	}
	public void spawnMeteors() {
		meteor = new Meteor(surface.loadImage("img/download.png"), this.meteorX, this.meteorY);
	}
	public void setup() {
		spawnRocket();
		spawnMeteors();
	}
	
	public void draw() {
		
		draws++;
		
////		surface.background(100,100,255);
//		surface.fill(0);
//		surface.text("Launch 1", 10, 20);
//		surface.fill(255);
		
		
		
//		meteor.draw(surface);
		PImage image1 = surface.loadImage("img/night.png");
		surface.image(image1, -50, 0);
		surface.text("Launch 1", 10, 20);
		surface.fill(0);
		rocket.draw(surface);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(255);
		String str = "Back To Level Select";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		surface.fill(255);
		
		if(rocket.getX() > win.getWidth()-20){
			rocket.setImageX(win.getWidth()-30);
		}
		else if(rocket.getX() < 0) {
			rocket.setImageX(0);
		}
		else if(rocket.getY() == win.getHeight()) {
			rocket.setImageY(0);
		}
		else if(rocket.getY() < 0) {
			rocket.setImageY(win.getHeight());
		}
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
		
		if (surface.keyPressed) {
			 if (surface.keyCode == surface.LEFT) {
				 rocket.setImageX(rocket.getX()-5);
			     }
			 if (surface.keyCode == surface.RIGHT) {
				 	rocket.setImageX(rocket.getX()+5);
			   }
		}
		
//		if (draws % 60 == 0) {
//			
//			if (Math.random() > rocket.getEngine().getReliability()) {
//				rocket.setState(true);
//			}
//		}
		
	
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			rocket.setState(false);
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);
		}
			

		
	}
	
	public void keyPressed() {
		if(count == 1 && !start) {
			return;
		}
		else {
			start = true;
//			 if (surface.keyCode== surface.LEFT) {
//				 rocket.setImageX(rocket.getX()-25);
//			     }
//			 if (surface.keyCode==surface.RIGHT) {
//				 	rocket.setImageX(rocket.getX()+25);
//			   }
		}
//		if (surface.key == 's') { 
//	  		rocket.moveInLimits(thisLevel, 0, -5);
//		}
//	  	if (surface.key == 'a') 
//	  		rocket.moveInLimits(thisLevel, 0, 5);
//	  	if (surface.key == 'd') 
//	  		rocket.moveInLimits(thisLevel, -5, 0);
//	  	if (surface.key == 'w') { 
//	  		rocket.moveInLimits(thisLevel, 5, 0);
//	  	}
//	  	
//	  	slideWorldToImage(mario);
	}
//	public boolean resetPosition(double windowX, double windowY, double currentPosX, double currentPosY) {
//		if(currentPosX == windowX || currentPosY == windowY || currentPosX < 0 || currentPosY < 0) {
//			return true;
//		}
//		return false;
//	}
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