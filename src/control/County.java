package control;

import java.util.ArrayList;

public class County extends Location{
	private int population;
	private State state;
	private ArrayList<City> cities;

	public County(String name, float latitude, float longitude) {
		super(name, latitude, longitude);
		this.cities = new ArrayList<City>();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<City> getCities() {
		return new ArrayList<City>(cities);
	}

	public void addCity(City city) {
		this.cities.add(city);
	}
	
	
	
	
}
