
import java.io.*;
import java.net.*;
import java.util.Base64;

class Request
{
	
	void serverRequest(Socket s) throws IOException {
		
		String contentType = "text/html";
		
		String HTTP_RESP="HTTP/1.1 200 OK\n\r"
		  		+ "Date: Mon, 27 Jul 2009 12:28:53 GMT\n\r"
		  		+ "Server: Apache/2.2.14 (Win32)\n\r"
		  		+ "Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT\n\r"
		  		+ "Content-Length: 88\n\r"
		  		+ "Content-Type: "+contentType+"\n\r"
		        +"Connection: Closed\n\r\n\r";
		
		try {
				
			
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		//	InputStreamReader in=new InputStreamReader(s.getInputStream());
	
			String inputLine=in.readLine();
		//	System.out.println(inputLine);
			String link=inputLine.substring(5);
			String[] value=link.split(" HTTP/");
		//	System.out.println(value[0]);
			
				
			OutputStream output =s.getOutputStream();;
			
			File file=new File("E:/3 ways/demo/"+value[0])	;
			int filelength=(int)file.length();
			byte[] bytes=new byte[filelength];

			if(file.exists()) {
				
			//	System.out.println(value[0]);
				String[] filetype=value[0].split("[.]");
			//	System.out.println(filetype.length);
				
				if(filetype[1].equals("js")) {
					contentType = "text/javascript";
					
				}else if(filetype[1].equals("css")) {
					contentType = "text/css";
				}
				else if(filetype[1].matches("png|jpeg|gif|jpg")) {
				//	System.out.println("********");
					contentType = "image/"+filetype[1];
					System.out.println(value[0]);
					//bytes = Base64.getDecoder().decode("E:/3 ways/demo//"+value[0]);
						
	                
				}
				
				FileInputStream fis=new FileInputStream(file);
				int readValue=fis.read(bytes,0,filelength);
			
				//System.out.println(readValue);
				HTTP_RESP=HTTP_RESP.replaceFirst("88",readValue+"").replace("text/html",contentType);
				//s.getOutputStream().write(HTTP_RESP.getBytes());
				while(readValue!=-1) {
					output.write(HTTP_RESP.getBytes());
					output.write(bytes,0, readValue);
					readValue=fis.read(bytes,0,filelength);
				}
			}
			else
			{
				System.out.println("File Not Found");
			}

			s.getOutputStream().flush();
			output.close();
		
			s.close();

		
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
}
