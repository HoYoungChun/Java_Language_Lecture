package cse3040_fp_20191656_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

class ClientSender extends Thread{
	Socket socket;
	DataOutputStream out;
	DataInputStream in;
	String ID;
	ClientSender(Socket socket,String ID){
		this.socket=socket;
		try {
			out=new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			this.ID=ID;
		}catch(Exception e) {}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while(true) {
				System.out.print(ID+">> ");
				String command= scanner.nextLine();
				
				if(command.equals("add")) {
					System.out.print("add-title> ");
					String title = scanner.nextLine();
					if(title.length()==0)
						continue;
					System.out.print("add-author> ");
					String author = scanner.nextLine();
					if(author.length()==0)
						continue;
					
					out.writeUTF("add");
					out.writeUTF(title);
					out.writeUTF(author);
					
					System.out.println(in.readUTF());
				}
				
				else if(command.equals("borrow")) {
					System.out.print("borrow-title> ");
					String title = scanner.nextLine();
					if(title.length()==0)
						continue;
					out.writeUTF("borrow");
					out.writeUTF(title);
					out.writeUTF(ID);
					
					System.out.println(in.readUTF());
				}
				
				else if(command.equals("return")) {
					System.out.print("return-title> ");
					String title = scanner.nextLine();
					if(title.length()==0)
						continue;
					out.writeUTF("return");
					out.writeUTF(title);
					out.writeUTF(ID);
					
					System.out.println(in.readUTF());
				}
				
				else if(command.equals("info")) {
					out.writeUTF("info");
					out.writeUTF(ID);
					int bnum=Integer.parseInt(in.readUTF());
					System.out.println(in.readUTF());
					for(int i=0; i<bnum;i++) {
						System.out.println((i+1)+". "+in.readUTF());
					}
				}
				
				else if(command.equals("search")) {
					System.out.print("search-string> ");
					String str = scanner.nextLine();
					if(str.length()==0) {
						continue;
					}
					
					while(str.length()<=2) {
						System.out.println("Search string must be longer than 2 characters.");
						System.out.print("search-string> ");
						str = scanner.nextLine();
						continue;
					}
					out.writeUTF("search");
					out.writeUTF(str);
					int bnum=Integer.parseInt(in.readUTF());
					System.out.println(in.readUTF());
					for(int i=0; i<bnum;i++) {
						System.out.println((i+1)+". "+in.readUTF());
					}
				}
				
				else {
					System.out.println("[available commands]");
					System.out.println("add: add a new book to the list of books.");
					System.out.println("borrow: borrow a book from the library.");
					System.out.println("return: return a book to the library.");
					System.out.println("info: show list of books I am currently borrowing.");
					System.out.println("search: s earch for books.");
				}
				
			}
		}catch(Exception e) { }
		
	}
}

public class Client {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.print("Please give the IP address and port number as arguments.");
			System.exit(1);
		}
		String IpAddress = args[0];
		int portNum = Integer.parseInt(args[1]);
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket(IpAddress,portNum);
			String ID;
			while(true) {
				System.out.print("Enter userID>> ");
				ID= scanner.nextLine();
				int resist=0;
				for(int i=0;i<ID.length();i++) {
					if(!((ID.charAt(i)>='0'&&ID.charAt(i)<='9')||(ID.charAt(i)>='a'&&ID.charAt(i)<='z'))) {
						resist=1;
					}
				}
				if(resist==0 && ID.length()!=0) {
					break;
				}
				else {
					System.out.println("UserID must be a single word with lowercase alphabets and numbers");
				}
			}
			System.out.println("Hello "+ID+"!");
			Thread sender = new Thread(new ClientSender(socket,ID));
			sender.start();
		}catch(Exception e) {
			System.out.print("Connection establishment failed.");
		}
		
	}
}
