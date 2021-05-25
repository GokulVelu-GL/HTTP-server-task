package ViewDetails;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletClass
 */
@WebServlet("/ServletClass")
public class ServletClass extends HttpServlet {

	/**
	 * 
	 */
	static java.sql.Connection con;
	private static final long serialVersionUID = 1L;
	
	 public ServletClass() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//response.setContentType("text/html"); // informing the client that which format of data/response will be send
		//PrintWriter out= response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name,age,dept,email_id,gender;
		int temp=0;
		try{
			
		
		response.setContentType("text/html"); // informing the client that which format of data/response will be send
		PrintWriter out= response.getWriter();
		int s_no=1+temp;
		name=request.getParameter("name");
		dept=request.getParameter("dept");
		email_id=request.getParameter("email_id");
		age=request.getParameter("age");
		gender=request.getParameter("gender");
		
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_page","root","Admin@1234");
		java.sql.Statement st=con.createStatement();
		st.execute("insert into user_data value('"+s_no+"','"+name+"','"+dept+"','"+email_id+"','"+age+"','"+gender+"')");
		//out.println("Register successfully");
		
		
//		
//		 String spageid=request.getParameter("page");
//		 System.out.println(spageid);
//	        int pageid=Integer.parseInt(spageid);  
//	        int total=5;  
//	        if(pageid==1){}  
//	        else{  
//	            pageid=pageid-1;  
//	            pageid=pageid*total+1;  
//	        }
//	        
//		ResultSet rs = st.executeQuery("select * from user_data"); 
//		out.println("<html><body>");
//        out.println("<table border=1 width=50% height=50%>");  
//        out.println("<tr><th>S No</th><th>Name</th><th>Dept</th><th>E-Mail Id</th><th>Age</th><tr>");  
//        while (rs.next()) 
//        {  
//            String dname = rs.getString("Name");  
//            String ddept = rs.getString("Dept");
//            String demail_id = rs.getString("Email_id");  
//            String dage = rs.getString("Age");
//            int sno = rs.getInt("S_No");   
//            out.println("<tr><td>" + sno + "</td><td>" + dname + "</td><td>" + ddept + "</td><td>" + demail_id + "</td><td>" + dage + "</td></tr>");   
//        }  
//        out.println("</table>");   
//        out.println("</html></body>");  
        con.close();  
		request.getRequestDispatcher("ViewDetails?page=1").forward(request,response);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
