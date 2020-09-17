package cse3040ex05;

public class EX05_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Java";
		String s2 = "JAVA";
		
		if(s1 == "Java") System.out.println("same");
		else System.out.println("different");
		
		if(s1.toUpperCase() == s2) System.out.println("same");
		else System.out.println("different");
		
		String su = s1.toUpperCase();
		if(s2.equals(su)) System.out.println("same");
		else System.out.println("different");
	}

}
