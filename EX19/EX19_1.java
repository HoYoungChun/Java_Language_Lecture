package cse3040ex19;

import java.util.HashSet;
import java.util.Set;

public class EX19_1 {
	public static void main(String[] args) {
		String[] strArr = {"1", "1", "2", "2", "3", "3", "4", "4", "4"};
		Set<String> set = new HashSet<>();
		for(int i=0; i<strArr.length;i++) {
			set.add(strArr[i]);
		}
		System.out.println(set);
	}
}
