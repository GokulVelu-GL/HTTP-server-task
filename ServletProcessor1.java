import java.net.URL; 
import java.net.URLClassLoader; 
import java.net.URLStreamHandler; 
import java.io.File;
import java.io.IOException; 
import javax.servlet.Servlet; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
public class ServletProcessor1 
{ 
	public void process(ServerRequest request, ServerResponse response) 
	{ 
		String uri = request.getUri();
		//String uri ="/servlet/PrimitiveServlet";
		String servletName = uri.substring(uri.lastIndexOf("/") + 1); 
		URLClassLoader loader = null; 
		try 
		{
		 	// create a URLClassLoader 
		 	URL[] urls = new URL[1]; 
		 	URLStreamHandler streamHandler = null; 
		 	File classPath = new File(Server.File_dirc);
		 	if (classPath.exists()) {
		 		System.out.println(classPath);
		 		System.out.println(servletName+"0000");
		 	 	System.out.println("File exists");

		 	 } 
		 	 else{
		 	 	System.out.println("File Not Found");
		 	 }
		 	String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ; 
		 	System.out.println(repository);
		 	urls[0] = new URL(null, repository, streamHandler);
		 	System.out.println(urls); 
		 	loader = new URLClassLoader(urls); 
		 	System.out.println(loader);
		 } 
		 catch (IOException e) 
		 {
			System.out.println(e.toString() ); 
		} 
		Class myClass = null; 
		try 
		{ 
			System.out.println(servletName);
			myClass = loader.loadClass(servletName); 
		} 
		catch (ClassNotFoundException e) 
		{ 
			System.out.println(e.toString()); 
		} 
		Servlet servlet = null; 
		try 
		{ 
			servlet = (Servlet) myClass.newInstance(); 
			servlet.service((ServletRequest) request, (ServletResponse) response); 
		} 
		catch (Exception e) 
		{ 
			System.out.println(e.toString()); 
		} 
		catch (Throwable e) 
		{ 
			System.out.println(e.toString()); 
		} 
	} 
}
