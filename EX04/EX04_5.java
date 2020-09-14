package cse3040ex04;

public class EX04_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "JavaJAVA";
		int n = s.length();
		System.out.println("length of String s: " + n);
		System.out.println();
		
		for(int i = 1; i<=n; i++)
			System.out.println(s.substring(0,i));
		
		System.out.println();
		System.out.println(s.substring(2,4));
		System.out.println(s.substring(2));
	}

}
