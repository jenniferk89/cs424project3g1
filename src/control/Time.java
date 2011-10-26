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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		return true;
	}
	
	
	
	
	
}
