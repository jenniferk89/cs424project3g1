package GUI;

import processing.core.PApplet;

public class MainSketch extends PApplet{



	public void setup() {
		Utils.globalProcessing = this;
		size(200,200);
		
		background(0);
	}

	public void draw() {
		stroke(255);
		if (mousePressed) {
			line(mouseX,mouseY,pmouseX,pmouseY);
		}
	}




	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "MainSketch" });
	}



}
