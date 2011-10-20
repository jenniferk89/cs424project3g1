package control;

public class Sighting {
	private Time time;
	private Location location;
	private Shape shape;
	private String description;
	private Integer numOfSightings; //affected by granularity of data
	
	public Sighting() {
		super();
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Location getPosition() {
		return location;
	}

	public void setLocation(Location location) {
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
	
	
	
	
	
	
	
}
