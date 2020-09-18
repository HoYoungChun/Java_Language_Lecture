package cse3040ex06;

public class EX06_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = new int[3];
		double d[] = new double[3];
		boolean b[] = new boolean[3];
		String s[] = new String[3];
		
		n[2] = 100;
		d[2] = 1.23;
		b[2] = true;
		s[2] = "Java Jaba";
		
		System.out.println("int\tdouble\tboolean\tString");
		for(int i = 0; i<3; i++)
			System.out.println(" "+n[i]+'\t'+d[i]+'\t'+b[i]+'\t'+s[i]);
	}

}
