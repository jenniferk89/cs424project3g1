package GUI;


import GUI.Utils;
import processing.core.PFont;

public class Menu {

		float width;
		PFont font = Utils.globalProcessing.loadFont("Helvetica-Light-14.vlw"); 		
		 Button buttonLight = new Button (20,150,40,40);
		 Button buttonRound = new Button (20,200,40,40);
		 Button buttonArrow = new Button (20,250,40,40);
		 Button buttonPolygon = new Button (20,300,40,40);
		 Button buttonFormation = new Button (20,350,40,40);
		 Button buttonChanging = new Button (20,400,40,40);
		 Button buttonGraph = new Button (20,450,40,40);
		 
		  Menu(float w)
		  {
			 width = w;
		  }

		  public void drawContent()
		  { 
			buttonLight.draw();
			Utils.globalProcessing.text("Light",180, 150);
			buttonRound.draw();
			buttonArrow.draw();
			buttonPolygon.draw();
			buttonFormation.draw();
			buttonChanging.draw();
			buttonGraph.draw();
			Utils.globalProcessing.textFont(font, 14);
		    Utils.globalProcessing.noFill();
		    Utils.globalProcessing.stroke(0);
		    Utils.globalProcessing.fill(0,0,0,128);
		    Utils.globalProcessing.rect(0, 0, width, 768);
		    Utils.globalProcessing.fill(255,255,255);
		    Utils.globalProcessing.text("UFO Sightings 2001-2010",180, 100);
		    
		  }
		  


}
