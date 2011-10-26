package control;

import java.util.ArrayList;

public class Airport extends Location {
	private ArrayList<Sighting> nearSightings;


	
	public Airport(String name, double latitude, double longitude) {
		super(name, latitude, longitude);
		nearSightings = new ArrayList<Sighting>();
	}

	public ArrayList<Sighting> getNearSightings() {
		return nearSightings;
	}

	public void addNearSightings(Sighting nearSighting) {
		this.nearSightings.add(nearSighting);
	}
}
