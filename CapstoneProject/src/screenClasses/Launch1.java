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
		button = new Rectangle(800/2-100,600/2-50,200,100);
		start = false;
		count = 0;
		win = new Rectangle(0, 0 , 800, 600);
		draws = 0;
	}
	
	public void spawnRocket() {
		
		PImage img = surface.loadImage("img/rocket.png"); // change later; just a temp variable for testing 
		Engine pressureFed = new Engine(img, 20,20,20,20, "pressureFed", 500, 0.95, 100000);
		Fuel RP1 = new Fuel(img, 20,20,20,20, "RP-1", 1000);
		Material steel = new Material(surface.loadImage("img/Steel-PNG-File.png"), 300, 170, 20, 20, "Steel", 1000);
		
		
		//	img = surface.loadImage("img/rocket.png");
		rocket = new Rocket(this.rocketX, this.rocketY, 50,50, pressureFed, steel, RP1);
	//	rocket.setEngine(new Engine(surface.loadImage("img/rocket.png"), 20,20,20,20, "pressureFed", 500, 0.95, 100000));
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
		
		draws++;
		
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
		if(rocket.getX() > win.getWidth()){
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
			 if (surface.keyCode== surface.LEFT) {
				 rocket.setImageX(rocket.getX()-25);
			     }
			 if (surface.keyCode==surface.RIGHT) {
				 	rocket.setImageX(rocket.getX()+25);
			   }
		}	
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
//	public void bounce(Rectangle window) {
//		if(rocket.getImage().X <0) {
//			rocket.setImageX(0); // The bounds of the window
//		}
//		if(rocket.getImage().Y < 0) {
//			rocket.setImageY(0);
//		}
//		if(rocket.getImage().X >= window.getWidth()-10) {
//			rocket.setImageX(window.getWidth()-10);
//		}
//		if(rocket.getImage().Y >= window.getHeight()-10) {
//			rocket.setImageY(window.getHeight()-10);
//			
//		}
//	}
	public void moveBy(double amountX, double amountY) {
		double x1 = rocket.getX();
		double y1 = rocket.getY();
		this.rocket.setImageX(x1+=amountX);
		this.rocket.setImageY(y1+=amountY);
	}
}