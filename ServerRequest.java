import java.io.*;
import java.net.*;

class ServerRequest
{
	private InputStream input; 
	private String uri; 

	public ServerRequest(InputStream input) 
	{ 
		this.input = input; 
	} 

	public void parse(Socket s)
	{
		
		try {
				
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		//	InputStreamReader in=new InputStreamReader(s.getInputStream());
			String inputLine=in.readLine();
			uri=parseUri(inputLine);
			System.out.println(uri);
			System.out.println(inputLine);

			
			// String link=inputLine.substring(5);
			// String[] value=link.split(" HTTP/");
			// System.out.println(value[0]);
			
				
			// OutputStream output =s.getOutputStream();;
			
			// File file=new File("E:/3 ways/demo"+value);
			// int filelength=(int)file.length();
			// byte[] bytes=new byte[filelength];

			// if(file.exists()) {
				
			// //	System.out.println(value[0]);
			// 	String[] filetype=value[0].split("[.]");
			// //	System.out.println(filetype.length);
				
			// 	if(filetype[1].equals("js")) {
			// 		contentType = "text/javascript";
					
			// 	}else if(filetype[1].equals("css")) {
			// 		contentType = "text/css";
			// 	}
			// 	else if(filetype[1].matches("png|jpeg|gif|jpg")) {
			// 	//	System.out.println("********");
			// 		contentType = "image/"+filetype[1];
			// 		System.out.println(value[0]);
			// 		//bytes = Base64.getDecoder().decode("E:/3 ways/demo//"+value[0]);
						
	                
			// 	}
				
			// 	FileInputStream fis=new FileInputStream(file);
			// 	int readValue=fis.read(bytes,0,filelength);
			
			// 	//System.out.println(readValue);
			// 	HTTP_RESP=HTTP_RESP.replaceFirst("88",readValue+"").replace("text/html",contentType);
			// 	//s.getOutputStream().write(HTTP_RESP.getBytes());
			// 	while(readValue!=-1) {
			// 		output.write(HTTP_RESP.getBytes());
			// 		output.write(bytes,0, readValue);
			// 		readValue=fis.read(bytes,0,filelength);
			// 	}
			// }
			// else
			// {
			// 	System.out.println("File Not Found");
			// }

			// s.getOutputStream().flush();
			// output.close();
		
			// s.close();

		
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	private String parseUri(String requestString) 
	{
		int index1, index2; 
		index1 = requestString.indexOf(' '); 
		if (index1 != -1) 
		{ 
			index2 = requestString.indexOf(' ', index1 + 1); 
			if (index2 > index1) 
				return requestString.substring(index1 + 1, index2); 
		} 
		return null; 
	} 
	public String getUri() 
	{ 

		return uri; 
	} 
	
}
