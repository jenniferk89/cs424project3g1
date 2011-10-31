package control;

import java.util.ArrayList;

public class Shape extends GeneralShape {
	private String shape;
	private ArrayList<Sighting> sightings;

	public Shape(String shape) {
		super("other");
		this.shape = shape;
		String general;
		if(shape.equalsIgnoreCase("flash") || shape.equalsIgnoreCase("light") || shape.equalsIgnoreCase("flare") || shape.equalsIgnoreCase("fireball"))
			general  = new String("light");
		else if(shape.equalsIgnoreCase("round") || shape.equalsIgnoreCase("disk") || shape.equalsIgnoreCase("sphere") || shape.equalsIgnoreCase("circle")||
				shape.equalsIgnoreCase("egg") || shape.equalsIgnoreCase("oval") || shape.equalsIgnoreCase("teardrop") || shape.equalsIgnoreCase("dome")||
				shape.equalsIgnoreCase("crescent") || shape.equalsIgnoreCase("cone") || shape.equalsIgnoreCase("cylinder"))
			general = new String("round");
		else if(shape.equalsIgnoreCase("triangle") || shape.equalsIgnoreCase("delta") || shape.equalsIgnoreCase("cigar") || shape.equalsIgnoreCase("chevron"))
			general = new String("arrow");
		else if(shape.equalsIgnoreCase("hexagon") || shape.equalsIgnoreCase("rectangle") || shape.equalsIgnoreCase("diamond") || shape.equalsIgnoreCase("cross"))
			general = new String("polygon");
		else if(shape.equalsIgnoreCase("formation"))
			general = new String("formation");
		else if(shape.equalsIgnoreCase("changed") || shape.equalsIgnoreCase("changing"))
			general = new String("changing");
		else 
			general = new String("other");
		if(shape.equalsIgnoreCase("br"))
			shape = new String("-");
		super.setGeneralShape(general);
		
		
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
