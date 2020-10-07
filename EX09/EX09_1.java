package cse3040ex09;

class SimpleSequence{
	private int number = 1;
	public boolean hasNext() { return true;}
	public int next() {
		return number++;
	}
}

class SquareSequence{
	private int number = 1;
	public boolean hasNext() { return true;}
	public int next() {
		int rv=number*number;
		number++;
		return rv;
	}
}


class DigitSequence{
	private int number;
	public DigitSequence(int n) { number = n;}
	public boolean hasNext() { return number != 0; }
	public int next() {
		int result = number % 10;
		number /= 10;
		return result;
	}
}

public class EX09_1 {

	public static double average(SimpleSequence seq, int n) {
		double sum = 0;
		int count = 0;
		while(seq.hasNext() && count < n) {
			count++;
			sum += seq.next();
		}
		if(count == 0) return 0;
		else return sum / count;
	}
	
	public static double average(SquareSequence seq, int n) {
		double sum = 0;
		int count = 0;
		while(seq.hasNext() && count < n) {
			count++;
			sum += seq.next();
		}
		if(count == 0) return 0;
		else return sum / count;
	}
	
	public static double average(DigitSequence seq, int n) {
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
		SimpleSequence seq = new SimpleSequence();
		double avg = average(seq,10);
		System.out.println("(SimpleSequence)average is "+avg);
		
		SquareSequence seq2 = new SquareSequence();
		double avg2 = average(seq2,10);
		System.out.println("(SquareSequence)average is "+avg2);

		DigitSequence seq3 = new DigitSequence(12345678);
		double avg3 = average(seq3,10);
		System.out.println("(DigitSequence)average is "+avg3);

		
	}

}
