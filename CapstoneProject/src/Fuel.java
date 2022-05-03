// Represents fuels. Rocket class will make fuel objects
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
public class Fuel implements Sidebar {
	private List<Fuel> fuel;
	public Fuel() {
		fuel = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	public List<Fuel> getFuel() {
		return fuel;
	}
	@Override
	public void draw(PApplet p) {
		// use images
		
	}
	

}
