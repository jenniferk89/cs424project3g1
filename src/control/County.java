package control;

import java.util.ArrayList;

public class County extends Location{
	private float populationDensity;
	private State state;
	private ArrayList<Location> cities;
	private ArrayList<Sighting> sightings;

	public County(String name, double latitude, double longitude) {
		super(name, latitude, longitude);
		this.cities = new ArrayList<Location>();
		sightings = new ArrayList<Sighting>();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<Location> getCities() {
		return cities;
	}

	public void addCity(City city) {
		this.cities.add(city);
	}

	

	public float getPopulationDensity() {
		return populationDensity;
	}

	public void setPopulationDensity(float populationDensity) {
		this.populationDensity = populationDensity;
	}

	public ArrayList<Sighting> getSightings() {
		return sightings;
	}

	public void addSighting(Sighting sighting) {
		this.sightings.add(sighting);
	}

	public void setCities(ArrayList<Location> cities) {
		this.cities = cities;
	}
	
	
	
	
}
