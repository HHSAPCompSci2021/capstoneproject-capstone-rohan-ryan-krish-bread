package rocket;

import processing.core.PApplet;

/**
 * Contains all data for rocket, to be displayed on both build and launch screens by DataDisplay
 * @author Ryan Wagner, Krish Jhurani, Rohan Gupta
 */
public class Data {
	
	private double weight;
	private double thrust;
	private double probability;
	
	private double x,y,width,height;
	
	private Material m;
	private Engine e;
	private Fuel f;
	
	// fields for each metric (fuel, material, etc.) as well as cost, weight etc.
	// field for each statistic
	
	/**
	 * constructs a display of data
	 * @param e engine of rocket
	 * @param m material of rocket
	 * @param f fuel of rocket
	 * @param x x coordinate of display
	 * @param y y coordinate of display
	 * @param width width of display
	 * @param height height of display
	 */
	public Data(Engine e, Material m, Fuel f, double x, double y, double width, double height) {
		this.e = e;
		this.m = m;
		this.f = f;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
	}
	
	/**
	 * sets the weight of the rocket
	 * @param w weight to be set
	 */
	public void setWeight(double w) {
		weight = w;
	}
	
	/**
	 * sets the engine to be used for data
	 * @param e engine to be set
	 */
	public void setEngine(Engine e) {
		this.e = e;
	}
	
	/**
	 * sets the material to be used for data
	 * @param m material to be set
	 */
	public void setMaterial(Material m) {
		this.m = m;
	}
	
	/**
	 * sets the fuel to be used for data
	 * @param f fuel to be set
	 */
	public void setFuel(Fuel f) {
		this.f = f;
	}
	
	/**
	 * sets the thrust to be used for data
	 * @param e thrust to be set
	 */
	public void setThrust(double t) {
		thrust = t;
	}
	
	/**
	 * sets the probability to be used for data
	 * @param p probability to be set
	 */
	public void setProbability(double p) {
		probability = p;
	}
	
	/**
	 * draws the display of data
	 * @param p PApplet on which to draw
	 */
	public void draw(PApplet p) {
		
		p.fill(255);
		p.rect((float)x,(float) y, (float)width, (float)height);
		
		if (e != null && m != null && f != null) {
			thrust = e.getThrust();
			probability = e.getReliability() * 100;
			weight = e.getWeight() + m.getWeight() + f.getWeight();
		}
		
		p.push();
		p.fill(0);
		p.text("Weight: " + weight + "kg", 610, 70);
		p.text("Thrust: " + thrust + "N", 610, 90);
		p.text("Probability of success: " + probability + "%", 610, 110);
		p.pop();
		
		
		
	//	System.out.println("dd");
		
		
	}
	
//	public void hide() {
//		isVisible = false;
//	}
//	
//	public void setVisible(boolean isVisible) {
//		this.isVisible = isVisible;
//	}
	
	

	// calculations
}
