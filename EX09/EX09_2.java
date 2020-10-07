package cse3040ex09;

interface IntSequence{
	public abstract boolean hasNext();
	public abstract int next();
}

class SimpleSequence implements IntSequence{
	private int number = 1;
	public boolean hasNext() { return true;}
	public int next() {
		return number++;
	}
}

class SquareSequence implements IntSequence{
	private int number = 1;
	public boolean hasNext() { return true;}
	public int next() {
		int rv=number*number;
		number++;
		return rv;
	}
}


class DigitSequence implements IntSequence{
	private int number;
	public DigitSequence(int n) { number = n;}
	public boolean hasNext() { return number != 0; }
	public int next() {
		int result = number % 10;
		number /= 10;
		return result;
	}
}

public class EX09_2 {

	public static double average(IntSequence seq, int n) {
		double sum = 0;
		int count = 0;
		while(seq.hasNext() && count < n) {
			count++;
			sum += seq.next();
		}
		if(count == 0) return 0;
		else return sum / count;
	}
	
	
	public static void main(String[] args) {
		IntSequence seq = new SimpleSequence();
		double avg = average(seq,10);
		System.out.println("(SimpleSequence)average is "+avg);
		
		seq = new SquareSequence();
		double avg2 = average(seq,10);
		System.out.println("(SquareSequence)average is "+avg2);

		seq = new DigitSequence(12345678);
		double avg3 = average(seq,10);
		System.out.println("(DigitSequence)average is "+avg3);

		
	}

}
