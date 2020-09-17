package cse3040ex05;

public class EX05_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = (int)(400*Math.random()) - 200;
		System.out.println("random number: " + n);
		if(n>100) System.out.println("more than 100");
		else if(n >= 0) System.out.println("0 ~ 100");
		else if(n >= -100) System.out.println("-100 ~ -1");
		else System.out.println("less than -100");
	}

}
