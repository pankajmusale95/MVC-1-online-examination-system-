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


@WebServlet("/Addstaffservlet")
public class Addstaffservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		String e = request.getParameter("email");
		String a = request.getParameter("address");
		String mn = request.getParameter("mobile");
		String d = request.getParameter("dob");
		String g = request.getParameter("gender");
		

		int sid = Integer.parseInt(request.getParameter("stu_id"));

		Studentbean s = new Studentbean();
		s.setFname(fn);
		s.setLname(ln);
		s.setEmail(e);
		s.setAddress(a);
		s.setMobile_no(mn);
		s.setDob(d);
		s.setStu_id(sid);
		s.setGender(g);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch11", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into admin_staff values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, sid);
			ps.setString(2, fn);
			ps.setString(3, ln);
			ps.setString(4, e);
			ps.setString(5, a);
			ps.setString(6, d);
			ps.setString(7, mn);
			ps.setString(8, g);

			int k = ps.executeUpdate();
			if (k > 0) {
				try {

					response.sendRedirect("addstaff.html");

				} catch (Exception e3) {
					System.out.println(e3);
				}

			} else

			{
				pw.print("error....");
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
