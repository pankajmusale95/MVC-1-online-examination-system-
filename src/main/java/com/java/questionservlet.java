package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/questionservlet")
public class questionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();	
		Cookie ck[]=request.getCookies();
		String a=ck[0].getValue();

		
		String paramName,paramValue[];
		int cnt=0;
		String ans="";
		Enumeration<String> paramNames=request.getParameterNames();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch11", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ans from question2");
			
			while (rs.next()&& paramNames.hasMoreElements()) {
				String n=rs.getString(1);
				paramName=(String)paramNames.nextElement();
				paramValue=request.getParameterValues(paramName);
				
				for(int i=0;i<paramValue.length;i++) {
					ans=paramValue[i];
					
				}
				if(n.equals(ans))
					cnt++;
				
			}
			int per=((cnt*100)/10);
			pw.print("<center style='margin:60px;'>");
			pw.print("<h2>Result:</h2>");
			pw.print("<h3>Total question : 10</h3> ");
			pw.print("<h3 style='color:green;'> You have scored "+cnt+" marks out of 10 marks.</h3>");
			pw.print("<h3 style='color:SlateBlue;margin-bottom:-50px;'> Percentage : "+per+" %</h3>");
			pw.print("</center>");
			PreparedStatement ps = con
					.prepareStatement("update student_sub1 set s_marks=?,s_per=? where  stu_name=?");
			
			ps.setInt(1, cnt);
			ps.setInt(2, per);
			ps.setString(3, a);
			

			int i = ps.executeUpdate();
			pw.print("<center>"+i+" Record Saved</center>");
			
			 			pw.println("<A HREF=\"logout.jsp\"><span style='margin-left:870px;'><button style='margin-left:500px;border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: #008CBA;'>Logout</button></span></A>");
			
		}
		catch(Exception e1){	
			System.out.println(e1);
		}
	}

}
