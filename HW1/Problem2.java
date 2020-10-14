package cse3040_hw1_20191656;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		int i = 1;
		int start=1;
		int end = 100;
		int ans= (int)(100*Math.random()+1);
		while(true) {
			System.out.print("["+i+"]"+" Guess a number ("+start+"-"+end+"): ");
			input = sc.nextInt();
			if(input == ans) {
				System.out.print("Correct! Number of guesses: "+i);
				break;
			}
			if(input < start || input > end) {
				System.out.println("Not in range!");
				continue;
			}
			if(input < ans) {
				System.out.println("Too small!");
				start = input+1;
				
			}
			else if(input > ans) {
				System.out.println("Too large!");
				end = input-1;
			}			
			i++;
		}
		sc.close();

	}

}
