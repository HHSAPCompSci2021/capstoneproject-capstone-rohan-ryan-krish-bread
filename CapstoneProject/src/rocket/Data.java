package rocket;

// All data for rocket, to be displayed on both build and launch screens by DataDisplay
public class Data {
	
	private double weight;
	private double thrust;
	private double probability;
	private Material m;
	private Engine e;
	private Fuel f;
	
	// fields for each metric (fuel, material, etc.) as well as cost, weight etc.
	// field for each statistic
	
	public Data(Engine e, Material m, Fuel f) {
		this.e = e;
		this.m = m;
		this.f = f;
		thrust = e.getThrust();
		probability = e.getReliability();
		
	//	weight = e.getWeight() + m.getWeight(); + f.getWeight();
	}
	

	// calculations
}
