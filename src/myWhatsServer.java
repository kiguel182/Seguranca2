import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;


public class myWhatsServer{

	public static void main(String[] args) {
		myWhatsServer server = new myWhatsServer();
		server.startServer();
	}
	
	public void startServer (){
		ServerSocketFactory ssf = null;
        ServerSocket ss = null;
		System.setProperty("javax.net.ssl.keyStore", "myServer.keyStore");
		System.setProperty("javax.net.ssl.keyStorePassword", "qwerty");
		try {
			ssf = SSLServerSocketFactory.getDefault();
			ss = ssf.createServerSocket(23456);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
         
		while(true) {
			try {
				Socket inSoc = ss.accept();
				ServerThread newServerThread = new ServerThread(inSoc);
				newServerThread.start();
		    }
		    catch (IOException e) {
		        e.printStackTrace();
		    }
		    
		}
		
		
	}
	
}