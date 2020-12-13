package cse3040_mp2_20191656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

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
	private static ArrayList<BookInfo> books = new ArrayList<BookInfo>();;
	private static ArrayList<String>lines = new ArrayList<String>();
	public static ArrayList<BookInfo> readBooks(String inurl){
		BufferedReader input = null;
		String line="";
		try {
			URL url = new URL(inurl);
			input=new BufferedReader(new InputStreamReader(url.openStream()));
			while((line=input.readLine()) != null) {
				if(line.trim().length() > 0) lines.add(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int rank=1;
		int status=0;
		BookInfo b=new BookInfo();
		for(int i=0;i<lines.size();i++) {
			String l = lines.get(i);
			if(status == 0) {
				if(l.contains("</a><span class=\"text--small publ-date\">")) {
					int begin=l.indexOf(">") +1;
					int end=l.indexOf("</a>");
					b.settitle(l.substring(begin,end));
					b.setrank(rank);
					status=1;
				}
			}
			else if(status == 1) {
				if(l.contains("div class=\"product-shelf-author contributors\"")) {
					int j=0;
					int k=0;
					for(k=0;k<l.length();k++) {
						if(l.charAt(k)=='>')
							j++;
						if(j==2)
							break;
					}
					int begin=k + 1;
					int end=l.indexOf("</a>");
					b.setauthors(l.substring(begin,end));
					status=2;
				}
			}
			else if(status == 2) {
				if(l.contains("<a title=\"\" class=\" current link\"")) {
					int begin=l.indexOf(">") +1;
					int end=l.indexOf("</a>");
					b.setprice(l.substring(begin,end));
					rank++;
					status=0;
					books.add(b);
					b = new BookInfo();
				}
			}
			
			if(rank>20)
				break;
		}
		
		return books;
	}
}

public class Problem19 { 
	public static void main(String[] args) { 
		ArrayList<BookInfo> books;
		books = BookReader.readBooks("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books); 
		for(int i=0; i<books.size(); i++) { 
			BookInfo book = books.get(i);
			System.out.println(book);
		} 
	}
}
