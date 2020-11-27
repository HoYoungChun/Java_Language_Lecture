package cse3040ex21;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EX21_1 {
	public static void main(String[] args) {
		InetAddress ip = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
			System.out.println("toString(): "+ip.toString());
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
