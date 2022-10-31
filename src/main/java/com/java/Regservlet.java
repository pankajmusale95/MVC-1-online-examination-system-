package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Regservlet")
public class Regservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String n = request.getParameter("name");
		String un = request.getParameter("uname");
		String p = request.getParameter("psw");
		String e = request.getParameter("email");
		String a = request.getParameter("address");
		String mn = request.getParameter("mobile");
		String g = request.getParameter("gender");

		Bean b1 = new Bean();
		b1.setName(n);
		b1.setUsername(un);
		b1.setPassword(p);
		b1.setEmail(e);
		b1.setAddress(a);
		b1.setMobile(mn);
		b1.setGender(g);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch11", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into admin_reg values(?,?,?,?,?,?,?)");
			ps.setString(1, n);
			ps.setString(2, un);
			ps.setString(3, p);
			ps.setString(4, e);
			ps.setString(5, a);
			ps.setString(6, mn);
			ps.setString(7, g);

			int k = ps.executeUpdate();
			if (k > 0) {
				pw.print("<center>");
				pw.print("<center><h2 style='color: green;'>Registered Sucessfully </h2></center>");
				pw.print("<a href='adminlogin.html'>");
				pw.print(
						"<button style='border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;font-size: 16px; margin: 4px 2px;cursor: pointer;background-color: #008CBA;'>Login</button>");
				pw.print("</a>");
				pw.print("</center>");
			} else {
				pw.print("error....");
				
			}

		} catch (Exception e1) {
			System.out.println(e1);
		}

	}

}
