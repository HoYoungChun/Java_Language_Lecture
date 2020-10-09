package cse3040ex10;

interface CustomerInterface{
	public abstract void method1();
	default void method2() {
		method4();
		method5();
		System.out.println("default method");
	}
	static void method3() {
		method5();
		System.out.println("static method");
	}
	private void method4() { System.out.println("private method");}
	private static void method5() { System.out.println("private static method");}
	
}

public class EX10_2 implements CustomerInterface{
	public void method1() { System.out.println("abstract method");}
	
	public static void main(String[] args) {
		CustomerInterface instance = new EX10_2();
		instance.method1();
		instance.method2();
		CustomerInterface.method3();

	}

}
