package cse3040_hw1_20191656;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a text: ");
		String text = sc.nextLine();
		String string;
		
		int count = 0;
		while(true) {
			System.out.print("Enter a string: ");
			string = sc.nextLine();
			if(string.length() == 0) {
				System.out.println("You must enter a string.");
			}
			else {
				break;
			}
		}
		
		for(int i = 0; i<text.length()-string.length()+1;i++) {
			int resist = 0;
			for(int j = 0; j<string.length(); j++)
				if(text.charAt(i+j) != string.charAt(j)) {
					resist=1;
			}
			if(resist == 0)
				count++;
		}
		
		System.out.print("There are "+count+" instances of \""+string+"\".");
		
		sc.close();

	}

}
