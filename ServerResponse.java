import java.io.OutputStream;
import java.io.IOException; 
import java.io.FileInputStream; 
import java.io.File; 

public class ServerResponse 
{ 
	public static int BUFFER_SIZE; 
	String contentType = "text/html";
	ServerRequest request; 
	OutputStream output; 
	FileInputStream fis = null; 

		

	public ServerResponse(OutputStream output) 
	{ 
		this.output = output; 
	} 
	public void setRequest(ServerRequest request) 
	{ 
		this.request = request; 
	} 
	public void sendStaticResource() throws IOException 
	{ 
		
		//System.out.println("%%%"+Server.File_dirc+"%%%");
		System.out.println("%%%"+request.getUri()+"%%%");
		try 
		{ 
		File file = new File(Server.File_dirc, request.getUri());
		//System.out.println("%%%"+file+"%%%");
		BUFFER_SIZE=(int)file.length();
		//content_len=BUFFER_SIZE;
		String[] filetype=request.getUri().split("[.]");
				//System.out.println(filetype[1]);
				if(filetype[1].equals("js")) {
					
					contentType = "text/javascript";
					//System.out.println(HTTP_RESP);
					
				}else if(filetype[1].equals("css")) {
					contentType = "text/css";
					//System.out.println(HTTP_RESP);
				}

		String HTTP_RESP="HTTP/1.1 200 OK\n\r"
		  		+ "Date: Mon, 27 Jul 2009 12:28:53 GMT\n\r"
		  		+ "Server: Apache/2.2.14 (Win32)\n\r"
		  		+ "Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT\n\r"
		  		+ "Content-Length: "+BUFFER_SIZE+"\n\r"
		  		+ "Content-Type: "+contentType+"\n\r"
		        +"Connection: Closed\n\r\n\r";

		byte[] bytes = new byte[BUFFER_SIZE]; 
		//System.out.println("@@@"+file+"@@");
		if (file.exists()) 
		{ 
			fis = new FileInputStream(file); 
			int ch = fis.read(bytes, 0, BUFFER_SIZE); 
				
			while (ch!=-1) 
			{ 
				output.write(HTTP_RESP.getBytes());
				output.write(bytes, 0, ch); 
				ch = fis.read(bytes, 0, BUFFER_SIZE); 
			} 
		} 
		else 
		{ 
			String errorMessage = "HTTP/1.1 404 File Not Found\r\n" 
								+ "Content-Type: text/html\r\n" 
								+ "Content-Length: 23\r\n" 
								+"\r\n" +"<h1>File Not Found</h1>"; 
			output.write(errorMessage.getBytes()); 
		} 
	} 
	catch (Exception e) 
	{ 
		// thrown if cannot instantiate a File object 
			System.out.println(e.toString() ); 
	} 
	finally 
	{ 
		if (fis!=null) fis.close(); 
	} 
	}
 }