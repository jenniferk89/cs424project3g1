package GUI;

public class HBar {
    
	float h;
    float w;	
    float x;
    float y;
    
	  HBar(float x_, float y_, float w_, float h_)
	  {
		  x = x_;
		  y = y_;
		  w = w_;
		  h = h_;

	  }

	  public void drawContent()
	  {
	    Utils.globalProcessing.noFill();
	    Utils.globalProcessing.stroke(0);
	    Utils.globalProcessing.fill(255);
	    Utils.globalProcessing.rect(x, y, h, w);
	    Utils.globalProcessing.fill(128);
	    Utils.globalProcessing.rect(x, y, h, w);
	  }
	  
	  public boolean contentPressed(float lx, float ly)
	  {
	    if((ly <= h -7) && (ly >= 7)){
	    
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
