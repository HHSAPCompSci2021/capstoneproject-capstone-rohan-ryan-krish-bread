package main;

import java.awt.Point;
import java.awt.Rectangle;

import buildClasses.Build1;
import processing.core.PImage;
import screenClasses.Screen;
import screenClasses.ScreenSwitcher;

/**
 * Acts as the main menu, that has all the levels and info
 * @author Ryan Wagner, Krish Jhurani, Rohan Gupta
 */
public class LevelSelect extends Screen{

	private DrawingSurface surface;
	private Rectangle button1;
	private Rectangle button2;
	private Rectangle button3;
	private Rectangle button4;
	
	/**
	 * Makes the buttons used to go to the different levels
	 * @param width Width of the screen
	 * @param height Height of the build
	 * @param surface DrawingSurface used to draw the level selection screen
	 * @pre Surface is not null
	 */
	public LevelSelect(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
		button1 = new Rectangle(800/2-350,600/2-125,150,60);
		button2 = new Rectangle(800/2-75,600/2-125,150,60);
		
		button3 = new Rectangle(625, 550, 150, 30);
		button4 = new Rectangle(800/2+200, 600/2-125, 150, 60);
	}
	
	/**
	 * Draws the background for level selection screen, along with the buttons for the levels and instructions
	 * @post The DrawingSurface will have a background, and buttons drawn to it
	 */
	public void draw() {
		
		surface.background(0);
		PImage image1 = surface.loadImage("img/background.jpg");
		surface.image(image1, 0, 10, 800, 600);
		
		surface.rect(button1.x, button1.y, button1.width, button1.height, 10, 10, 10, 10);
		surface.fill(0);
		surface.textSize(30);
		String str1 = "Level 1";
		float w1 = surface.textWidth(str1);
		surface.text(str1, button1.x+button1.width/2-w1/2, button1.y+button1.height/2+10);
		surface.fill(255);
		
		surface.rect(button2.x, button2.y, button2.width, button2.height, 10, 10, 10, 10);
		surface.fill(0);
		String str2 = "Level 2";
		float w2 = surface.textWidth(str2);
		surface.stroke(0);
		surface.text(str2, button2.x+button2.width/2-w2/2, button2.y+button2.height/2+10);
		surface.fill(255);
		
		surface.rect(button4.x, button4.y, button4.width, button4.height, 10, 10, 10, 10);
		surface.fill(0);
		String str4 = "Level 3";
		float w4 = surface.textWidth(str4);
		surface.stroke(0);
		surface.text(str4, button4.x+button4.width/2-w4/2, button4.y+button4.height/2+10);
		surface.fill(255);
		
		surface.rect(button3.x, button3.y, button3.width, button3.height, 10, 10, 10, 10);
		surface.fill(0);
		String str3 = "Instructions";
		float w3 = surface.textWidth(str3);
		surface.stroke(0);
		surface.textSize(13);
		surface.text(str3, button3.x+button3.width/2-w3/2+45, button3.y+button3.height/2+3);
		surface.fill(255);
		
	}
	
	/**
	 * Changes the screen that is being drawn if one of the button is pressed
	 * @post The screen being drawn to the DrawingSurface may be changed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button1.contains(p)) {
			surface.switchScreen(ScreenSwitcher.BUILD_1);
		}	
		if (button2.contains(p)) 
			surface.switchScreen(ScreenSwitcher.BUILD_2);
		if (button3.contains(p)) {
			surface.switchScreen(ScreenSwitcher.INSTRUCTIONS);
		}
		if (button4.contains(p)) 
			surface.switchScreen(ScreenSwitcher.BUILD_3);
	}

}
