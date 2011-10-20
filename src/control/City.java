package control;

public class City extends Location {
	private County county;
	private int population;
	private Airport airport;
	private MilitaryBase militaryBase;
	
	
	public City(String name, double latitude, double longitude) {
		super(name, latitude, longitude);
		
	}


	public void setCounty(County county) {
		this.county = county;
	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		this.population = population;
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
	
	
	
	
}
