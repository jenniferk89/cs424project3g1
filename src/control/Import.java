package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.io.IOException;
import java.text.*;

import GUI.MainSketch;
import GUI.Utils;

public class Import {


	private static int exceptionCount = 0;

	private static HashMap<String, String> states;

	public static void setStates(){ 
		states = new HashMap<String, String>();
		states.put("AL", "Alabama");
		states.put("AZ", "Arizona");
		states.put("AR", "Arkansas");
		states.put("CA", "California");
		states.put("CO", "Colorado");
		states.put("CT", "Connecticut");
		states.put("DE", "Delaware");
		states.put("FL", "Florida");
		states.put("GA", "Georgia");
		states.put("ID", "Idaho");
		states.put("IL", "Illinois");
		states.put("IN", "Indiana");
		states.put("IA", "Iowa");
		states.put("KS", "Kansas");
		states.put("KY", "Kentucky");
		states.put("LA", "Luisiana");
		states.put("ME", "Maine");
		states.put("MD", "Maryland");
		states.put("MA", "Massachusetts");
		states.put("MI", "Michigan");
		states.put("MN", "Minnesota");
		states.put("MS", "Missisipi");
		states.put("MO", "Missouri");
		states.put("MT", "Montana");
		states.put("NE", "Nebraska");
		states.put("NV", "Nevada");
		states.put("NH", "New Hampshire");
		states.put("NJ", "New Jersey");
		states.put("NM", "New Mexico");
		states.put("NY", "New York");
		states.put("NC", "North Carolina");
		states.put("ND", "North Dakota");
		states.put("OH", "Ohio");
		states.put("OK", "Oklahoma");
		states.put("OR", "Oregon");
		states.put("PA", "Pennsylvania");
		states.put("RI", "Rhode Island");
		states.put("SC", "South Carolina");
		states.put("SD", "South Dakota");
		states.put("TN", "Tennessee");
		states.put("TX", "Texas");
		states.put("UT", "Utah");
		states.put("VT", "Vermont");
		states.put("VA", "Virginia");
		states.put("WA", "Washington");
		states.put("WV", "West Virginia");
		states.put("WI", "Wisconsin");
		states.put("WY", "Wyoming");
		states.put("DC", "District of Columbia");
	}


	public static void militaryBasesHandler(String filePath){
		String strings[] = Utils.globalProcessing.loadStrings(filePath);
		for(int i = 0; i < strings.length; i++){
			String pieces[] = strings[i].split(",");
			/*for(int j = 0; j < pieces.length; j++)
				System.out.println(j +" "+ pieces[j]);*/
			if(pieces[4].contains("HI")||pieces[4].contains("AK"))
				continue;
			String name = pieces[3];
			double lat = Double.parseDouble(pieces[0]);
			double longi = Double.parseDouble(pieces[1]);
			MilitaryBase base = new MilitaryBase(name, lat, longi);
			Utils.allBases.add(base);
			//System.out.println(name + " " + lat +" " +longi);
			Collections.sort(Utils.allBases, Location.lcCoord);
		}
	}

	public static void weatherStationHandler(String filePath){
		String strings[] = Utils.globalProcessing.loadStrings(filePath);
		for(int i = 0; i < strings.length; i++){
			String pieces[] = strings[i].split("\t");
			/*for(int j = 0; j < pieces.length; j++)
				System.out.println(j+" "+pieces[j]);*/
			if(!states.containsKey(pieces[3]))
				continue;
			try{
				String name = pieces[5];
				double lat = Double.parseDouble(pieces[29]);
				double longi = Double.parseDouble(pieces[30]);
				WeatherStation w = new WeatherStation(name, lat,longi);
				//System.out.println(name +" "+lat+" "+longi);
				Utils.allWeatherStations.add(w);
				Collections.sort(Utils.allWeatherStations, Location.lcCoord);
			}
			catch(NumberFormatException e){

			}
		}
	}



	public static void airportHandler(String filePath){
		String strings[] = Utils.globalProcessing.loadStrings(filePath);
		for(int i = 0; i < strings.length; i++){
			String pieces[] = strings[i].split("\t");
			/*for(int j = 0; j < pieces.length; j++)
				System.out.println(j +" "+pieces[j]);*/
			if(!states.containsKey(pieces[10]))
				continue;
			String name = pieces[0];
			double lat = Double.parseDouble(pieces[4]);
			double longi = Double.parseDouble(pieces[5]);
			Airport airport = new Airport(name, lat, longi);
			Utils.allAirports.add(airport);
			Collections.sort(Utils.allAirports, Location.lcCoord);
		}
	}




	public static void ufoHandler(String filepath){

		GregorianCalendar start = new GregorianCalendar();

		String line;

		String strings[] = Utils.globalProcessing.loadStrings(filepath);
		for(int i = 1; i < strings.length; i++){
			line = strings[i];
			//System.out.println("line " + (i+1));
			parseSighting(line);
		}
		System.out.println(exceptionCount);
		Collections.sort(Utils.allLocations, Location.lcCoord);
		Collections.sort(Utils.allCities);
		Collections.sort(Utils.allCounties);
		Collections.sort(Utils.allStates);
		GregorianCalendar stop = new GregorianCalendar();
		System.out.println(stop.getTimeInMillis()-start.getTimeInMillis());

	}

	private static void parseSighting(String line){
		String pieces[] = line.split("\t");
		SimpleDateFormat df = new SimpleDateFormat("mm/dd/yy hh:mm");
		Date temporaryDate;
		try {
			/*for(int i = 0; i < pieces.length; i++)
				System.out.println(i +" "+pieces[i]);*/
			temporaryDate = df.parse(pieces[0]);
			GregorianCalendar date = new GregorianCalendar();
			date.setTime(temporaryDate);
			//System.out.println(pieces[0]);
			//System.out.println(date.toString());
			//System.out.println(line);
			String lat = pieces[9];
			String longi = pieces[10];
			String name = pieces[8];
			Time time = new Time(date);
			double latitude = Double.parseDouble(lat);
			double longitude = Double.parseDouble(longi);
			City place;
			//System.out.println(name +  " "+lat +" "+longi);
			place = new City(name, latitude, longitude);
			pieces[14] = pieces[14].replaceAll(",", "");
			place.setPopulationDensity(Float.parseFloat(pieces[14]));
			if(Utils.allCities.contains(place)){
				place = Utils.allCities.get(Utils.allCities.indexOf(place));
			}
			else
				Utils.allCities.add((City)place);



			//Handle county
			County county = null;
			if(pieces.length > 15){ //some places don't belong to a county, fix later on in the code
				String cName = pieces[16];
				String cLat = pieces[19];
				cLat = cLat.replaceAll("[^\\-0-9]", "");
				String cLong = pieces[20];
				cLong = cLong.replaceAll("[^\\-0-9]", "");
				pieces[17] = pieces[17].replaceAll(",", "");
				float population = Float.parseFloat(pieces[17]);
				pieces[18] = pieces[18].replaceAll(",", "");
				float miles = Float.parseFloat(pieces[18]);
				county = new County(cName, Double.parseDouble(cLat), Double.parseDouble(cLong));
				county.setPopulationDensity(population/miles);
				if(Utils.allCounties.contains(county)){
					county = Utils.allCounties.get(Utils.allCounties.indexOf(county));
				}
				else{
					Utils.allCounties.add(county);
				}
				place.setCounty(county);


				if(!county.getCities().contains(place))
					county.addCity(place);
			}

			//Handle state 
			State state = null;
			for(int i = 0; i < Utils.allStates.size(); i++){
				//System.out.println(Utils.allStates.get(i).getName());
				if(Utils.allStates.get(i).getName().equalsIgnoreCase(states.get(pieces[2]))){

					state = Utils.allStates.get(i);
				}
			}
			if(state == null){
				System.out.println("State not found: " + pieces[2]);
			}
			if(!state.getCities().contains(place))
				state.addCity(place);
			if(county!=null && !state.getCounties().contains(county)){
				state.addCounty(county);
				county.setState(state);
			}



			//System.out.print(city.toString());
			//System.out.println(" " + pieces[2]);

			Shape sh = new Shape(pieces[3]);
			if(Utils.allShapes.contains(sh)){
				sh = Utils.allShapes.get(Utils.allShapes.indexOf(sh));
			}
			else{
				Utils.allShapes.add(sh);
			}
			GeneralShape gSh = (GeneralShape)sh; 
			if(Utils.allGeneralShapes.contains(gSh))
				gSh = Utils.allGeneralShapes.get(Utils.allGeneralShapes.indexOf(gSh));
			else
				Utils.allGeneralShapes.add(gSh);

			//System.out.println(sh.toString());
			durationHandler(pieces[4]);
			String description = pieces[5];
			Sighting s = new Sighting(time, place, sh, description, 1);
			if(Utils.allSightings.contains(s)){ //someone already seen the same UFO, updating counter
				Utils.allSightings.get(Utils.allSightings.indexOf(s)).incNumOfSightings(1);
			}
			else{ //first time this UFO has been seen 
				Utils.allSightings.add(s);
				sh.addSighting(s);
				//here's a trick to have all the shapes syncronized
				for(int i = 0; i < Utils.allShapes.size(); i++){
					sh = Utils.allShapes.get(i);
					if(((GeneralShape)sh).equals(gSh))
						((GeneralShape)sh).setGeneralSightings(gSh.getGeneralSightings());
				}
				place.addSighting(s);
				if(place.getCounty()!=null){
					place.getCounty().addSighting(s);
					place.getCounty().getState().addSighting(s);
				}


			}

		} catch (Exception e) {

			//System.out.println("Unparsable line - skipping");
			exceptionCount++;
		}

	}


	private static void durationHandler(String line){
		//TODO implementation
	}


	public static void createStates(String filePath){
		setStates();
		String strings[] = Utils.globalProcessing.loadStrings(filePath);
		for(int i = 1; i < strings.length; i++){
			String pieces[] = strings[i].split(",");
			String name = pieces[2].replaceAll("\"", "");
			if(name.contains("Washington"))
				name = "Washington";
			double lat = Double.parseDouble(pieces[0]);
			double longi = Double.parseDouble(pieces[1]);
			State state = new State(name, lat, longi);
			float populationDensity = 0;
			if(name.equalsIgnoreCase("District of Columbia"))
				populationDensity = 9857f;
			else if(name.equalsIgnoreCase("New Jersey"))
				populationDensity = 1196f;
			else if(name.equalsIgnoreCase("Rhode Island"))
				populationDensity = 1018f;
			else if(name.equalsIgnoreCase("Massachusetts"))
				populationDensity = 839.4f;
			else if(name.equalsIgnoreCase("Connecticut"))
				populationDensity = 738.1f;
			else if(name.equalsIgnoreCase("Maryland"))
				populationDensity = 594.8f;
			else if(name.equalsIgnoreCase("Delaware"))
				populationDensity = 460.8f;
			else if(name.equalsIgnoreCase("New York"))
				populationDensity = 411.2f;
			else if(name.equalsIgnoreCase("Florida"))
				populationDensity = 350.6f;
			else if(name.equalsIgnoreCase("Pennsylvania"))
				populationDensity = 283.9f;
			else if(name.equalsIgnoreCase("Ohio"))
				populationDensity = 282.3f;
			else if(name.equalsIgnoreCase("California"))
				populationDensity = 239.1f;
			else if(name.equalsIgnoreCase("Illinois"))
				populationDensity = 231.1f;
			else if(name.equalsIgnoreCase("Virginia"))
				populationDensity = 202.6f;
			else if(name.equalsIgnoreCase("North Carolina"))
				populationDensity = 196.1f;
			else if(name.equalsIgnoreCase("Indiana"))
				populationDensity = 181.0f;
			else if(name.equalsIgnoreCase("Michigan"))
				populationDensity = 174.8f;
			else if(name.equalsIgnoreCase("Georgia"))
				populationDensity = 168.4f;
			else if(name.equalsIgnoreCase("South Carolina"))
				populationDensity = 153.9f;
			else if(name.equalsIgnoreCase("Tennessee"))
				populationDensity = 153.9f;
			else if(name.equalsIgnoreCase("New Hampshire"))
				populationDensity = 147.0f;
			else if(name.equalsIgnoreCase("Kentucky"))
				populationDensity = 109.9f;
			else if(name.equalsIgnoreCase("Wisconsin"))
				populationDensity = 105.0f;
			else if(name.equalsIgnoreCase("Luisiana"))
				populationDensity = 104.9f;
			else if(name.equalsIgnoreCase("Washington"))
				populationDensity = 101.2f;
			else if(name.equalsIgnoreCase("Texas"))
				populationDensity = 96.3f;
			else if(name.equalsIgnoreCase("Alabama"))
				populationDensity = 94.4f;
			else if(name.equalsIgnoreCase("Missouri"))
				populationDensity = 87.1f;
			else if(name.equalsIgnoreCase("West Virginia"))
				populationDensity = 77.1f;
			else if(name.equalsIgnoreCase("Vermont"))
				populationDensity = 67.9f;
			else if(name.equalsIgnoreCase("Minnesota"))
				populationDensity = 66.6f;
			else if(name.equalsIgnoreCase("Missisipi"))
				populationDensity = 63.2f;
			else if(name.equalsIgnoreCase("Arizona"))
				populationDensity = 56.3f;
			else if(name.equalsIgnoreCase("Arkansas"))
				populationDensity = 56.0f;
			else if(name.equalsIgnoreCase("Oklahoma"))
				populationDensity = 54.7f;
			else if(name.equalsIgnoreCase("Iowa"))
				populationDensity = 54.5f;
			else if(name.equalsIgnoreCase("Colorado"))
				populationDensity = 48.5f;
			else if(name.equalsIgnoreCase("Maine"))
				populationDensity = 43.1f;
			else if(name.equalsIgnoreCase("Oregon"))
				populationDensity = 39.9f;
			else if(name.equalsIgnoreCase("Kansas"))
				populationDensity = 34.9f;
			else if(name.equalsIgnoreCase("Utah"))
				populationDensity = 33.6f;
			else if(name.equalsIgnoreCase("Nevada"))
				populationDensity = 24.6f;
			else if(name.equalsIgnoreCase("Nebraska"))
				populationDensity = 23.8f;
			else if(name.equalsIgnoreCase("Idaho"))
				populationDensity = 19.0f;
			else if(name.equalsIgnoreCase("New Mexico"))
				populationDensity = 17.0f;
			else if(name.equalsIgnoreCase("South Dakota"))
				populationDensity = 10.7f;
			else if(name.equalsIgnoreCase("North Dakota"))
				populationDensity = 9.7f;
			else if(name.equalsIgnoreCase("Montana"))
				populationDensity = 6.8f;
			else if(name.equalsIgnoreCase("Wyoming"))
				populationDensity = 5.8f;

			state.setPopulationDensity(populationDensity);
			//System.out.println(name +" " +populationDensity);
			Utils.allStates.add(state);
		}
	}

	public static void mergeDatasets(){
		//first, we find the nearest airport for each city
		ArrayList<Location> list = new ArrayList<Location>();
		for(Airport a : Utils.allAirports)
			list.add(a);
		System.out.println(Utils.allAirports.size());
		for(City c : Utils.allCities){
			Airport a;
			a = (Airport)Utils.findNearestLocation(c, list);
			//System.out.println("found");
			c.setDistanceAirport((float)Utils.haversine(c.getLatitude(), c.getLongitude(), a.getLatitude(), a.getLongitude()));
			//System.out.println(c.getDistanceAirport());
			c.setAirport(a);
			for(Sighting s: c.getSightings())
				a.addNearSightings(s);

		}
		//then we do the same thing, but with the military base
		list = new ArrayList<Location>();
		for(MilitaryBase m: Utils.allBases)
			list.add(m);
		for(City c: Utils.allCities){
			MilitaryBase m;
			m = (MilitaryBase)Utils.findNearestLocation(c, list);
			c.setMilitaryBase(m);
			c.setDistanceBase((float)Utils.haversine(c.getLatitude(), c.getLongitude(), m.getLatitude(), m.getLongitude()));
			for(Sighting s: c.getSightings())
				m.addNearSightings(s);
		}
	}


	/*	public static void main(String [] args){
		MainSketch m = new MainSketch();
		setStates();
		Utils.globalProcessing = m;
		//m.setup();
		//militaryBasesHandler("militaryBases.txt");
		//airportHandler("airports.txt");
		weatherStationHandler("weatherStation.txt");
		//createStates("States.txt");
		//ufoHandler("Al.txt");
	}*/
}
