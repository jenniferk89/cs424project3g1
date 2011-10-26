package control;

import java.util.ArrayList;

public class InterestingPlace extends Location {
	
	private City city;
	private Airport airport;
	private MilitaryBase militaryBase;
	private ArrayList<Sighting> sightings;
	
	
	public InterestingPlace(String name, double latitude, double longitude, City city) {
		super(name, latitude, longitude);
		this.city = city;
		sightings = new ArrayList<Sighting>();
	}


	public Airport getAirport() {
		return airport;
	}


	public void setAirport(Airport airport) {
		this.airport = airport;
	}


	public MilitaryBase getMilitaryBase() {
		return militaryBase;
	}


	public void setMilitaryBase(MilitaryBase militaryBase) {
		this.militaryBase = militaryBase;
	}


	public City getCity() {
		return city;
	}


	public ArrayList<Sighting> getSightings() {
		return sightings;
	}


	public void addSighting(Sighting sighting) {
		this.sightings.add(sighting);
	}


	public void setCity(City city) {
		this.city = city;
	}
	
	
	
	
	
}
