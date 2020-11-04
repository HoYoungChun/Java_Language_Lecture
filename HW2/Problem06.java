package cse3040_hw2_20191656;

interface IntSequence{
	public abstract boolean hasNext();
	public abstract int next();
}

class FibonacciSequence implements IntSequence{
	private int number = 0;
	private int n1 = 1;
	private int n2 = 2;
	public boolean hasNext() { return true; }
	public int next() {
		if(number == 0) {
			number++;
			return 0;
		}
		else if(number == 1) {
			number++;
			return 1;
		}
		else {
			number++;
			int out=n1;
			int temp =n1 + n2;
			n1 = n2;
			n2 = temp;
			return out;
		}
	}
}

public class Problem06 {
	public static void main(String[] args) {
		IntSequence seq = new FibonacciSequence();
		for(int i=0; i<20; i++) {
			if(seq.hasNext() == false) break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}
