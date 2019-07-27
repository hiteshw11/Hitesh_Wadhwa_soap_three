<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Text</title>
    </head>
    <body>
        <%
            //BufferedReader reader = new BufferedReader(new FileReader("D:\\Hitesh\\first_output.txt"));
            //BufferedReader reader = new BufferedReader(new FileReader("D:\\Hitesh\\saved_contents_2"));
          
            
            //BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hitesh\\eclipse-workspace\\total\\soap_database_3a\\saved_contents_3"));
        
          BufferedReader reader = new BufferedReader(new FileReader("soap_database_3a\\saved_contents_3"));
          
        StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine())!= null){
            	out.print("\n");          	
                sb.append(line+"\n");
                out.print("\n");
            }
            out.println(sb.toString()); 
        %>

    </body>
</html>