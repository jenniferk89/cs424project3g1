package control;

import java.util.ArrayList;

public class City extends Location{
	private County county;
	private float populationDensity;
	private Airport airport;
	private MilitaryBase militaryBase;
	private ArrayList<Sighting> sightings;
	private float distanceAirport;
	private float distanceBase;
	
	
	public City(String name, double latitude, double longitude) {
		super(name, latitude, longitude);
		sightings = new ArrayList<Sighting>();
	}


	
	
	
	public float getDistanceAirport() {
		return distanceAirport;
	}





	public void setDistanceAirport(float distanceAirport) {
		this.distanceAirport = distanceAirport;
	}





	public float getDistanceBase() {
		return distanceBase;
	}





	public void setDistanceBase(float distanceBase) {
		this.distanceBase = distanceBase;
	}





	public void setCounty(County county) {
		this.county = county;
	}


	public float getPopulationDensity() {
		return populationDensity;
	}


	public void setPopulationDensity(float population) {
		this.populationDensity = population;
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


	public County getCounty() {
		return county;
	}


	public ArrayList<Sighting> getSightings() {
		return sightings;
	}


	public void addSighting(Sighting sighting) {
		this.sightings.add(sighting);
	}
	
	public boolean equals(Object o){
		return super.equals(o);
	}
	
	public int hashCode(){
		return super.hashCode();
	}


	
	
	
	
	
}
