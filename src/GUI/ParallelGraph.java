package GUI;

import java.util.ArrayList;

import control.*;


public class ParallelGraph {
	
	public static void draw(ArrayList<Sighting> data){ //TODO refine and make better with relationships
		Utils.globalProcessing.fill(255);
		
		Utils.globalProcessing.rect(0, 0, 1024, 768);
		//Utils.globalProcessing.rectMode(Utils.globalProcessing.CORNERS);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		ArrayList<Time> times = new ArrayList<Time>();
		ArrayList<Location> locations = new ArrayList<Location>();
		//calculate min/max for each dimension
		for(int i = 0; i < data.size(); i++){
			Sighting s = data.get(i);
			if(!shapes.contains(s.getShape()))
				shapes.add(s.getShape());
			if(!times.contains(s.getTime()))
				times.add(s.getTime());
			if(!locations.contains(s.getPosition()))
				locations.add(s.getPosition());
		}
		float xPloti, xPlote, yPloti, yPlote;
		xPloti = 10;
		xPlote = 1014;
		yPloti = 10;
		yPlote = 758;
		
		Utils.globalProcessing.stroke(0,0,0);
		for(int i = 0; i < data.size(); i++){
			Sighting s = data.get(i);
			Utils.globalProcessing.beginShape();
			//Utils.globalProcessing.stroke(120);
			float x = Utils.globalProcessing.map((xPlote-xPloti)/4, xPloti, xPlote, xPloti, xPlote);
			float y = Utils.globalProcessing.map(shapes.indexOf(s.getShape()), 0, shapes.size(), yPloti, yPlote);
			
			Utils.globalProcessing.vertex(x,y); // shape
			
			x = Utils.globalProcessing.map(2*(xPlote-xPloti)/4, xPloti, xPlote, xPloti, xPlote);
			y = Utils.globalProcessing.map(times.indexOf(s.getTime()), 0, times.size(), yPloti, yPlote);
			
			Utils.globalProcessing.vertex(x,y); //time 
			Utils.globalProcessing.endShape();
			//It works only if I threat all the couple of points as separate, indipendent lines
			Utils.globalProcessing.beginShape();
			
			Utils.globalProcessing.vertex(x,y);
			
			x = Utils.globalProcessing.map(3*(xPlote-xPloti)/4, xPloti, xPlote, xPloti, xPlote);
			y = Utils.globalProcessing.map(locations.indexOf(s.getPosition()), 0, locations.size(), yPloti, yPlote);
			//System.out.println(x +" " +y);
			Utils.globalProcessing.vertex(x,y); //location
			Utils.globalProcessing.endShape();
			
		}
		
	}
	
}
