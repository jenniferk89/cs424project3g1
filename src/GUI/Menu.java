package GUI;


import GUI.Utils;
import processing.core.PFont;

public class Menu {

		float width;
		PFont font = Utils.globalProcessing.loadFont("Helvetica-Light-14.vlw"); 		
		 Button buttonLight = new Button (20,150,40,40,"Light");
		 Button buttonRound = new Button (20,200,40,40,"Round");
		 Button buttonArrow = new Button (20,250,40,40,"Arrow");
		 Button buttonPolygon = new Button (20,300,40,40,"Polygon");
		 Button buttonFormation = new Button (20,350,40,40,"Formation");
		 Button buttonChanging = new Button (20,400,40,40,"Changing");
		 Button buttonGraph = new Button (20,450,40,40);
		 
		  Menu(float w)
		  {
			 width = w;
		  }

		  public void drawContent()
		  { 
			Utils.globalProcessing.noFill();
			Utils.globalProcessing.stroke(0);
			Utils.globalProcessing.fill(0,0,0,128);
			Utils.globalProcessing.rect(0, 0, width, 768);
			buttonLight.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Light",180, 170);
			buttonRound.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Round",180, 220);
			buttonArrow.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Arrow",180, 270);
			buttonPolygon.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Polygon",180, 320);
			buttonFormation.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Formation",180, 370);
			buttonChanging.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Changing",180, 420);
			buttonGraph.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Graph",180, 470);
			Utils.globalProcessing.textFont(font, 14);
		    Utils.globalProcessing.fill(255,255,255);
		    Utils.globalProcessing.text("UFO Sightings 2001-2010",180, 100);
		    
		  }
		  


}
