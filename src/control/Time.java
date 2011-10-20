package control;

import java.util.GregorianCalendar;

public class Time {
	private GregorianCalendar beginTime;
	private GregorianCalendar endTime;
	
	
	public Time(GregorianCalendar beginTime) {
		super();
		this.beginTime = beginTime;
		this.endTime = beginTime;
	}


	public GregorianCalendar getEndTime() {
		return endTime;
	}


	public void setEndTime(GregorianCalendar endTime) {
		this.endTime = endTime;
	}


	public GregorianCalendar getBeginTime() {
		return beginTime;
	}
	
	
	
	
	
}
