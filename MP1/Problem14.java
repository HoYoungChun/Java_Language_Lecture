package cse3040_mp1_20191656;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Fruit{
	private String name;
	private double price;
	public Fruit(String s, double d){
		this.name=s;
		this.price=d;
	}
	public String getname() {
		return name;
	}
	public double getprice() {
		return this.price;
	}
}

class FruitBox<T>{
	private static double sum = 0;
	private static int itemNum = 0;
	private static String maxItem = null;
	private static double maxPrice = 0;
	private static String minItem = null;
	private static double minPrice = 100000000;
	public void add(Fruit nf) {
		System.out.print(nf.getname()+ " ");
    	System.out.println(nf.getprice());
		if(nf.getprice() > maxPrice) {
			maxItem=nf.getname();
			maxPrice=nf.getprice();
		}
		if(nf.getprice() < minPrice) {
			minItem=nf.getname();
			minPrice=nf.getprice();
		}
		itemNum++;
		sum+=nf.getprice();
	}
	public int getNumItems() {
		return itemNum;
	}
	public String getMaxItem() {
		return maxItem;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public String getMinItem() {
		return minItem;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public double getAvgPrice() {
		return sum/itemNum;
	}
}

class ItemReader{
	public static boolean fileToBox(String str, FruitBox<Fruit> f) {
		 try {
	         File file = new File(str);
	         Scanner scanner = new Scanner(file);
	        while (scanner.hasNext()) {
	        	String s= scanner.next();
	        	double d =scanner.nextDouble();
	        	f.add(new Fruit(s,d));
	         }
	         scanner.close();
	         return true;
	       } catch (FileNotFoundException e) {
	    	   System.out.println("Input file not found.");
	    	   return false;
	       } catch(Exception e) {
	    	   e.printStackTrace();
	    	   return false;
	       }
	}
}

public class Problem14 {
	public static void main(String[] args) {
		FruitBox<Fruit> box = new FruitBox<>();
		boolean rv = ItemReader.fileToBox("input_prob14.txt", box);
		if(rv == false) return;
		box.add(new Fruit("orange", 9.99));
		System.out.println("----------------");
		System.out.println("    Summary");
		System.out.println("----------------");
		System.out.println("number of items: " + box.getNumItems());
		System.out.println("most expensive item: " + box.getMaxItem() + " (" +
							box.getMaxPrice() + ")");
		System.out.println("cheapest item: " + box.getMinItem() + " (" +
							box.getMinPrice() + ")");
		System.out.printf("average price of items: %.2f", box.getAvgPrice());}
}
