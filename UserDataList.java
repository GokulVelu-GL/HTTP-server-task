package ViewDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDataList {
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_page","root","Admin@1234");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
  
    public static List<Userdetail> getRecords(int start,int total){  
        List<Userdetail> list=new ArrayList<Userdetail>();  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user_data limit "+(start-1)+","+total);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Userdetail e=new Userdetail();  
                e.setS_no(rs.getInt(1));
                e.setName(rs.getString(2)); 
                e.setDept(rs.getString(3));
                e.setEmail_id(rs.getString(4));
                e.setAge(rs.getString(5));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  

}
