package cse3040ex12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class EX12_4 {
	public static void main(String[] args) throws IOException {
		byte b [] = new byte[100];
		FileInputStream input = new FileInputStream("src/cse3040ex12/myFile1.txt");
		while(true) {
			int rv = input.read(b);
			if(rv == -1) break;
			System.out.print(new String(b).substring(0,rv));
		}
		input.close();
		
		BufferedReader br = new BufferedReader(new FileReader("src/cse3040ex12/myFile1.txt"));
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			System.out.println(line);
		}
		br.close();
	}
}
