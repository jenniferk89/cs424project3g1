package GUI;

import java.util.ArrayList;

import com.modestmaps.InteractiveMap;

import control.*;


import processing.core.PApplet;

//Put all the shared values as static variables here



public class Utils {
	public static PApplet globalProcessing;
	public static InteractiveMap globalMap;
	public static ArrayList<Sighting> allSightings;
	public static ArrayList<Location> allLocations;
	public static ArrayList<State> allStates;
	public static ArrayList<County> allCounties;
	public static ArrayList<City> allCities;
	public static ArrayList<Airport> allAirports;
	public static ArrayList<MilitaryBase> allBases; //are belong to us
	public static ArrayList<Shape> allShapes;
	public static ArrayList<GeneralShape> allGeneralShapes;
	public static ArrayList<WeatherStation> allWeatherStations;
	
	
	public static boolean showGraph;
	public static final int DEFAULT_RADIUS = 50; //50 miles as default
	public double radius = DEFAULT_RADIUS;
	public static Location centerLocation;
	public double spaceAggregationLevel; //TODO keep in sync with zoomLevel
	//space different levels
	public static final int CITY = 0;
	public static final int COUNTY = 1;
	public static final int STATE = 2;

	public int timeAggregationLevel;
	//time different levels
	public static final int DAY = 0;
	public static final int WEEK = 1;
	public static final int MONTH = 2;
	public static final int YEAR = 3;

	public static int lightColor;
	public static int roundColor;
	public static int arrowColor;
	public static int polygonColor;
	public static int formationColor;
	public static int changingColor;
	public static int otherColor;
	public static int militaryBaseColor;
	public static int AirportColor;
	public static int weatherStationColor;


	//From http://en.wikipedia.org/wiki/Haversine_formula
	public static double haversine(double lat1, double lng1, double lat2, double lng2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1)) * 
		Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)) * 6371; // 6371 = average earth radius
	}

	//This function assumes that the points are ordered
	//then does a binary search for calculating the Harvesine distance (since we are in a spherical geometry)
	//to find the nearest point
	public static control.Location findNearestLocation(City c, ArrayList<Location> list){ //If it works I'm definetly a wizard
		Location result = null;

		int oldindex = list.size()-1;
		int index = oldindex/2;
		double olddistance = haversine(c.getLatitude(), c.getLongitude(), list.get(oldindex).getLatitude(), list.get(oldindex).getLongitude());
		double distance;
		boolean found = false;
		while(!found){
			distance = haversine(c.getLatitude(), c.getLongitude(), list.get(index).getLatitude(), list.get(index).getLongitude());
			if(distance < olddistance){ //I move
				olddistance = distance;
				oldindex = index;
				index = index - Math.abs(oldindex - index)/2;
			}
			else{ //I remain
				index = oldindex -Math.abs(oldindex -index)/2;
			}
			if(index>=oldindex){//finish
				result = list.get(oldindex);
				found=true; 
			}
		}
		return result;
	}
	
}



