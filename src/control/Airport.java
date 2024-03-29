package control;

import java.util.ArrayList;

import com.modestmaps.core.Point2f;
import com.modestmaps.geo.Location;

import GUI.Drawable;
import GUI.Utils;

public class Airport extends control.Location implements Drawable{
	private ArrayList<Sighting> nearSightings;


	
	public Airport(String name, double latitude, double longitude) {
		super(name, latitude, longitude);
		nearSightings = new ArrayList<Sighting>();
	}

	public ArrayList<Sighting> getNearSightings() {
		return nearSightings;
	}

	public void addNearSightings(Sighting nearSighting) {
		this.nearSightings.add(nearSighting);
	}
	
	public void draw(){
		Location l = new Location((float)super.getLatitude(), (float)super.getLongitude());
		Point2f p = Utils.globalMap.locationPoint(l);
		Utils.globalProcessing.fill(Utils.AirportColor);
		Utils.globalProcessing.stroke(Utils.AirportColor);
		Utils.globalProcessing.triangle(p.x, p.y+1, p.x-2, p.y-2, p.x+2, p.y-2);
		Utils.globalProcessing.noStroke();
		Utils.globalProcessing.noFill();
		//Utils.globalProcessing.strokeWeight(1);
	}
}
