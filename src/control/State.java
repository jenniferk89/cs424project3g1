package control;

import java.util.ArrayList;

public class State extends Location{
	private int population;
	private String name;
	private ArrayList<County> counties;
	private ArrayList<City> cities;
	
	
	public State(String name, double latitude, double longitude) {
		super(name, latitude, latitude);
		
		this.counties = new ArrayList<County>();
		this.cities = new ArrayList<City>();
	}


	public ArrayList<County> getCounties() {
		return new ArrayList(counties);
	}


	public void addCounty(County county) {
		this.counties.add(county);
	}


	public ArrayList<City> getCities() {
		return new ArrayList(cities);
	}


	public void addCity(City cities) {
		this.cities.add(cities);
	}
	
	
	
	
}
