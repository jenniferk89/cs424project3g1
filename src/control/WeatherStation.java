package control;

import java.util.ArrayList;

import com.modestmaps.core.Point2f;
import com.modestmaps.geo.Location;

import GUI.Drawable;
import GUI.Utils;

public class WeatherStation extends control.Location implements Drawable{
	private ArrayList<Sighting> nearSightings;


	
	public WeatherStation(String name, double latitude, double longitude) {
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
		Utils.globalProcessing.strokeWeight(2);
		Utils.globalProcessing.stroke(Utils.weatherStationColor);
		Point2f p = Utils.globalMap.locationPoint(l);
		Utils.globalProcessing.beginShape();
		Utils.globalProcessing.vertex(p.x-2, p.y-2);
		Utils.globalProcessing.vertex(p.x+2, p.y+2);
		Utils.globalProcessing.endShape();
		Utils.globalProcessing.beginShape();
		Utils.globalProcessing.vertex(p.x+2, p.y-2);
		Utils.globalProcessing.vertex(p.x-2, p.y+2);
		Utils.globalProcessing.endShape();
		Utils.globalProcessing.strokeWeight(1);
		Utils.globalProcessing.noStroke();
	}
}
