package cse3040ex24;

import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			Socket socket = new Socket(serverIp,7777);
			System.out.println("connected to server.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
