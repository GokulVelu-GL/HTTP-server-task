package ViewDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewDetails
 */
@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        
		        out.print("<a href='index.html'>Register Page</a> ");  
		        String spageid=request.getParameter("page");  
		        int pageid=Integer.parseInt(spageid);  
		        int total=5;  
		        if(pageid==1){}  
		        else{  
		            pageid=pageid-1;  
		            pageid=pageid*total+1;  
		        }  
		        List<Userdetail> list=UserDataList.getRecords(pageid,total);  
		   
		        out.print("<table border='1' cellpadding='4' width='60%'>");  
		        out.print("<tr><th>Id</th><th>Name</th><th>Dept</th><th>Email_id</th><th>Age</th>");  
		        for(Userdetail e:list){  
		            out.print("<tr><td>"+e.getS_no()+"</td><td>"+e.getName()+"</td><td>"+e.getDept()+"</td><td>"+e.getEmail_id()+"</td><td>"+e.getAge()+"</td></tr>");  
		        }  
		        out.print("</table>");  
		          
		        out.print("<a href='ViewDetails?page=1'>1</a> ");  
		        out.print("<a href='ViewDetails?page=2'>2</a> ");  
		        out.print("<a href='ViewDetails?page=3'>3</a> ");  
		          
		        out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
