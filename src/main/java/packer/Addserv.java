package packer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Addserv
 */
@WebServlet("/Addserv")
public class Addserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//String url="https://infinite-beyond-53668.herokuapp.com/Serv/op?wsdl";
		String url="https://shielded-tundra-11654.herokuapp.com/Servletone/op?wsdl";
		 URL obj = new URL(url);
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 con.setRequestMethod("POST");
		 con.setRequestProperty("Content-Type","application/soap+xml;");
		 String model_id=request.getParameter("model_id");
		String make=request.getParameter("make");
		String model=request.getParameter("model");
		String class1=request.getParameter("class");
		 String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pac=\"http://packer/\">\r\n" + 
			 		"   <soapenv:Header/>\r\n" + 
			 		"   <soapenv:Body>\r\n" + 
			 		"      <pac:names>\r\n" + 
			 		"         <arg0>"+model_id+"</arg0>\r\n" +                          //"+a1+" 
			 		"         <arg1>"+make+"</arg1>\r\n" +
			 		"		  <arg2>"+model+"</arg2>\r\n"+
			 		"		  <arrg3>"+class1+"</arg3>\r\n"+	
			 		"      </pac:names>\r\n" + 
			 		"   </soapenv:Body>\r\n" + 
			 		"</soapenv:Envelope>";
		 con.setDoOutput(true);
		 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		 wr.writeBytes(xml);
		 wr.flush();
		 wr.close();
		 String responseStatus = con.getResponseMessage();
		 out.println(responseStatus);
		 BufferedReader in = new BufferedReader(new InputStreamReader(
		 con.getInputStream()));
		 String inputLine;
		 StringBuffer response1 = new StringBuffer();
		 while ((inputLine = in.readLine()) != null) {
		 response1.append(inputLine);
		 }
		 in.close();
		 out.println("response:" +"\n"+ response1.toString());
		 out.println("completed");	
	} 
		
		
		
		
		
		
		/*int model_id=Integer.parseInt(request.getParameter("model_id"));
		String make=request.getParameter("make");
		String model=request.getParameter("model");
		String class1=request.getParameter("class");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-02.cleardb.net/heroku_525dab1eaa9add9	","bfa6e379b01f5f","d061f471"); 
			Statement st= con.createStatement(); 
			ResultSet rs=st.executeQuery("INSERT into onetable values("+model_id+","+make+","+model+","+class1+")");
			
		}
		
		catch(Exception e)
		{
			out.println(e);
		}*/
		
	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
