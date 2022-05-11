package rocket;

import buildClasses.BuildScreen;
import screenClasses.LaunchScreen;

// represents the data display for both build and launch screens
// class will have a data object, and data will extend DataDisplay
public class DataDisplay {

//	 fields for all data (weight, cost, speed, etc)
	
	 private Data data;
	 private double x,y;
	 private double weight, cost, speed;
	
	public DataDisplay(BuildScreen build, double x, double y) { // make data object, take in x and y cords initialize field to field of Data (dot notation)
		this.x = x;
		this.y = y;
	}
	
	public DataDisplay(LaunchScreen launch, double x, double y) { // two constructors, one for build, other for launch
		
	}

}
