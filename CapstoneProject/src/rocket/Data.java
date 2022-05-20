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
	 * Makes the engines, materials, and fuels used
	 * @param e Engine used to calculate data
	 * @param m Material used to calculate data
	 * @param f Fuel used to calculate data
	 * @param x X-value of the data box
	 * @param y Y-value of the data box
	 * @param width
	 * @param height
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
	 * Sets the weight of the Rocket
	 * @param w New weight of the Rocket
	 */
	public void setWeight(double w) {
		weight = w;
	}
	
	/**
	 * Sets the Engine of the Rocket
	 * @param w New engine of the Rocket
	 */
	public void setEngine(Engine e) {
		this.e = e;
	}
	
	/**
	 * Sets the Material of the Rocket
	 * @param w New material of the Rocket
	 */
	public void setMaterial(Material m) {
		this.m = m;
	}
	
	/**
	 * Sets the Fuel of the Rocket
	 * @param w New fuel of the Rocket
	 */
	public void setFuel(Fuel f) {
		this.f = f;
	}
	
	/**
	 * Sets the thrust of the Rocket
	 * @param w New thrust of the Rocket
	 */
	public void setThrust(double t) {
		thrust = t;
	}
	
	/**
	 * Sets the probability the Rocket will successfully fly
	 * @param w New probability of flight success
	 */
	public void setProbability(double p) {
		probability = p;
}
	/**
	 * Draws the data box and displays the data in it
	 * @param p DrawingSurface that the data will get drawn on
	 * @post DrawingSurface being used will have a rectangle and text drawn to it
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
