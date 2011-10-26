package control;

import java.util.ArrayList;

public class State extends Location{
	private int population;
	private ArrayList<County> counties;
	private ArrayList<City> cities;
	private ArrayList<Sighting> sightings;
	
	public State(String name, double latitude, double longitude) {
		super(name, latitude, latitude);
		
		this.counties = new ArrayList<County>();
		this.cities = new ArrayList<City>();
		sightings = new ArrayList<Sighting>();
	}


	public ArrayList<County> getCounties() {
		return counties;
	}


	public void addCounty(County county) {
		this.counties.add(county);
	}


	public ArrayList<City> getCities() {
		return cities;
	}


	public void addCity(City cities) {
		this.cities.add(cities);
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


	public void setCounties(ArrayList<County> counties) {
		this.counties = counties;
	}


	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}
	
	
	
	
}
