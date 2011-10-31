package control;

import java.util.ArrayList;

import GUI.Utils;

public abstract class GeneralShape {
	private String generalShape;
	private ArrayList<Sighting> generalSightings;
	private int color;



	public GeneralShape(String generalShape) {
		super();
		this.generalShape = generalShape;
		generalSightings = new ArrayList<Sighting>();
		
		//manage color based by shape
		if(generalShape.equals("light"))
			this.color = Utils.lightColor;
		else if(generalShape.equals("round"))
			this.color = Utils.roundColor;
		else if(generalShape.equals("arrow"))
			this.color = Utils.arrowColor;
		else if(generalShape.equals("polygon"))
			this.color = Utils.polygonColor;
		else if(generalShape.equals("formation"))
			this.color = Utils.formationColor;
		else if(generalShape.equals("changing"))
			this.color = Utils.changingColor;
		else
			this.color = Utils.otherColor;

		generalSightings = new ArrayList<Sighting>();
	}

	public String getGeneralShape() {
		return generalShape;
	}

	public void setGeneralShape(String generalShape) {
		this.generalShape = generalShape;
		//manage color based by shape
		if(generalShape.equals("light"))
			this.color = Utils.lightColor;
		else if(generalShape.equals("round"))
			this.color = Utils.roundColor;
		else if(generalShape.equals("arrow"))
			this.color = Utils.arrowColor;
		else if(generalShape.equals("polygon"))
			this.color = Utils.polygonColor;
		else if(generalShape.equals("formation"))
			this.color = Utils.formationColor;
		else if(generalShape.equals("changing"))
			this.color = Utils.changingColor;
		else
			this.color = Utils.otherColor;
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

	




	public void setGeneralSightings(ArrayList<Sighting> generalSightings) {
		this.generalSightings = generalSightings;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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
