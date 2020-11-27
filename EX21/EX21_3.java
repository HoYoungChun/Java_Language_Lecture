package cse3040ex21;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EX21_3 {
	public static void main(String[] args) {
		InetAddress ip = null;
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
		} 
		catch(UnknownHostException e) {
			System.out.println("Host unknown");
			//e.printStackTrace();
		}

	}
}
