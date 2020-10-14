package cse3040_hw1_20191656;

import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a text: ");
		String text = sc.nextLine();
		String letter;
		
		int count = 0;
		while(true) {
			System.out.print("Enter a letter: ");
			letter = sc.nextLine();
			if(letter.length() != 1) {
				System.out.println("You must enter a single letter.");
			}
			else {
				break;
			}
		}
		
		for(int i = 0; i<text.length();i++) {
			if(text.charAt(i) == letter.charAt(0)) {
				count++;
			}
		}
		
		System.out.print("There are "+count+" "+letter.charAt(0)+"'s in the text.");
		
		sc.close();
	}

}
