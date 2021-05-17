import java.io.IOException; 
public class StaticResourceProcessor 
{ 
	public void process(ServerRequest request, ServerResponse response) 
	{ 
		try 
		{ 
			response.sendStaticResource(); 
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
}