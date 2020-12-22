package cse3040_fp_20191656;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class author_borrower{
	public String author;
	public String borrower;
	author_borrower(String a, String b){
		author=a;
		borrower=b;
	}
}

class MapManager{
	static public Map<String, author_borrower> map = new hashMap<>();
	static FileWriter fw;
	static File file;
	static public void readData(){
		try {
	         file = new File("books.txt");
	         Scanner scanner = new Scanner(file);
	        while (scanner.hasNext()) {
	        	String btitle="";
	        	String s= scanner.nextLine();
	        	int i=0;
	        	while(s.charAt(i)!='\t') {
	        		btitle+=s.charAt(i);
	        		i++;
	        	}
	        	String intitle = btitle;//title입력받기
	        	
	        	i++;
	        	btitle="";
	        	while(s.charAt(i)!='\t') {
	        		btitle+=s.charAt(i);
	        		i++;
	        	}
	        	String inauthor = btitle;//author입력받기
	        	
	        	i++;
	        	btitle="";
	        	while(i<s.length()) {
	        		btitle+=s.charAt(i);
	        		i++;
	        	}
	        	String borrower = btitle;//borrower입력받기
	        	author_borrower ab = new author_borrower(inauthor,borrower);
	        	
	        	map.put(intitle,ab);
	         }
	       } catch (Exception e) { e.printStackTrace();}
	}
	
	static public void writeData() {
		try {
		fw = new FileWriter(file,false);
		Set<Map.Entry<String,author_borrower>> set = MapManager.map.entrySet();
		List<Map.Entry<String,author_borrower>> list = new ArrayList<>(set);
		Collections.sort(list, new ValueComparator<Map.Entry<String,author_borrower>>());
		Iterator<Map.Entry<String,author_borrower>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String,author_borrower> e = (Map.Entry<String,author_borrower>)it.next();
			String s = (e.getKey()+ "\t" +MapManager.map.get(e.getKey()).author+"\t"+MapManager.map.get(e.getKey()).borrower+"\n");
			fw.write(s);
			//System.out.println(s);
			//System.out.println("write동작중");
		}
		fw.close();
		
		
		}catch(Exception e) { e.printStackTrace();}
	}
}

class ValueComparator<T> implements Comparator<T> {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
			Map.Entry<String,author_borrower> e1 = (Map.Entry<String, author_borrower>)o1;
			Map.Entry<String,author_borrower> e2 = (Map.Entry<String, author_borrower>)o2;
			String v1 = e1.getKey().toLowerCase();
			String v2 = e2.getKey().toLowerCase();
			
			if(v1.compareTo(v2)<0)
				return -1;
			else
				return 1;
		}
		return -1;
	}
}

class hashMap<String, author_borrower> extends HashMap<String, author_borrower>{
	public java.lang.String str1="";
	public java.lang.String toString() {
		Set<Map.Entry<String,author_borrower>> set = this.entrySet();
		List<Map.Entry<String,author_borrower>> list = new ArrayList<>(set);
		Collections.sort(list, new ValueComparator<Map.Entry<String,author_borrower>>());
		Iterator<Map.Entry<String,author_borrower>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String,author_borrower> e = (Map.Entry<String,author_borrower>)it.next();
			java.lang.String str2 = (e.getKey()+ "\t" +MapManager.map.get(e.getKey()).author+"\t"+MapManager.map.get(e.getKey()).borrower+"\n");
			str1 = str1 + str2;
		}
		return str1;
	}
}

class ServerReceiver extends Thread{
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	String ID;
	
	ServerReceiver(Socket socket){
		this.socket=socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		}catch(Exception e) { e.printStackTrace();}
	}
	
	public void run() {
		try {
			while(true) {
				System.out.println("Client input waiting");
				String Command = in.readUTF();
				if(Command.equals("add")) {
					String title = in.readUTF();
					String author = in.readUTF();
					int resist=0;
					
					Set set = MapManager.map.keySet();
					Iterator iterator = set.iterator();
					while(iterator.hasNext()){
						  String key = (String)iterator.next();
						  if(key.toLowerCase().equals(title.toLowerCase()))
							  resist=1;
						}
					
		        	if(resist==1) {//같은 타이틀 존재
		        		System.out.println("중복!");
		        		out.writeUTF("The book already exists in the list.");
		        	}
		        	
		        	else {//같은타이틀 존재 X
		        		System.out.println("중복없음!");
		        		author_borrower plus = new author_borrower(author,"-");
		        		MapManager.map.put(title,plus);
		        		System.out.println(MapManager.map);
		        		MapManager.writeData();
		        		out.writeUTF("A new book added to the list.");
		        	}
				}
				else if(Command.equals("borrow")) {
					;
				}
				else if(Command.equals("return")) {
					;
				}
				else if(Command.equals("info")) {
					;
				}
				else if(Command.equals("search")) {
					;
				}
				
				
			}
		}catch(Exception e) { e.printStackTrace();}
	}
	
}

public class Server{
	public void start(int PortNum) {
		ServerSocket serverSocket=null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(PortNum);
			while(true) {
				socket = serverSocket.accept();
				System.out.println("Client accept");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.print("Please give the port number as an argument.");
			System.exit(1);
		}
		
		MapManager.readData();
		System.out.println(MapManager.map);
		
		int portNum = Integer.parseInt(args[0]);
		new Server().start(portNum);	
	}
}

