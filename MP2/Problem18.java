package cse3040_mp2_20191656;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class MapManager{
	static private Map<String, Double> map = new hashMap<>();
	static public Map<String, Double> readData(String str){
		try {
	         File file = new File(str);
	         Scanner scanner = new Scanner(file);
	        while (scanner.hasNext()) {
	        	String s= scanner.next();
	        	double d =scanner.nextDouble();
	        	map.put(s,d);
	         }
	         scanner.close();
	         return map;
	       } catch (Exception e) {
	    	   return null;
	       }
	}
	
}

class ValueComparator<T> implements Comparator<T> {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
			Map.Entry<String,Double> e1 = (Map.Entry<String, Double>)o1;
			Map.Entry<String,Double> e2 = (Map.Entry<String, Double>)o2;
			double v1 = e1.getValue();
			double v2 = e2.getValue();
			if(v2>v1)
				return -1;
			else if(v2<v1)
				return 1;
			else
				return e1.getKey().compareTo(e2.getKey());
		}
		return -1;
	}
}

class hashMap<String, Double> extends HashMap<String, Double>{
	private java.lang.String str1="";
	public java.lang.String toString() {
		Set<Map.Entry<String,Double>> set = this.entrySet();
		List<Map.Entry<String,Double>> list = new ArrayList<>(set);
		Collections.sort(list, new ValueComparator<Map.Entry<String,Double>>());
		Iterator<Map.Entry<String,Double>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String,Double> e = (Map.Entry<String,Double>)it.next();
			java.lang.String str2 = (e.getKey()+ " " + e.getValue()+"\n");
			str1 = str1 + str2;
		}
		return str1;
	}
}

public class Problem18 { 
	public static void main(String args[]) { 
		Map<String, Double> map = MapManager.readData("input.txt");
		if(map == null) { 
			System.out.println("Input file not found.");
			return; 
		}
		System.out.println(map); 
	}
}
