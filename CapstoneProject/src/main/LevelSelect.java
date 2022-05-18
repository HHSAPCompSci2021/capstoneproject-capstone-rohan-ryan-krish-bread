package main;

import java.awt.Point;
import java.awt.Rectangle;

import buildClasses.Build1;
import processing.core.PImage;
import screenClasses.Screen;
import screenClasses.ScreenSwitcher;

public class LevelSelect extends Screen{

	private DrawingSurface surface;
	private Rectangle button1;
	private Rectangle button2;
	private Rectangle button3;
	
	public LevelSelect(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
		button1 = new Rectangle(800/2-250,600/2-50,200,100);
		button2 = new Rectangle(800/2+50,600/2-50,200,100);
		
		button3 = new Rectangle(625, 550, 150, 30);
	}
	
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
		
		surface.rect(button3.x, button3.y, button3.width, button3.height, 10, 10, 10, 10);
		surface.fill(0);
		String str3 = "Instructions";
		float w3 = surface.textWidth(str3);
		surface.stroke(0);
		surface.textSize(13);
		surface.text(str3, button3.x+button3.width/2-w3/2+45, button3.y+button3.height/2+3);
		surface.fill(255);
		
	}
	
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
	}

}
