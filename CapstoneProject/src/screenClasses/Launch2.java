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

public class Launch2 extends LaunchScreen{

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
	private PImage img2;
	private int offSetY;
	private int imgX, imgY;
	private double scaleX, scaleY, actualScaleX, actualScaleY;
	private PImage img3, img4;
	private boolean isDone;
	private int checkPoints;
	/**
	 * The launch test for the rocket for level 2
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
		win = new Rectangle(0, 0 , 800, 600);
		draws = 0;
		offSetY = 0;
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
		this.rocket = surface.getBuild1().rocket;
		
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
	/**
	 * Spawns another image of space (with stars)
	 */
	public void spawnSpace() {
		img4 = surface.loadImage("img/ColdSpace.png");
	}
	/**
	 * Spawns the default images like background and built rocket once program begins
	 */
	public void setup() {
		spawnRocket();
		spawnNightSky();
		spawnSpace();
		spawnNight();
	}
	/**
	 * Draws new instances of images, and text
	 */
	public void draw() {
		if(imgY <= 1033) {
			draws++;
			surface.image(img2, (float) this.imgX, (float) this.imgY);
			this.imgY++;
			surface.image(img4, (float) this.imgX, (float)this.imgY - img4.height);
			surface.image(img3, (float) this.imgX, (float) this.imgY-img3.height-img4.height);
			surface.text("Level 2 Launch", 10, 20);
			surface.text("Checkpoints crossed" + parseString(countCheckPoints()), 10, 40);
			surface.fill(0);
			rocket.draw(surface);
			String str = "Back To Level Select";
			float w = surface.textWidth(str);
			surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
			surface.fill(0);
		
		if(rocket.getX() > win.getWidth()-20){
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
				surface.text("Congratulations! You have completed the level."
						+ '\n' + "Click anywhere on the moon for the rocket to land.", 400, 400);
				isDone = true;
			}
			
//			if(surface.mousePressed) {
//				change();
//			}
//			change();
			
//				rocket.setImageXAndY(surface.mouseX, surface.mouseY);
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
		
//		if (draws % 60 == 0) {
//			
//			if (Math.random() > rocket.getEngine().getReliability()) {
//				rocket.setState(true);
//			}
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
//		if(actualScaleX != surface.mouseX - rocket.getX()) {
//			actualScaleX++;
//			rocket.setImageX(rocket.getX() + actualScaleX);
//		}
//		if(actualScaleY != surface.mouseY - rocket.getY()) {
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
	 * Executes commands based on the click of the mouse
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			rocket.setState(false);
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);
		}
			

		
	}
	/**
	 * Executes commands based on the click of key(s)
	 */
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
	/**
	 * Counts the checkpoints that the rocket has crossed for each level
	 * @return the number of checkpoints
	 */
	public int countCheckPoints() {
		if(imgY == 150 || imgY == 806) {
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