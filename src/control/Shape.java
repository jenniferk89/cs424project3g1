package control;

import java.util.ArrayList;

public class Shape extends GeneralShape {
	private String shape;
	private ArrayList<Sighting> sightings;

	public Shape(String shape) {
		//TODO make a mapping function from shape to generalShape
		super("Pippo");
		this.shape = shape;
	}

	public String getShape() {
		return shape;
	}

	
	
	
	
	
}
