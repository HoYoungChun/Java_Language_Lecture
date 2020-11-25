package cse3040ex19;

import java.util.Set;
import java.util.TreeSet;

public class EX19_2 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		for(; set.size()<6;) {
			int num = (int)(Math.random()*45)+1;
			set.add(Integer.valueOf(num));
		}
		System.out.println(set);
		
		//List<Integer> list = new LinkedList<>(set);
		//Collections.sort(list);
		//System.out.println(list);
	}
}
