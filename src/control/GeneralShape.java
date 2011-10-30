package control;

import java.util.ArrayList;

public abstract class GeneralShape {
	private String generalShape;
	private ArrayList<Sighting> generalSightings;
	//TODO make color

	public GeneralShape(String generalShape) {
		super();
		this.generalShape = generalShape;
		generalSightings = new ArrayList<Sighting>();
	}

	public String getGeneralShape() {
		return generalShape;
	}

	public void setGeneralShape(String generalShape) {
		this.generalShape = generalShape;
	}
	
	

	public ArrayList<Sighting> getGeneralSightings() {
		return generalSightings;
	}

	public void addGeneralSighting(Sighting generalSighting) {
		this.generalSightings.add(generalSighting);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((generalShape == null) ? 0 : generalShape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneralShape other = (GeneralShape) obj;
		if (generalShape == null) {
			if (other.generalShape != null)
				return false;
		} else if (!generalShape.equals(other.generalShape))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "generalShape= " + generalShape;
	}
	
	
	
	
}
