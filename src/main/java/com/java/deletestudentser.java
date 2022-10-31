package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletestudentser")
public class deletestudentser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("delete"));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch11", "root", "");
			PreparedStatement ps = con.prepareStatement("delete from admin_student where stu_id=?");
			ps.setInt(1, id);
			int k = ps.executeUpdate();
			if (k > 0) {
				response.sendRedirect("showstudetails.jsp");
				
				} 
			else

			{
				pw.print("<center><h2 style='color: red;'>Incorrect ID</h2></center>");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
