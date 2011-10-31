package GUI;

public class HBar {
    
	float h;
    float w;	
    float x;
    float y;
    
    float newX1, newY1, newX2, newY2;
    
	  HBar(float x_, float y_, float w_, float h_)
	  {
		  x = x_;
		  y = y_;
		  w = w_;
		  h = h_;
		  newX1 = x;
		  newX2 = x + w - 14;

	  }

	  public void drawContent()
	  {
	    Utils.globalProcessing.noFill();
	    Utils.globalProcessing.stroke(0);
	    Utils.globalProcessing.fill(128,128,128,128);
	    Utils.globalProcessing.rect(x, y, w, h);
	    Utils.globalProcessing.fill(224,224,224,192);
	    Utils.globalProcessing.rect(newX1, y, 14, h);
	    Utils.globalProcessing.rect(newX2, y, 14, h);
	  }
	  
	  public boolean mousePressed(float lx, float ly)
	  {
	    if((ly <= x) && (ly >= x+w)){
	    	Utils.globalProcessing.println("Yep");
	    	
	    
	    }
	    return true;
	  }
	  
	  boolean contentDragged(float lx, float ly)
	  {
	    
	    if((ly <= h -7) && (ly >= 7)){
	    }
	    
	  return true;
	  }
	}
