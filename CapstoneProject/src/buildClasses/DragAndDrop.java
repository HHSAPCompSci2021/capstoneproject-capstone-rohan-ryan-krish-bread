//package buildClasses;
//
//import processing.core.PImage;
//import screenClasses.Screen;
//
//public class DragAndDrop extends Screen {
//	private PImage img;
//	public DragAndDrop(PImage img, int width, int height) {
//		super(width, height);
//		this.img = img;
//		// TODO Auto-generated constructor stub
//	}
//	double bx;
//	double by;
//	int boxSize = 75;
//	boolean overBox = false;
//	boolean locked = false;
//	double xOffset = 0.0; 
//	double yOffset = 0.0; 
//
//	public void setup() {
//	  size(640, 360);
//	  bx = width/2.0;
//	  by = height/2.0;
//	  rectMode(RADIUS);  
//	}
//
//	public void draw() { 
//	  background(0);
//	  
//	  // Test if the cursor is over the box 
//	  if (mouseX > bx-boxSize && mouseX < bx+boxSize && 
//	      mouseY > by-boxSize && mouseY < by+boxSize) {
//	    overBox = true;  
//	    if(!locked) { 
//	      stroke(255); 
//	      fill(153);
//	    } 
//	  } else {
//	    stroke(153);
//	    fill(153);
//	    overBox = false;
//	  }
//	  
//	  // Draw the box
//	  rect((float)bx, (float)by, boxSize, boxSize);
//	}
//
//	public void mousePressed() {
//	  if(overBox) { 
//	    locked = true; 
//	    fill(255, 255, 255);
//	  } else {
//	    locked = false;
//	  }
//	  xOffset = mouseX-bx; 
//	  yOffset = mouseY-by; 
//
//	}
//
//	public void mouseDragged() {
//	  if(locked) {
//	    bx = mouseX-xOffset; 
//	    by = mouseY-yOffset; 
//	  }
//	}
//
//	public void mouseReleased() {
//	  locked = false;
//	}
//
//}
