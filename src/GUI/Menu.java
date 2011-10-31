package GUI;

import GUI.Utils;
import processing.core.PFont;

public class Menu {

		float width;
		PFont font = Utils.globalProcessing.loadFont("Helvetica-Light-14.vlw"); 		

		  Menu(float w)
		  {
			 width = w;

		  }

		  public void drawContent()
		  { 
			Utils.globalProcessing.textFont(font, 14);
		    Utils.globalProcessing.noFill();
		    Utils.globalProcessing.stroke(0);
		    Utils.globalProcessing.fill(0,0,0,128);
		    Utils.globalProcessing.rect(0, 0, width, 768);
		    Utils.globalProcessing.fill(255,255,255);
		    Utils.globalProcessing.text("UFO Sightings 2001-2010",180, 100);
		    
		  }
		  


}
