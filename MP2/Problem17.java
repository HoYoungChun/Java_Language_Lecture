package cse3040_mp2_20191656;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class MapManager{
	static private Map<String, Double> map = new treeMap<>();
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

class treeMap<String, Double> extends TreeMap<String, Double>{
	private java.lang.String str1="";
	public java.lang.String toString() {
		Set<Map.Entry<String,Double>> set = this.entrySet();
		Iterator<Map.Entry<String,Double>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String,Double> e = (Map.Entry<String,Double>)it.next();
			java.lang.String str2 = (e.getKey()+ " " + e.getValue()+"\n");
			str1 = str1 + str2;
		}
		return str1;
	}
}

public class Problem17 { 
	public static void main(String args[]) { 
		Map<String, Double> map = MapManager.readData("input.txt"); 
		if(map == null) { 
			System.out.println("Input file not found."); 
			return; 
		} 
		System.out.println(map); 
	} 
}
