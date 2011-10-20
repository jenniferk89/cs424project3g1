package control;

public class InterestingPlace extends Location {
	
	private City city;
	private Airport airport;
	private MilitaryBase militaryBase;
	
	
	public InterestingPlace(String name, float latitude, float longitude, City city) {
		super(name, latitude, longitude);
		this.city = city;
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
	
	
	
	
	
}
