import java.io.*;
import java.net.*;
import java.util.Base64;


public class Server {
  
 	public static final String File_dirc = System.getProperty("user.dir") + File.separator+"Hello";
 	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
 	private boolean shutdown = false;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Server server=new Server();
		System.out.println("######"+File_dirc+"#######");
		server.await();
	
	}

	public void await()
	{
		ServerSocket ss=null;
		try 
		{	
			ss=new ServerSocket(2222);
		}
		catch(Exception e) {

			e.printStackTrace(); 
			System.exit(1);
			//System.out.println(e);
		}
		while (!shutdown) 
		{ 
			Socket socket = null; 
			InputStream input = null; 
			OutputStream output = null; 
			try 
			{ 
				socket = ss.accept(); 
				input = socket.getInputStream(); 
				output = socket.getOutputStream(); 
				 
				//System.out.println("inputLine");

				ServerRequest request = new ServerRequest(input); 
				request.parse(socket); 
				System.out.println("request");

				ServerResponse response = new ServerResponse(output); 
				response.setRequest(request); 
				response.sendStaticResource();

				System.out.println("response");

				socket.close();
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} 
			catch (Exception e) 
			{ 
				e.printStackTrace (); 
				continue; 
			} 
		}
	}

	
	
}

