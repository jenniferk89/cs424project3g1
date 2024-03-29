package control;

import GUI.Drawable;
import GUI.Utils;

import com.modestmaps.core.Point2f;
import com.modestmaps.geo.Location;

public class Sighting {
	private Time time;
	private control.Location location;
	private Shape shape;
	private String description;
	private Integer numOfSightings; //affected by granularity of data
	
	public Sighting() {
		super();
	}
	
	

	public Sighting(Time time, control.Location location, Shape shape,
			String description, Integer numOfSightings) {
		super();
		this.time = time;
		this.location = location;
		this.shape = shape;
		this.description = description;
		this.numOfSightings = numOfSightings;
	}



	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public control.Location getPosition() {
		return location;
	}

	public void setLocation(control.Location location) {
		this.location = location;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumOfSightings() {
		return numOfSightings;
	}

	public void setNumOfSightings(Integer numOfSightings) {
		this.numOfSightings = numOfSightings;
	}
	
	public void incNumOfSightings(Integer num){
		this.numOfSightings += num;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Sighting other = (Sighting) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (shape == null) {
			if (other.shape != null)
				return false;
		} else if (!shape.equals(other.shape))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	
	public void draw(int min, int max){
		control.Location here = this.getPosition();
		Location l = new Location((float)here.getLatitude(), (float)here.getLongitude());
		Utils.globalProcessing.fill(this.getShape().getColor());
		Point2f p = Utils.globalMap.locationPoint(l);
		float dimension = Utils.globalProcessing.map(this.getNumOfSightings(), min, max, 3, 12);
		Utils.globalProcessing.ellipse(p.x, p.y, dimension, dimension);
	}
	
	
	
	
}
