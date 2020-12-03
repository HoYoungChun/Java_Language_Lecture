package cse3040ex23;

class ThreadEx2_1 extends Thread{
	public void throwException() {
		try {
			throw new Exception();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		throwException();
	}
}

public class EX23_2 {
	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.run();
		t1.start();
	}
}
