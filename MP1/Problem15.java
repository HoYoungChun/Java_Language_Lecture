package cse3040_mp1_20191656;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Item{
	private String s;
	private int snum=0;
	public String toString() {
		return this.s+" "+this.snum;
	}
	public Item(String s) {
		this.s = s;
		this.snum++;
	}
	public String gets() {
		return this.s;
	}
	public void plusnum() {
		this.snum++;
	}
}

class MyFileReader{
	static boolean readDataFromFile(String str,ArrayList<Item> list) {
		try {
	        File file = new File(str);
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNext()) {
	        	String s= scanner.next();
	        	s=s.toLowerCase();
	        	int resist=0;
	        	for(Item it: list) {
	        		if(it.gets().equals(s)) {
	        			it.plusnum();
	        			resist=1;
	        			break;
	        		}
	        	}
	        	if(resist==0)
	        		list.add(new Item(s));
	         }
	         scanner.close();
	         return true;
	       } catch (FileNotFoundException e) {
	    	   return false;
	       } catch(Exception e) {
	    	   e.printStackTrace();
	    	   return false;
	       }
	}
}

public class Problem15 {
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
		boolean rv = MyFileReader.readDataFromFile("input_prob15.txt", list);
		if(rv == false) {
			System.out.println("Input file not found.");
			return;
		}
		for(Item it: list) System.out.println(it);
	}
}
