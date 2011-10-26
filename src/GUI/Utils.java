package GUI;

import java.util.ArrayList;

import control.*;


import processing.core.PApplet;

//Put all the shared values as static variables here



public class Utils {
	public static PApplet globalProcessing;
	public static ArrayList<Sighting> allSightings;
	public static ArrayList<Location> allLocations;
	public static ArrayList<State> allStates;
	public static ArrayList<County> allCounties;
	public static ArrayList<City> allCities;
	public static ArrayList<Airport> allAirports;
	public static ArrayList<MilitaryBase> allBases; //are in belong to us
	 
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
	public static final int WEEK = 0;
	public static final int MONTH = 0;
	public static final int YEAR = 0;
	
	
}
