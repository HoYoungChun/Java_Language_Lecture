package cse3040_hw1_20191656;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ASCII code teller. Enter a letter: ");
		String name = sc.nextLine();
		if(name.length() != 1) {
			System.out.print("You must input a single uppercase or lowercase alphabet.");
		}
		else {
			char ch = name.charAt(0);
			int ich = (int)ch;
			if(ich>= 65 && ich<= 90)
				System.out.print("The ASCII code of "+ch+" is "+ich+".");
			else if(ich >= 97 && ich <= 122)
				System.out.print("The ASCII code of "+ch+" is "+ich+".");
			else
				System.out.print("You must input a single uppercase or lowercase alphabet.");
		}
		sc.close();

	}

}
