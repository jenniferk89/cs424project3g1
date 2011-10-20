package control;

import java.util.*;

public class Test {
	public static ArrayList<Sighting> mockData(){
		ArrayList<Sighting> results = new ArrayList<Sighting>();
		Location chicago = new City("Chicago", 41.97947, -87.90423);
		Location newYork = new City("New York", 40.7644,	-73.9808);
		Location washington = new City("Washington", 47.00013,	-120.54229);
		Location losAngeles = new City("Los Angeles", 34.03446,	-118.15757);
		GregorianCalendar date1 = new GregorianCalendar();
		GregorianCalendar date2 = new GregorianCalendar();
		GregorianCalendar date3 = new GregorianCalendar();
		GregorianCalendar date4 = new GregorianCalendar();
		GregorianCalendar date5 = new GregorianCalendar();
		GregorianCalendar date6 = new GregorianCalendar();
		GregorianCalendar date7 = new GregorianCalendar();
		GregorianCalendar date8 = new GregorianCalendar();
		date2.set(Calendar.HOUR_OF_DAY, date2.get(Calendar.HOUR_OF_DAY) + 1); //set calendar one hour after 
		date3.set(Calendar.HOUR_OF_DAY, date3.get(Calendar.HOUR_OF_DAY) - 1);
		date4.set(Calendar.HOUR_OF_DAY, date3.get(Calendar.HOUR_OF_DAY) + 3);
		date5.set(Calendar.DAY_OF_MONTH, date5.get(Calendar.DAY_OF_MONTH) - 12);
		date6.set(Calendar.MINUTE, date5.get(Calendar.MINUTE) + 45);
		date7.set(Calendar.HOUR_OF_DAY, date1.get(Calendar.HOUR_OF_DAY) - 36);
		date8.set(Calendar.HOUR_OF_DAY, date1.get(Calendar.HOUR_OF_DAY) - 1);
		Time t1 = new Time(date1);
		t1.setEndTime(date2);
		Time t2 = new Time(date1);
		t2.setEndTime(date2);
		Time t3 = new Time(date1);
		t3.setEndTime(date2);
		Time t4 = new Time(date1);
		t4.setEndTime(date2);
		Shape cigar = new Shape("Cigar");
		Shape triangle = new Shape("Triangle");
		Shape oval = new Shape("Oval");
		Shape sphere = new Shape("Sphere");
		Sighting s1 = new Sighting(t1, chicago, cigar, "A group of cigars standing in the sky", 1);
		Sighting s2 = new Sighting(t2, newYork, triangle, "A triangle shaped light flying here and there", 1);
		Sighting s3 = new Sighting(t3, washington, oval, "An oval standing still", 1);
		Sighting s4 = new Sighting(t4, losAngeles, sphere, "A strange sphere", 5);
		results.add(s1);
		results.add(s2);
		results.add(s3);
		results.add(s4);
		return results;
		
	}
}
