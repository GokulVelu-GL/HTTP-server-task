<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<body>
<script>  
var request=new XMLHttpRequest();  
function searchInfo(){  
var name=document.vinform.name.value;  
var url="UserDetails.jsp?val="+name;  
  
try{  
request.onreadystatechange=function(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('mylocation').innerHTML=val;  
}  
}//end of function  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
</script>  
</head>  
<body>  
<h1>Search Employee</h1>  
<form name="vinform">  
<input type="text" name="name" onkeyup="searchInfo()">  
</form>  
<a href="insert.html">Add user Details</a>  


<%@ page import = "java.sql.*" %>
  <%
      Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/login_page","root","Admin@1234"); // <== Check!
      // Connection conn =
      //    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
      Statement stmt = conn.createStatement();
 
      String sqlStr = "SELECT * FROM user_data";
      ResultSet rset = stmt.executeQuery(sqlStr);
  %>
      <hr>
        <table border='1' cellpadding='2' width='100%'>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Dept</th>
            <th>Email Id</th>
            <th>Age</th>
            
          </tr>
       </thead>   
  <span>        
  <%
      while (rset.next()) {
  %>	<tbody id="mylocation">
          <tr >
            <td><%= rset.getString(1) %></td>
            <td><%= rset.getString(2) %></td>
            <td><%= rset.getString(3) %></td>
            <td><%= rset.getString(4) %></td>
            <td><%= rset.getString(5) %></td>
          </tr>
  <%
      }
  %>
  </tbody>
        </table>
        <br>
  

</span> 
 
</body>  
</html>  


