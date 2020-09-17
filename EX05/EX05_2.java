package cse3040ex05;

import java.util.Scanner;
public class EX05_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = in.nextLine();
		String message = String.format("Hello %s!", name);
		System.out.println(message);
		in.close();
	}

}
