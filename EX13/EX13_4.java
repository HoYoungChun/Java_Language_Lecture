package cse3040ex13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EX13_4 {
	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/cse3040ex13/myFile1.txt"));
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
			return;
		}
		
		while(true) {
			try {
				String line = br.readLine();
				if(line == null) break;
				System.out.println(line);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
