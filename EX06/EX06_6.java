package cse3040ex06;

public class EX06_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[10]; 
		int nsoo,sib;
		
		for(int i = 0; i<10; i++) {
			nsoo = (int)(Math.random()*90 + 10);
			System.out.print(nsoo+ " ");
			sib = (int)(nsoo / 10);
			a[sib]++;
		}
		
		System.out.println("\n\n<random number count>");
		
		for(int i = 1; i<10; i++)
			System.out.println(i*10 +"~"+((i+1)*10-1) + " : " + a[i]);
	}

}
