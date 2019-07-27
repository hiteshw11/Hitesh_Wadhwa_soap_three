package packer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class soap_database_3a {
	public static void main(String args[])
	{
		try {
			 //String url = "http://localhost:8080/soap_database_3/Servletone/op?wsdl";
			String url = "https://shielded-tundra-11654.herokuapp.com/Servletone/op?wsdl"; 
			URL obj = new URL(url);
			 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			 con.setRequestMethod("POST");
			 con.setRequestProperty("Content-Type","application/soap+xml;");
			 //String countryCode="Canada";
			 String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pac=\"http://packer/\">\r\n" + 
			 		"   <soapenv:Header/>\r\n" + 
			 		"   <soapenv:Body>\r\n" + 
			 		"      <pac:names>\r\n" + 
			 		"         <arg0>James</arg0>\r\n" + 
			 		"         <arg1>Riley</arg1>\r\n" + 
			 		"      </pac:names>\r\n" + 
			 		"   </soapenv:Body>\r\n" + 
			 		"</soapenv:Envelope>";
			 con.setDoOutput(true);
			 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			 wr.writeBytes(xml);
			 wr.flush();
			 wr.close();
			 String responseStatus = con.getResponseMessage();
			 System.out.println(responseStatus);
			 BufferedReader in = new BufferedReader(new InputStreamReader(
			 con.getInputStream()));
			 String inputLine;
			 StringBuffer response = new StringBuffer();
			 while ((inputLine = in.readLine()) != null) {
			 response.append(inputLine);
			 }
			 in.close();
			 System.out.println("response:" +"\n"+ response.toString());
			 } catch (Exception e) {
			 System.out.println(e);
			 }
}
}
