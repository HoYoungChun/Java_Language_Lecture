package cse3040ex06;

public class EX06_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {10,11,12}, {20,21,22}, {30,31,32}, {40,41,42} };
		int i,j,hab;
		
		System.out.println("a.length: " + a.length);
		System.out.println("a[0].length: " + a[0].length + '\n');
		
		for(i = 0; i<a.length; i++) {
			hab = 0;
			for(j=0; j<a[0].length;j++) {
				System.out.print(a[i][j] + " ");
				hab += a[i][j];
			}
			System.out.print(" "+hab+"\n");
		}

	}

}
