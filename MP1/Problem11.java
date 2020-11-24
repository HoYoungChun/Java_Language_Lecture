package cse3040_mp1_20191656;

class PalindromeChecker{
	public static void check(int inint) {
		String to = Integer.toString(inint);
		PalindromeChecker.check(to);	
	}
	
	public static void check(String instr) {
		String fstr = instr;
		boolean isit = true;
		int length = fstr.length();
		int f_index = length-1;
		for(int i = 0; i<=(length-1)/2; i++) {
			if(fstr.charAt(i) != fstr.charAt(f_index - i)) {
				isit = false;
				break;
			}
		}
		
		if(isit == true)
			System.out.println(fstr+" is a palindrome.");
		else
			System.out.println(fstr+" is not a palindrome.");
	}
}

public class Problem11 { 
	public static void main(String[] args) { 
		PalindromeChecker.check("abcde"); 
		PalindromeChecker.check("abcba"); 
		PalindromeChecker.check(1234); 
		PalindromeChecker.check(12321); 
	} 
}