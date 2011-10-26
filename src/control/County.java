package control;

import java.util.ArrayList;

public class County extends Location{
	private int population;
	private State state;
	private ArrayList<City> cities;
	private ArrayList<Sighting> sightings;

	public County(String name, double latitude, double longitude) {
		super(name, latitude, longitude);
		this.cities = new ArrayList<City>();
		sightings = new ArrayList<Sighting>();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void addCity(City city) {
		this.cities.add(city);
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public ArrayList<Sighting> getSightings() {
		return sightings;
	}

	public void addSighting(Sighting sighting) {
		this.sightings.add(sighting);
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}
	
	
	
	
}
