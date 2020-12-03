package cse3040ex23;

import javax.swing.JOptionPane;

public class EX23_6 {
	public static void main(String[] args) {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("Enter any String.");
		System.out.println("You have entered: "+input);
		
	}
}

class ThreadEx7_1 extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch(Exception e) {}
		}
	}
}
