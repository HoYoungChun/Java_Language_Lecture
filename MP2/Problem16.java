package cse3040_mp2_20191656;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


class Element implements Comparable<Element>{
	private String name=null;
	private double price=0;
	public Element(String name, double price) {
		this.name=name;
		this.price=price;
	}
	public double getprice() {
		return this.price;
	}
	public String getname() {
		return this.name;
	}
	public int compareTo(Element e) {
		if(this.price > e.getprice()) return 1;
		if(this.price < e.getprice()) return -1;
		return this.name.compareTo(e.getname());
	}
	public String toString() {
		return this.name+" "+this.price;
	}
	
}

class ElementReader{
	static private ArrayList<Element> list = new ArrayList<>();
	static public ArrayList<Element> readElements(String str){
		try {
	         File file = new File(str);
	         Scanner scanner = new Scanner(file);
	        while (scanner.hasNext()) {
	        	String s= scanner.next();
	        	double d =scanner.nextDouble();
	        	list.add(new Element(s,d));
	         }
	         scanner.close();
	         return list;
	       } catch (Exception e) {
	    	   return null;
	       }
	}
}

public class Problem16 { 
	public static void main(String args[]) { 
		ArrayList<Element> list = ElementReader.readElements("input.txt"); 
		if(list == null) { 
			System.out.println("Input file not found.");
			return;
		} 
		Collections.sort(list); 
		Iterator<Element> it = list.iterator(); 
		while(it.hasNext()) System.out.println(it.next()); 
	} 
}

