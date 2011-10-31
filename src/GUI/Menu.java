package GUI;


import GUI.Utils;
import processing.core.PFont;

public class Menu {

		float width;
		PFont font = Utils.globalProcessing.loadFont("Helvetica-Light-14.vlw"); 		
		 Button buttonLight = new Button (20,150,30,30,"Light");
		 Button buttonRound = new Button (20,190,30,30,"Round");
		 Button buttonArrow = new Button (20,230,30,30,"Arrow");
		 Button buttonPolygon = new Button (20,270,30,30,"Polygon");
		 Button buttonFormation = new Button (20,310,30,30,"Formation");
		 Button buttonChanging = new Button (20,350,30,30,"Changing");
		 Button buttonOther = new Button (20,390,30,30,"Other");
		 Button buttonGraph = new Button (20,450,30,30);
		 
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
			Utils.globalProcessing.text("Round",180, 210);
			buttonArrow.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Arrow",180, 250);
			buttonPolygon.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Polygon",180, 290);
			buttonFormation.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Formation",180, 330);
			buttonChanging.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Changing",180, 370);
			buttonGraph.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Other",180, 410);
			buttonOther.draw();
			Utils.globalProcessing.fill(255,255,255);
			Utils.globalProcessing.text("Graph",180, 470);
			
			
			Utils.globalProcessing.textFont(font, 14);
		    Utils.globalProcessing.fill(255,255,255);
		    Utils.globalProcessing.text("UFO Sightings 2001-2010",180, 100);
		    
		  }
		  


}
