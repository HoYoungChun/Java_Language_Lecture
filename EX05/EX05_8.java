package cse3040ex05;

public class EX05_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		while(true) {
			n = (int)(Math.random()*100);
			if(n == 0) break;
			if(n % 10 == 0) continue;
			System.out.println(n);
		}
	}

}
