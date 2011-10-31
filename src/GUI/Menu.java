package GUI;

public class Menu {

	    
		float width;
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
		    
		  }
		  


}
