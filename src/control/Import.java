package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.*;

import GUI.MainSketch;
import GUI.Utils;

public class Import {
	
	public static void ufoHandler(String filepath){
		
		Utils.allSightings = new ArrayList<Sighting>();
		Utils.allLocations = new ArrayList<Location>();
		Utils.allStates = new ArrayList<State>();
		Utils.allCounties = new ArrayList<County>();
		Utils.allCities = new ArrayList<City>();
		Utils.allShapes = new ArrayList<Shape>();
		String line;
		
		String strings[] = Utils.globalProcessing.loadStrings(filepath);
		for(int i = 1; i < strings.length; i++){
			line = strings[i];
			System.out.println("line " + (i+1));
			parseSighting(line);
		}
		//TODO sync all generalShapes
		
	}
	
	private static void parseSighting(String line){
		String pieces[] = line.split("\t");
		SimpleDateFormat df = new SimpleDateFormat("mm/dd/yy hh:mm");
		Date temporaryDate;
		try {
			
			temporaryDate = df.parse(pieces[0]);
			GregorianCalendar date = new GregorianCalendar();
			date.setTime(temporaryDate);
			//System.out.println(pieces[0]);
			//System.out.println(date.toString());
			System.out.println(line);
			String coordinates[] = pieces[pieces.length-1].split(",");
			String name = pieces[1];
			Time time = new Time(date);
			double latitude = Double.parseDouble(coordinates[0]);
			double longitude = Double.parseDouble(coordinates[1]);
			City city = new City(name, latitude, longitude);
			if(Utils.allCities.contains(city)){
				city = Utils.allCities.get(Utils.allCities.indexOf(city));
			}
			else{
				Utils.allCities.add(city);
			}
			
			//System.out.print(city.toString());
			//System.out.println(" " + pieces[2]);
			stateHandler(city,pieces[2]);
			Shape sh = new Shape(pieces[3]);
			if(Utils.allShapes.contains(sh)){
				sh = Utils.allShapes.get(Utils.allShapes.indexOf(sh));
			}
			else{
				Utils.allShapes.add(sh);
			}
			//System.out.println(sh.toString());
			durationHandler(pieces[4]);
			String description = pieces[5];
			Sighting s = new Sighting(time, city, sh, description, 1);
			if(Utils.allSightings.contains(s)){ //someone already seen the same UFO, updating counter
				Utils.allSightings.get(Utils.allSightings.indexOf(s)).incNumOfSightings(1);
			}
			else{ //first time this UFO has been seen 
				Utils.allSightings.add(s);
				sh.addSighting(s);
				city.addSighting(s);
				if(city.getCounty() != null){
					city.getCounty().addSighting(s);
					if(city.getCounty().getState() != null)
						city.getCounty().getState().addSighting(s);
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unparsable line - skipping");
			
		}
		
	}
	
private static void stateHandler(City city, String code){
	//TODO implementation
}
	
private static void durationHandler(String line){
	//TODO implementation
}
	
	
	
	
	
	public static void main(String [] args){
		MainSketch m = new MainSketch();
		Utils.globalProcessing = m;
		ufoHandler("ndxlAL.html.txt");
	}
}
