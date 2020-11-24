package cse3040_mp1_20191656;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class Text{
	private BufferedReader br;
	private int count;
	private String route;

	public boolean readTextFromFile(String in){
		try {
			route = in;
			br = new BufferedReader(new FileReader(in));
			return true;
		} catch(FileNotFoundException e) {
			System.out.println("Input file not found.");
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int countChar(char c) {
		try {
			br = new BufferedReader(new FileReader(route));
			count = 0;
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				for(int i=0; i<line.length();i++) {
					if(line.charAt(i) == c ||line.charAt(i) == c-32)
						count++;
				}
			}
			return count;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}

public class Problem13 {
	public static void main(String[] args) {
		Text t = new Text();
		if(t.readTextFromFile("input_prob13.txt")) {
			for(char c = 'a'; c <= 'z'; c++) {
				System.out.println(c + ": " + t.countChar(c));
			}
		}
	}
}