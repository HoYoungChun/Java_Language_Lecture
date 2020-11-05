package cse3040ex12;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EX12_3 {
	public static void main(String[] args) throws IOException {
		String str = "Hello, my name is Harry Potter.\nI am a student in the Java Language class.\nI am trying to write this text to a file.\nThank you.\n";
		System.out.println(str);
		
		FileOutputStream output = new FileOutputStream("src/cse3040ex12/myFile1.txt");
		byte[] bytes = str.getBytes();
		output.write(bytes);
		output.close();
		
		FileWriter fw = new FileWriter("src/cse3040ex12/myFile2.txt");
		fw.write(str);
		fw.close();
		
		PrintWriter pw = new PrintWriter("src/cse3040ex12/myFile3.txt");
		pw.print(str);
		pw.close();
	}
}
