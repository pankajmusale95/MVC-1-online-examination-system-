package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Stuloginservlet")
public class Stuloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String un = request.getParameter("suname");
		String p = request.getParameter("psw");
		Cookie ck=new Cookie("mycookie",un);
		response.addCookie(ck);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch11", "root", "");
			PreparedStatement ps = con.prepareStatement("select user_name,password from student_reg where user_name=? and password=?");
			ps.setString(1, un);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (un.equals(rs.getString(1)) && p.equals(rs.getString(2))) {
					pw.print("<h3>login sucessfully....</h3>");
					RequestDispatcher rd=request.getRequestDispatcher("studentprofile.html");
	    			rd.forward(request, response);
				}
			}
				else {
					
					pw.print("<h3 style='color:red;'>Incorrect password or user name...</h3>");
	    			RequestDispatcher rd=request.getRequestDispatcher("/studentlogin.html");
	    			rd.include(request, response);
				}
			

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
