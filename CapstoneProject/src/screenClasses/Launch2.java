package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;

import buildClasses.BuildScreen;
import main.DrawingSurface;
import processing.core.PImage;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import rocket.Meteor;
import rocket.Rocket;

public class Launch2 extends LaunchScreen{

	private DrawingSurface surface;
	private Rectangle button, win;
	private Ellipse2D.Float land;
	private Rocket rocket;
	private Meteor meteor;
	private double rocketX, rocketY, meteorX, meteorY, actualScaleX, actualScaleY;
	private boolean start, isDone;
	private int draws, imgX, imgY, checkPoints, count, count2;
	private PImage img2, img3, sky1, explosion;
	/**
	 * The launch test for the rocket for level 1
	 * @param surface the drawing surface on which to draw
	 */
	public Launch2(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		this.rocketX= 300;
		this.rocketY = 200;
		this.meteorX = 300;
		this.meteorY = 0;
		button = new Rectangle(650,-40,125, 150);
		start = false;
		count = 0;
		count2 = 0;
		win = new Rectangle(0, 0 , 800, 600);
		draws = 0;
		this.imgX = -50;
		this.imgY = 0;
		actualScaleX = 0;
		actualScaleY = 0;
		isDone = false;
		checkPoints = 0;
	}
	/**
	 * Loads the image of the built rocket
	 */
	public void spawnRocket() {
		this.rocket = surface.getBuild2().rocket;
		
	//rocket = new Rocket(this.rocketX, this.rocketY, 50,250);
	//	rocket.setEngine(new Engine(surface.loadImage("img/rocket.png"), 20,20,20,20, "pressureFed", 500, 0.95, 100000));
	}
	/**
	 * Loads image of the Earth
	 */
	public void spawnNightSky() {
		img2 = surface.loadImage("img/night.png");
	}
	/**
	 * Loads image of space (with stars)
	 */
	public void spawnNight() {
		img3 = surface.loadImage("img/NightStar.png");
	}
	public void spawnSky() {
		sky1 = surface.loadImage("img/ColdSpace.png");
	}
	public void spawnExplosion() {
		explosion = surface.loadImage("img/Explosion.png");
	}
	/**
	 * Spawns the default images like background and built rocket once program begins
	 */
	public void setup() {
		spawnRocket();
		spawnNightSky();
		spawnSky();
		spawnNight();
	}
	/**
	 * Draws new instances of rocket, backgrounds, and text
	 */
	public void draw() { // move the screen according to speed of rocket
		System.out.println(imgY);
		if(Math.pow(imgX + 450 - rocket.getX(), 2) + Math.pow(imgY - img3.height -(sky1.height*2) - rocket.getY(), 2) > 140000 && !isDone) { 
			surface.background(0);
			
			
			if (rocket.getMoving()) {
				this.imgX += rocket.getVX() * Math.cos(Math.toRadians(rocket.getDirection() + 90));
				this.imgY += rocket.getVY() * Math.sin(Math.toRadians(rocket.getDirection() + 90));
			}
			
			draws++;
			
			surface.image(img2, (float) this.imgX, (float) this.imgY);
			surface.image(sky1, imgX, this.imgY-sky1.height);
			surface.image(sky1, imgX, this.imgY-(sky1.height*2));
			surface.image(img3, (float) this.imgX, (float) this.imgY-(sky1.height*2)-img3.height);
			land = new Float((float) this.imgX+450, (float) this.imgY-img3.height-52, 880, 880);
			
			
			
			if(imgX < -400 || imgX > 400) {
				spawnExplosion();
				surface.image(explosion, (float) rocket.getX()-100, (float) rocket.getY()-100);
				surface.text("Level Over: Rocket blew up.", 400, 400);
				rocket.stopTilt();
				rocket.moveForward(false);
				return;
			}
			
			surface.text("Level 2 Launch", 10, 20);
			
			surface.fill(0);
			rocket.setHeight(150);
			
			rocket.draw(surface);
			rocket.act();
			
			if(imgY == 150 || imgY == 806 || imgY == 1512) {
				checkPoints++;
			}
			surface.text("Checkpoints crossed " + checkPoints, 10, 40);
			String str = "Back To Level Select";
			float w = surface.textWidth(str);
			surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
			surface.fill(0);
			
			if(rocket.getX() > win.getWidth()-20) {
				rocket.setImageX(win.getWidth()-30);
			}
			else if(rocket.getX() < 0) {
				rocket.setImageX(0);
			}
		
		if (surface.keyPressed) {
			 if (surface.keyCode == surface.LEFT) {
				 rocket.setImageX(rocket.getX()-5);
			     }
			 if (surface.keyCode == surface.RIGHT) {
				 	rocket.setImageX(rocket.getX()+5);
			   }
		}
	}
		
	else {
		
		if(!isDone) {
			surface.text("Congratulations! You have completed the level.", 400, 400);
			isDone = true;
		}
	}
	}
			
			
			
		
			
//			rocket.setImageXAndY(rocket.getX() + (surface.mouseX-rocket.getX()), rocket.getY() + (surface.mouseY-rocket.getY()));
			
		
	
//		if (this.imgY > 270) {
//			if(surface.mouseX == scaleX && surface.mouseY == scaleY) {
//				return;
//			}
//			actualScaleX++;
//			actualScaleY--;
//			change();
//			rocket.setImageY(scaleY);
//		}
		

		
		
//		else if(this.imgY > 400) {
//			isDone = false;
//			return;
////			if(surface.mouseX == scaleX && surface.mouseY == scaleY) {
////				return;
////			}
////			actualScaleX++;
////			actualScaleY--;
////			change();
////			rocket.setImageY(scaleY);
////		}
//		}
//	public void change() {
//		while (actualScaleX != surface.mouseX - rocket.getX()) {
//			actualScaleX++;
//			rocket.setImageX(rocket.getX() + actualScaleX);
//		}
//		while (actualScaleY != surface.mouseY - rocket.getY()) {
//			actualScaleY++;
//			rocket.setImageY(rocket.getY() + actualScaleY);
//		}
//		
//	}
//	public void land() {
//		if(surface.mouseX == scaleX && surface.mouseY == scaleY) {
//			return;
//		}
//		actualScaleX++;
//		actualScaleY++;
//		change();
//		
//		rocket.setImageX(scaleX);
//		rocket.setImageY(scaleY);
//	}
	/**
	 * Detects where the mouse was pressed, and activates the button if it was pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			rocket.setState(false);
			rocket.setHeight(250);
			rocket.setDirection(0);
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);
		}
//		if (land.contains(p)) {
//			
//		}
			
	}
	
	public void keyPressed() {
		if (surface.keyCode ==  KeyEvent.VK_A) {
		rocket.tilt(-0.25);
		if(imgX < -400 || imgX > 400) {
			rocket.stopTilt();
		}
		
	}
	
	if (surface.keyCode ==  KeyEvent.VK_D) {
		rocket.tilt(0.25);
		if(imgX < -400 || imgX > 400) {
			rocket.stopTilt();
		}
	}
	
	if (surface.keyCode ==  KeyEvent.VK_W) {
		rocket.moveForward(true);
		rocket.accelerate(0.75, 0.75);
		if(imgX < -400 || imgX > 400) {
			rocket.moveForward(false);
		}
	}
	
	if (surface.keyCode ==  KeyEvent.VK_S) {
		
		if (!(rocket.getVX() <= 0) && !(rocket.getVY() <= 0)) {
			rocket.accelerate(-0.75, -0.75);
		}
		
//		else {
//			rocket.moveForward(false);
//		}
		
	}


		
	}
	/**
	 * Counts the checkpoints that the rocket has crossed for each level
	 * @return the number of checkpoints
	 */
	public int countCheckPoints() {
		if(imgY == 150 || imgY == 806 || imgY == 1512) {
			checkPoints++;
		}
		return checkPoints;
	}
	/**
	 * Turns an integer into a string
	 * @param string the integer that will be converted to a string
	 * @return an integer in the format of a string
	 */
	public String parseString(int string) {
		return " " + string + " ";
	}
}