package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// step 1.create a socket ,used for make a connection with server
			Socket socket=new Socket("localhost",9999);
			// step 2.get output stream ,send message to server
			OutputStream os=socket.getOutputStream();//bit output stream
			PrintWriter pw=new PrintWriter(os);//change output stream to print stream
			pw.write("username:admin4;passwd:123456");
			pw.flush();//refresh cache(Ë¢ÐÂ»º´æ)
			socket.shutdownOutput();//close output stream
			
			// step 2.5 get input stream , used for get server's response
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){//Circulate read clients information
				System.out.println("I'm client , server says:"+info);
			}			
			
			// step 3.close resource
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
