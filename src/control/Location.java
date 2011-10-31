package control;

import java.util.Comparator;

public abstract class Location implements Comparable{
	private String name;
	private double latitude;
	private double longitude;
	public static LocationComparator lcCoord;
	




	public Location(String name, double latitude, double longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Location other = (Location) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public static class LocationComparator implements Comparator{

		@Override
		public int compare(Object arg0, Object arg1) {
			if(!arg0.getClass().equals(Location.class) || ! arg1.getClass().equals(Location.class))
				return 0;
			Location l0, l1;
			l0 = (Location)arg0;
			l1 = (Location)arg1;
			if(l0.equals(l1))
				return 0;
			if(l0.longitude < l1.longitude)
				return -1;
			else if(l0.longitude > l1.longitude)
				return 1;
			else if(l0.latitude > l1.latitude)
				return -1;
			else
				return 1;
		}

	}

	
	@Override
	public int compareTo(Object arg0) {
		if(arg0.getClass()!=this.getClass())
			return 0;
		Location c0 = (Location)arg0;
		return(this.getName().compareToIgnoreCase(c0.getName()));
	}
	


	@Override
	public String toString() {
		return "Location [name=" + name + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	


	

}	