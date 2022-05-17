package screenClasses;

import java.awt.*;
import javax.swing.*;

import processing.core.PImage;

import java.awt.image.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class MovingImage extends Rectangle2D.Double {

	// FIELDS
	private PImage img;
	private boolean isVisible;
	
	private boolean textured;
	
	

	// CONSTRUCTOR
	/*
	 All coordinates are in assumed coordinates and represent data for the
	 image, not the window.
	 */
	public MovingImage(PImage img, int x, int y, int w, int h, boolean textured) {
		super(x,y,w,h);
		
		
		isVisible = true;

		this.textured = textured;
	}



	// NON-STATIC METHODS
	/*
	 * If the MovingImage should be visible, draws the MovingImage to the
	 * screen in the way specified by the resizable field.
	 */
//	public void draw(Graphics2D g, ImageObserver io) {
//		if (isVisible) {
//			if (textured) {
//				Rectangle2D tr = new Rectangle2D.Double((int)0, (int)0, (int)img.getWidth(), (int)img.getHeight());
//			    TexturePaint tp = new TexturePaint(img, tr);
//		    	g.setPaint(tp);
//		    	g.fill(this);
//			} else
//				g.drawImage(img, (int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()), io);
//		}
//	}
	
	public void moveInLimits(Rectangle2D.Double limits, double x, double y) {
		double newX = this.x + x;
		double newY = this.y + y;
		if (limits.contains(new Rectangle2D.Double(newX,newY,width,height))) {
			this.x = newX;
			this.y = newY;
		}
	}
	
	public Point2D.Double getCenter() {
		return new Point2D.Double(getX()+getWidth()/2,getY()+getHeight()/2);
	}

	/*
	 * Switches the MovingImage visibility to the opposite of what it is
	 * currently.
	 */
	public void swapVisibility() {
		isVisible = !isVisible;
	}

	/*
	 * Returns the visibility of the MovingImage.
	 */
	public boolean isVisible() {
		return isVisible;
	}
	




}