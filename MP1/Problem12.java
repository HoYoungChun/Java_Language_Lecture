package cse3040_mp1_20191656;

class SubsequenceChecker{
	public static void check(String inStr, String fStr) {
		boolean isit = false;
		int findex[] = new int[inStr.length()];//0으로 초기화
		int i = 0;
		int j = 0;
		
		for(i= 0; i<inStr.length(); i++) {
			if(inStr.charAt(i) == fStr.charAt(j)) {
				findex[i] = 1;
				j++;
			}
			if(j == fStr.length()) {
				break;
			}
		}

		if(j == fStr.length()) {
			isit = true;
		}
		
		if(isit == false) {
			System.out.println(fStr +" is not a subsequence of "+inStr);
		}
		else {
			System.out.println(fStr +" is a subsequence of "+inStr);
			for(i = 0; i<inStr.length(); i++) {
				if(findex[i] == 1)
					System.out.print(i+" ");
			}
			System.out.print("\n");
		}
	}
}

public class Problem12 {
	public static void main(String[] args) {
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "pads");
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "padsx");
	}
}
