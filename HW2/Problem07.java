package cse3040_hw2_20191656;

import java.util.Scanner;

interface IntSequenceStr{
	public abstract boolean hasNext();
	public abstract int next();
}

class BinarySequenceStr implements IntSequenceStr{
	private int findNum = 0;
	private int digit = 0;
	public BinarySequenceStr(int num) {
		findNum = num;//findNum <- input
		while(findNum >= Math.pow(2, digit)) {
			digit++;
		}
		digit--;
		//first binary number is 2^digit
	}
	
	public boolean hasNext() {
		if(digit < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int next() {
		if(findNum >= Math.pow(2, digit)) {
			findNum -= Math.pow(2,digit);
			digit--;
			return 1;
		}
		else {
			digit--;
			return 0;
		}
	}
}

public class Problem07 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		String str = in.nextLine();
		int num = Integer.parseInt(str);
		in.close();
		System.out.println("Integer: " + num);
		IntSequenceStr seq = new BinarySequenceStr(num);
		System.out.print("Binary number: ");
		while(seq.hasNext()) System.out.print(seq.next());
		System.out.println(" ");
	}
}
