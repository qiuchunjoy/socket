package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * server thread manipulate class
 */
public class ServerThread extends Thread {
	//related socket
	Socket socket=null;
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	//thread's work , make response to client's request
	public void run(){
			
					InputStream is=null;
					InputStreamReader isr=null;
					BufferedReader br=null;
					// step 4.get output stream , make a response to clients
					OutputStream os=null;
					PrintWriter pw=null;
					try {
						// 3.get input stream , get clients informations	
						is = socket.getInputStream();
						isr = new InputStreamReader(is);
						br = new BufferedReader(isr);
						String info=null;
						while((info=br.readLine())!=null){//ciculate read clients information
							System.out.println("I'm server , clients says:"+info);
						}
						socket.shutdownInput();//close input stream
						// step 4.get output stream , make a response to clients
						os = socket.getOutputStream();
						pw = new PrintWriter(os);
						pw.write("welcome");
						pw.flush();// use flush() method to output buffer
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						// step 5.close resource
						try {
							if(pw!=null)
							pw.close();
							if(os!=null)
							os.close();
							if(br!=null)
							br.close();
							if(is!=null)
							is.close();
							if(isr!=null)
							isr.close();
							if(socket!=null)
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
	
	}

}
