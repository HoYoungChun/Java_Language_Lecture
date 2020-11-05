package cse3040ex13;

public class EX13_3 {
	public static void main(String[] args) {
		method1();
	}
	static void method1() {
		try {
			method2();
		}catch(Exception e) {
			System.out.println("method handled at method1");
		}
	}
	static void method2() throws Exception{
		throw new Exception();
	}
}
