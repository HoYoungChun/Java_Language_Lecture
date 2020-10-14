package cse3040_hw1_20191656;

import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		int input = 0;
		
		System.out.println("Enter exam scores of each student.");
		
		for(int i = 0 ; i<5; i++) {
			System.out.print("Score of student "+(i+1)+": ");
			input=sc.nextInt();
			a[i]=input;
		}
		
		int firstIndex=0;
		int secondIndex=0;
		int maxIndex=0;
		int max=-1;
		
		for(int i = 0; i<5; i++) {
			if(a[i] > max) {
				maxIndex=i;
				max=a[i];
			}
		}
		firstIndex=maxIndex;
		
		max=-1;
		for(int i = 0; i<5; i++) {
			if(i != firstIndex) {
				if(a[i] > max) {
					maxIndex=i;
					max=a[i];
				}
			}
		}
		secondIndex=maxIndex;
		
		System.out.println("The 1st place is student "+(firstIndex+1)+" with "+a[firstIndex]+" points.");
		System.out.print("The 2nd place is student "+(secondIndex+1)+" with "+a[secondIndex]+" points.");

		sc.close();
	}

}
