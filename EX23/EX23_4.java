package cse3040ex23;

public class EX23_4 {
	static long startTime=0;

	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime=System.currentTimeMillis();
		for(int i=0;i<300;i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.print("elapse time 1: "+(System.currentTimeMillis()-EX23_4.startTime));
	}
}

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.print("elapse time 2: "+(System.currentTimeMillis()-EX23_4.startTime));
	}
}
