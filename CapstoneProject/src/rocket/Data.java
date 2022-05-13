package rocket;

import processing.core.PApplet;

// All data for rocket, to be displayed on both build and launch screens by DataDisplay
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
	
	public Data(Engine e, Material m, Fuel f, double x, double y, double width, double height) {
		this.e = e;
		this.m = m;
		this.f = f;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
	}
	
	public void draw(PApplet p) {
		
		p.noFill();
		p.rect((float)x,(float) y, (float)width, (float)height);
		
		if (e != null && m != null && f != null ) {
			thrust = e.getThrust();
			probability = e.getReliability() * 100;
			weight = e.getWeight() + m.getWeight() + f.getWeight();
		}
		
			p.push();
			p.fill(0);
			p.text("Weight: " + weight + "kg", 620, 70);
			p.text("Thrust: " + thrust + "N", 620, 90);
			p.text("Probability of success: " + probability + "%", 620, 110);
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
