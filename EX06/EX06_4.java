package cse3040ex06;

public class EX06_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {11,13,15,17,19,21,23};
		int b[] = new int[a.length];//메모리 할당 필수
		int i;
		
		System.arraycopy(a, 1, b, 2, 3);
		
		for(i=0; i<a.length; i++)
			System.out.println(a[i]+" "+b[i]);
		
	}

}
