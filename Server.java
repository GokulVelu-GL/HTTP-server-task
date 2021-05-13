
import java.io.*;
import java.net.*;
import java.util.Base64;


public class Server {
  
	public static void main(String[] args){
		// TODO Auto-generated method stub
 
	try {	
		
		ServerSocket ss=new ServerSocket(2222);
		
		while(true) {
		Socket s=ss.accept();
		Request req=new Request();
		req.serverRequest(s);
		}

	}catch(Exception e) {
		System.out.println(e);
	}
	}

	
	
}

