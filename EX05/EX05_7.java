package cse3040ex05;

public class EX05_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = (int)(Math.random()*100) + 1;
		System.out.println("random number: " + n);
		System.out.println("n % 5: " + (n%5));
		switch(n % 5) {
		case 0:
			System.out.println("remainder is zero."); break;
		case 1:
			System.out.println("remainder is one."); break;
		case 2:
			System.out.println("remainder is two."); break;
		default:
			System.out.println("remainder is three or four.");

		}
	}

}
