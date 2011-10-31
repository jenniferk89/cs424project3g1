package GUI;

import java.util.ArrayList;
import java.util.Calendar;

import control.*;


public class ParallelGraph {

	public static void draw(ArrayList<Sighting> data){ //TODO refine and make better with relationships
		int backgroundColor = Utils.globalProcessing.color(120, 120, 120, 50);
		Utils.globalProcessing.fill(backgroundColor);

		Utils.globalProcessing.rect(200, 0, 1024, 768);
		//Utils.globalProcessing.rectMode(Utils.globalProcessing.CORNERS);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		ArrayList<Time> times = new ArrayList<Time>();
		ArrayList<City> locations = new ArrayList<City>();
		//calculate min/max for each dimension
		for(int i = 0; i < data.size(); i++){
			Sighting s = data.get(i);
			if(!shapes.contains(s.getShape()))
				shapes.add(s.getShape());
			if(!times.contains(s.getTime()))
				times.add(s.getTime());
			if(!locations.contains(s.getPosition()))
				locations.add((City)s.getPosition());
		}
		float xPloti, xPlote, yPloti, yPlote;
		xPloti = 60;
		xPlote = 1024;
		yPloti = 30;
		yPlote = 778;

		float maxDistance = 0;
		float minPopulationDensity = locations.get(0).getPopulationDensity();
		float maxpopulationDensity = locations.get(0).getPopulationDensity();
		for(City c: locations){
			if(c.getDistanceAirport() > maxDistance)
				maxDistance = c.getDistanceAirport();
			if(c.getPopulationDensity()< minPopulationDensity)
				minPopulationDensity = c.getPopulationDensity();
			else if(c.getPopulationDensity() > maxpopulationDensity)
				maxpopulationDensity = c.getPopulationDensity();

		}



		
		for(int i = 0; i < data.size(); i++){
			Sighting s = data.get(i);
			Utils.globalProcessing.stroke(s.getShape().getColor());
			Utils.globalProcessing.beginShape();
			//Utils.globalProcessing.stroke(120);
			float x = Utils.globalProcessing.map((xPlote-xPloti)/7, xPloti, xPlote, xPloti, xPlote);
			float y = Utils.globalProcessing.map(((City)s.getPosition()).getDistanceAirport(), 0, maxDistance, yPloti, yPlote);

			Utils.globalProcessing.vertex(x,y); // distance

			x = Utils.globalProcessing.map(2*(xPlote-xPloti)/7, xPloti, xPlote, xPloti, xPlote);
			y = Utils.globalProcessing.map(((City)s.getPosition()).getPopulationDensity(), minPopulationDensity, maxpopulationDensity, yPloti, yPlote);

			Utils.globalProcessing.vertex(x,y); //populationDensity
			Utils.globalProcessing.endShape();
			//It works only if I threat all the couple of points as separate, indipendent lines
			Utils.globalProcessing.beginShape();

			Utils.globalProcessing.vertex(x,y);

			x = Utils.globalProcessing.map(3*(xPlote-xPloti)/7, xPloti, xPlote, xPloti, xPlote);
			if(s.getTime().getBeginTime().get(Calendar.HOUR_OF_DAY)<19 &&s.getTime().getBeginTime().get(Calendar.HOUR_OF_DAY)>=7)
				y = Utils.globalProcessing.map(1, 0, 3, yPloti, yPlote); //day 
			else	
				y = Utils.globalProcessing.map(2, 0, 3, yPloti, yPlote); //night 
			//System.out.println(x +" " +y);
			Utils.globalProcessing.vertex(x,y); // night/day
			Utils.globalProcessing.endShape();
			Utils.globalProcessing.beginShape();
			
			Utils.globalProcessing.vertex(x,y);
			x = Utils.globalProcessing.map(4*(xPlote-xPloti)/7, xPloti, xPlote, xPloti, xPlote);
			y = Utils.globalProcessing.map(s.getTime().getBeginTime().get(Calendar.MONTH)+1, 0, 13, yPloti, yPlote);
			Utils.globalProcessing.vertex(x, y); //month of the year
			
			Utils.globalProcessing.endShape();
			Utils.globalProcessing.beginShape();
			
			Utils.globalProcessing.vertex(x, y);
			x = Utils.globalProcessing.map(5*(xPlote-xPloti)/7, xPloti, xPlote, xPloti, xPlote);
			if(s.getTime().getBeginTime().get(Calendar.MONTH)==Calendar.MARCH || s.getTime().getBeginTime().get(Calendar.MONTH) == Calendar.APRIL ||
					s.getTime().getBeginTime().get(Calendar.MONTH) == Calendar.MAY) //Spring
			y = Utils.globalProcessing.map(1, 0, 5, yPloti, yPlote);
			else if(s.getTime().getBeginTime().get(Calendar.MONTH)==Calendar.JUNE || s.getTime().getBeginTime().get(Calendar.MONTH) == Calendar.JULY ||
					s.getTime().getBeginTime().get(Calendar.MONTH) == Calendar.AUGUST) //summer
				y = Utils.globalProcessing.map(2, 0, 5, yPloti, yPlote);
			else if(s.getTime().getBeginTime().get(Calendar.MONTH)==Calendar.SEPTEMBER || s.getTime().getBeginTime().get(Calendar.MONTH) == Calendar.OCTOBER ||
					s.getTime().getBeginTime().get(Calendar.MONTH) == Calendar.NOVEMBER) //autumn
				y = Utils.globalProcessing.map(3, 0, 5, yPloti, yPlote);
			else
				y = Utils.globalProcessing.map(3, 0, 5, yPloti, yPlote);
			Utils.globalProcessing.vertex(x, y); //seasons
			
			Utils.globalProcessing.endShape();
			Utils.globalProcessing.beginShape();
			
			Utils.globalProcessing.vertex(x, y);
			
			x = Utils.globalProcessing.map(6*(xPlote-xPloti)/7, xPloti, xPlote, xPloti, xPlote);
			y = Utils.globalProcessing.map(s.getTime().getBeginTime().get(Calendar.YEAR), 2000, 2011, yPloti, yPlote);
			Utils.globalProcessing.vertex(x, y); //years
			Utils.globalProcessing.endShape();
		}

	}

}
