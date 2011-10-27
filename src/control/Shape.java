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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (shape == null) {
			if (other.shape != null)
				return false;
		} else if (!shape.equals(other.shape))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "shape = " + shape + " " +super.toString();
	}

	
	
	
	
	
}
