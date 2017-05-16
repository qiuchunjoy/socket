package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * base on TCP protocol's socket communication,realize user loading
 * server
 */

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// 1.create a server socket, it mean ServerSocket, it names a bind port and listen to this port
			ServerSocket serversocket=new ServerSocket(9999);
			Socket socket=null;
		//mark clients's number
			int count=0;
			System.out.println("***server will startup , waiting for clients connecting!***");
			
			//circulate listen ,waiting for clients's connect
			while(true){
				// use serverSocket accept() method to listen , waiting for clients connecting
				socket=serversocket.accept();
				//create a new thread
				ServerThread serverThread=new ServerThread(socket);
				//start thread 
				serverThread.start();
				count++;//caculate the number of clients
				System.out.println("clients's number is :"+count);
				InetAddress address=socket.getInetAddress();
				System.out.println("current client's IP is:"+address.getHostAddress());
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
