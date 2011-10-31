package GUI;

import java.util.ArrayList;

import control.City;
import control.County;
import control.Import;
import control.Shape;
import control.*;
import control.State;
import control.Test;
import processing.core.*;
import com.modestmaps.InteractiveMap;
import com.modestmaps.StaticMap;
import com.modestmaps.core.Coordinate;
import com.modestmaps.core.Point2f;
import com.modestmaps.geo.Location;
import com.modestmaps.providers.*;


public class MainSketch extends PApplet{


	//
	// This is a test of the interactive Modest Maps library for Processing
	// the modestmaps.jar in the code folder of this sketch might not be 
	// entirely up to date - you have been warned!
	//

	

	// this is the only bit that's needed to show a map:
	InteractiveMap map;

	Menu theMenu;
	// buttons take x,y and width,height:
	ZoomButton out = new ZoomButton(5,5,14,14,false);
	ZoomButton in = new ZoomButton(22,5,14,14,true);
	PanButton up = new PanButton(14,25,14,14,UP);
	PanButton down = new PanButton(14,57,14,14,DOWN);
	PanButton left = new PanButton(5,41,14,14,LEFT);
	PanButton right = new PanButton(22,41,14,14,RIGHT);

	HBar theScroll = new HBar(250,600,600,25);
	

	// all the buttons in one place, for looping:
	Button[] buttons = { 
			in, out, up, down, left, right };

	PFont font;

	boolean gui = true;

	public void setup() {

		Utils.globalProcessing = this;
		Utils.globalProcessing.size(1024, 768);
		Utils.globalProcessing.smooth();
		Utils.allSightings = new ArrayList<Sighting>();
		Utils.allLocations = new ArrayList<control.Location>();
		Utils.allStates = new ArrayList<State>();
		Utils.allCounties = new ArrayList<County>();
		Utils.allCities = new ArrayList<City>();
		Utils.allShapes = new ArrayList<Shape>();
		Utils.allGeneralShapes = new ArrayList<GeneralShape>();
		Utils.allBases = new ArrayList<MilitaryBase>();
		Utils.allAirports = new ArrayList<Airport>();
		Utils.allWeatherStations = new ArrayList<WeatherStation>();
		// create a new map, optionally specify a provider
		map = new InteractiveMap(this, new Microsoft.RoadProvider());
		Utils.globalMap = map;
		
		theMenu = new Menu(200);
		
		//set the colors //TODO crappy colors
		Utils.lightColor = Utils.globalProcessing.color(112, 47, 47);
		Utils.roundColor = Utils.globalProcessing.color(239, 234, 91);
		Utils.arrowColor = Utils.globalProcessing.color(42, 134, 72);
		Utils.polygonColor = Utils.globalProcessing.color(50, 40, 234);
		Utils.formationColor = Utils.globalProcessing.color(205, 131, 223);
		Utils.otherColor = Utils.globalProcessing.color(123, 159, 163);
		Utils.changingColor = Utils.globalProcessing.color(195, 147, 109);
		Utils.militaryBaseColor = Utils.globalProcessing.color(255, 0, 0);
		Utils.AirportColor = Utils.globalProcessing.color(0, 120, 120, 45);
		Utils.weatherStationColor = Utils.globalProcessing.color(120, 120, 0, 20);
		
		
		
		map.MAX_IMAGES_TO_KEEP = 80; //using less images to preserve heap space
		Import.createStates("States.txt");
		Import.weatherStationHandler("weatherStation.txt");
		Import.militaryBasesHandler("militaryBases.txt");
		Import.airportHandler("airports.txt");
		//Import.ufoHandler("all.txt");
		
		/*Import.ufoHandler("ndxlAL.html.txt");
		Import.ufoHandler("ndxlAR.html.txt");
		Import.ufoHandler("ndxlAZ.html.txt");
		Import.ufoHandler("ndxlCA.html.txt");
		Import.ufoHandler("ndxlCO.html.txt");
		Import.ufoHandler("ndxlCT.html.txt");
		Import.ufoHandler("ndxlDC.html.txt");
		Import.ufoHandler("ndxlDE.html.txt");
		Import.ufoHandler("ndxlFL.html.txt");
		Import.ufoHandler("ndxlGA.html.txt");
		Import.ufoHandler("ndxlHI.html.txt");
		Import.ufoHandler("ndxlIA.html.txt");
		Import.ufoHandler("ndxlID.html.txt");
		Import.ufoHandler("ndxlIL.html.txt");
		Import.ufoHandler("ndxlIN.html.txt");
		Import.ufoHandler("ndxlKS.html.txt");
		Import.ufoHandler("ndxlKY.html.txt");
		Import.ufoHandler("ndxlLA.html.txt");
		Import.ufoHandler("ndxlMA.html.txt");
		Import.ufoHandler("ndxlMB.html.txt");
		Import.ufoHandler("ndxlMD.html.txt");
		Import.ufoHandler("ndxlME.html.txt");
		Import.ufoHandler("ndxlMI.html.txt");
		Import.ufoHandler("ndxlMN.html.txt");
		Import.ufoHandler("ndxlMO.html.txt");
		Import.ufoHandler("ndxlMS.html.txt");		
		Import.ufoHandler("ndxlMT.html.txt");
		Import.ufoHandler("ndxlNB.html.txt");
		Import.ufoHandler("ndxlNC.html.txt");
		Import.ufoHandler("ndxlND.html.txt");
		Import.ufoHandler("ndxlNE.html.txt");
		Import.ufoHandler("ndxlNH.html.txt");
		Import.ufoHandler("ndxlNJ.html.txt");
		Import.ufoHandler("ndxlNM.html.txt");
		Import.ufoHandler("ndxlNV.html.txt");
		Import.ufoHandler("ndxlNY.html.txt");
		Import.ufoHandler("ndxlOH.html.txt");
		Import.ufoHandler("ndxlOK.html.txt");
		Import.ufoHandler("ndxlOR.html.txt");
		Import.ufoHandler("ndxlPA.html.txt");
		Import.ufoHandler("ndxlRI.html.txt");
		Import.ufoHandler("ndxlSC.html.txt");
		Import.ufoHandler("ndxlSD.html.txt");
		Import.ufoHandler("ndxlTN.html.txt");
		Import.ufoHandler("ndxlTX.html.txt");
		Import.ufoHandler("ndxlUT.html.txt");
		Import.ufoHandler("ndxlVA.html.txt");
		Import.ufoHandler("ndxlVI.html.txt");
		Import.ufoHandler("ndxlVT.html.txt");
		Import.ufoHandler("ndxlWA.html.txt");
		Import.ufoHandler("ndxlWI.html.txt");
		Import.ufoHandler("ndxlWV.html.txt");
		Import.ufoHandler("ndxlWY.html.txt");*/
		// others would be "new Microsoft.HybridProvider()" or "new Microsoft.AerialProvider()"
		// the Google ones get blocked after a few hundred tiles
		// the Yahoo ones look terrible because they're not 256px squares :)

		// set the initial location and zoom level to London:
		map.setCenterZoom(new Location(34.04f, -100.69f), 4);
		// zoom 0 is the whole world, 19 is street level
		// (try some out, or use getlatlon.com to search for more)

		// set a default font for labels
		font = createFont("Helvetica", 12);

		// enable the mouse wheel, for zooming
		addMouseWheelListener(new java.awt.event.MouseWheelListener() { 
			public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) { 
				mouseWheel(evt.getWheelRotation());
			}
		}
		);



	}

	public void draw() {
		Utils.globalProcessing.background(0);
		//if(true){
		//  ParallelGraph.draw(Utils.allSightings);
		//  return;
		//}
		// draw the map:
		map.draw();
		// (that's it! really... everything else is interactions now)

		//Utils.globalProcessing.smooth();

		
		//TODO draw airport only after a certain zoomLevel, otherwise we'll be submerged my annoying triangles
		/*for(Airport a: Utils.allAirports)
			a.draw();*/
		/*for(MilitaryBase mb: Utils.allBases)
			mb.draw();
		*/
		for(WeatherStation w: Utils.allWeatherStations)
			w.draw();
		
		/*int min = Utils.allSightings.get(0).getNumOfSightings();
		int max = Utils.allSightings.get(0).getNumOfSightings();
		for(Sighting s: Utils.allSightings){
			if(s.getNumOfSightings()>max)
				max = s.getNumOfSightings();
			else if(s.getNumOfSightings()<min)
				min = s.getNumOfSightings();
		}
		
		for(int i = 0; i < Utils.allSightings.size(); i++){
			Sighting s = Utils.allSightings.get(i);
			s.draw(min, max);
			//System.out.println(p.x);
		}*/
		
		
		
		
		theScroll.drawContent();
		theMenu.drawContent();
		// draw all the buttons and check for mouse-over
		boolean hand = false;
		if (gui) {
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].draw();
				hand = hand || buttons[i].mouseOver();
			}
		}



		// if we're over a button, use the finger pointer
		// otherwise use the cross
		// (I wish Java had the open/closed hand for "move" cursors)
		cursor(hand ? HAND : CROSS);

		// see if the arrow keys or +/- keys are pressed:
		// (also check space and z, to reset or round zoom levels)
		if (keyPressed) {
			if (key == CODED) {
				if (keyCode == LEFT) {
					map.tx += 5.0/map.sc;
				}
				else if (keyCode == RIGHT) {
					map.tx -= 5.0/map.sc;
				}
				else if (keyCode == UP) {
					map.ty += 5.0/map.sc;
				}
				else if (keyCode == DOWN) {
					map.ty -= 5.0/map.sc;
				}
			}  
			else if (key == '+' || key == '=') {
				map.sc *= 1.05;
			}
			else if (key == '_' || key == '-' && map.sc > 2) {
				map.sc *= 1.0/1.05;
			}
		}

		if (gui) {
			textFont(font, 12);

			// grab the lat/lon location under the mouse point:
			Location location = map.pointLocation(mouseX, mouseY);

			// draw the mouse location, bottom left:
			Utils.globalProcessing.fill(0);
			Utils.globalProcessing.noStroke();
			Utils.globalProcessing.rect(5, height-5-g.textSize, textWidth("mouse: " + location), g.textSize+textDescent());
			Utils.globalProcessing.fill(255,255,0);
			Utils.globalProcessing.textAlign(LEFT, BOTTOM);
			Utils.globalProcessing.text("mouse: " + location, 5, height-5);

			// grab the center
			location = map.pointLocation(width/2, height/2);

			// draw the center location, bottom right:
			Utils.globalProcessing.fill(0);
			Utils.globalProcessing.noStroke();
			float rw = textWidth("map: " + location);
			Utils.globalProcessing.rect(width-5-rw, height-5-g.textSize, rw, g.textSize+textDescent());
			Utils.globalProcessing.fill(255,255,0);
			Utils.globalProcessing.textAlign(RIGHT, BOTTOM);
			Utils.globalProcessing.text("map: " + location, width-5, height-5);

			/*
	    location = new Location(51.500, -0.126);
	    Point2f p = map.locationPoint(location);

	    fill(0,255,128);
	    stroke(255,255,0);
	    ellipse(p.x, p.y, 10, 10); */
			
		}  

		//println((float)map.sc);
		//println((float)map.tx + " " + (float)map.ty);
		//println();

	}

	public void keyReleased() {
		if (key == 'g' || key == 'G') {
			gui = !gui;
		}
		else if (key == 's' || key == 'S') {
			Utils.globalProcessing.save("modest-maps-app.png");
		}
		else if (key == 'z' || key == 'Z') {
			map.sc = pow(2, map.getZoom());
		}
		else if (key == ' ') {
			map.sc = 2.0;
			map.tx = -128;
			map.ty = -128; 
		}
	}


	// see if we're over any buttons, otherwise tell the map to drag
	public void mouseDragged() {
		boolean hand = false;
		if (gui) {
			for (int i = 0; i < buttons.length; i++) {
				hand = hand || buttons[i].mouseOver();
				if (hand) break;
			}
		}
		if (!hand) {
			map.mouseDragged(); 
		}
	}

	// zoom in or out:
	public void mouseWheel(int delta) {

		if (delta > 0) {
			map.sc *= 1.05;
		}
		else if (delta < 0) {
			map.sc *= 1.0/1.05; 
		}
	
	}

	// see if we're over any buttons, and respond accordingly:
	public void mouseClicked() {
		if (in.mouseOver()) {
			map.zoomIn();
		}
		else if (out.mouseOver()) {
			map.zoomOut();
		}
		else if (up.mouseOver()) {
			map.panUp();
		}
		else if (down.mouseOver()) {
			map.panDown();
		}
		else if (left.mouseOver()) {
			map.panLeft();
		}
		else if (right.mouseOver()) {
			map.panRight();
		}
	}
	/*	

	public void setup() {
		Utils.globalProcessing = this;
		size(200,200);

		background(0);
	}

	public void draw() {
		stroke(255);
		ArrayList<Sighting> dataToPlot = Test.mockData();

		if (mousePressed) {
			line(mouseX,mouseY,pmouseX,pmouseY);
		}
	}

	 */


	public static void main(String [] args) {
		PApplet.main(new String[] { "--present", "MainSketch" });
	}



}
