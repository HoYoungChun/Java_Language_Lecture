package cse3040ex24;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("sample.dat");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			dis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
