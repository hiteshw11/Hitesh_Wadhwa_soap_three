/*https://whispering-gorge-73446.herokuapp.com*/

// warm springs is newwebber which is addition application

package packer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Serv1
 */
@WebServlet("/Serv1")
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv1() {
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
		//String a1=(String)request.getParameter("fname");
		//String b1=(String)request.getParameter("lname");
		out.print("<html><body>Check the value</body></html>");
		out.print("<br>");
		//out.print(a1);
		out.print("<br>");
		//out.print(b1);
		//session.setAttribute("a1","a1");
		//session.setAttribute("b1","b1");
		try {
			 //String url = "http://localhost:8080/soap_database_3/Servletone/op?wsdl";
			//String url = "https://shielded-tundra-11654.herokuapp.com/Servletone/op?wsdl";
			String url="https://infinite-beyond-53668.herokuapp.com/Serv/op?wsdl";
			 URL obj = new URL(url);
			 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			 con.setRequestMethod("POST");
			 con.setRequestProperty("Content-Type","application/soap+xml;");
			 //String countryCode="Canada";
			 String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pac=\"http://packer/\">\r\n" + 
			 		"   <soapenv:Header/>\r\n" + 
			 		"   <soapenv:Body>\r\n" + 
			 		"      <pac:names>\r\n" + 
			 		"         <arg0>John</arg0>\r\n" +                          //"+a1+" 
			 		"         <arg1>Smith</arg1>\r\n" + 
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
			 out.println("<br><br>");
			 out.println("<a href='https://evening-savannah-34179.herokuapp.com'>Back Home");
			 } catch (Exception e) {
			 System.out.println(e);
			 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
