package cse3040ex16;

import java.util.ArrayList;
import java.util.List;

public class EX16_2 {
	public static void main(String[] args) {
		final int LIMIT =10;
		String source = "0123456789abcdefghiABCDEFGHI";
		int length=source.length();
		
		List<String>list = new ArrayList<String>(length/LIMIT + 10);
		
		for(int i = 0; i<length; i+=LIMIT) {
			if(i+LIMIT<length) list.add(source.substring(i,i+LIMIT));
			else list.add(source.substring(i));
		}
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
