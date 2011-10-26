package control;

import java.util.ArrayList;

public class Shape extends GeneralShape {
	private String shape;
	private ArrayList<Sighting> sightings;

	public Shape(String shape) {
		//TODO make a mapping function from shape to generalShape
		super("Goofy");
		this.shape = shape;
	}

	public String getShape() {
		return shape;
	}

	public ArrayList<Sighting> getSightings() {
		return sightings;
	}

	public void addSighting(Sighting sighting) {
		this.sightings.add(sighting);
		super.addGeneralSighting(sighting);
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	
	
	
	
	
}
