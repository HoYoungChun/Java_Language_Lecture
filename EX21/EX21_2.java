package cse3040ex21;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class EX21_2 {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {
			ip=InetAddress.getByName("www.naver.com");
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress(): "+Arrays.toString(ipAddr));
			
			String result="";
			for(int i=0; i<ipAddr.length;i++) {
				result += (ipAddr[i]<0) ? ipAddr[i]+256 : ipAddr[i];
				result+=".";
			}
			System.out.println("dotted decimal: "+result);
			System.out.println();
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
