package cse3040ex06;

public class EX06_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];
		int b[] = new int[10];
		int i;
		
		for(i = 0; i<5; i++) {
			a[i]=(i+1)*10+1;
			b[i]=(i+1)*100+5;
		}
		
		for(i = 0; i<15; i++)
			System.out.println(a[i]+" "+b[i]);
		//Array index out of range
	}

}
