package cse3040_mp2_20191656;

import java.util.ArrayList;
import java.util.Collections;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class BookInfo implements Comparable<BookInfo>{
	private int rank;
	private String title;
	private String authors;
	private String price;
	public void setrank(int r) {
		this.rank=r;
	}
	public void settitle(String s) {
		this.title=s;
	}
	public void setauthors(String s) {
		this.authors=s;
	}
	public void setprice(String s) {
		this.price=s;
	}
	public int getrank() {
		return this.rank;
	}
	public String gettitle() {
		return this.title;
	}
	public String getauthors() {
		return this.authors;
	}
	public String getprice() {
		return this.price;
	}
	public int compareTo(BookInfo e) {
		if(this.rank > e.getrank()) return -1;
		else return 1;
	}
	public String toString() {
		return "#"+this.rank+" "+this.title+ ", "+this.authors+", "+this.price;

	}
}

class BookReader{
	private static ArrayList<BookInfo> books = new ArrayList<BookInfo>();
	public static ArrayList<BookInfo> readBooksJsoup(String inurl){
		Document doc = null;
		try {
			doc = Jsoup.connect(inurl).get();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		BookInfo b=new BookInfo();
		
		Elements title1 = doc.select("div");
		Elements title2 = title1.select("h3");
		Elements title = title2.select("a");
		
		Elements author1 = doc.select("div.product-shelf-author");
		Elements author = author1.select("a");
		
		
		Elements price1 = doc.select("span.current");
		Elements price = price1.select("a.current");
		
		for(int i=0;i<=19;i++) {
			b.setrank(i+1);
			b.settitle(title.eq(i).text());
			b.setauthors(author.eq(i).text());
			b.setprice(price.eq(i).text());
			books.add(b);
			b=new BookInfo();
		}
		
		return books;
	}
}

public class Problem20 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooksJsoup("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for(int i=0; i<books.size(); i++) { 
			BookInfo book = books.get(i); 
			System.out.println(book);
		}
		
	}
}
