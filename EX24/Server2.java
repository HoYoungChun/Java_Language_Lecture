package cse3040ex24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server2 implements Runnable{
	ServerSocket serverSocket;
	Thread[] threadArr;
	
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date()) + " " + name + ": ";
	}
	
	public Server2(int num) {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"server is ready");
			threadArr = new Thread[num];
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server2 server2 = new Server2(5);
		server2.start();
		
	}
	
	public void start() {
		for(int i=0;i<threadArr.length;i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println(getTime()+"waiting for clients.");
				
				Socket socket = serverSocket.accept();
				System.out.println(getTime()+"connection request from "+socket.getInetAddress());
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test Message1 from server.");
				System.out.println(getTime()+"sent message.");
				
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
