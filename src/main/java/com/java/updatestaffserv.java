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


@WebServlet("/updatestaffserv")
public class updatestaffserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int usid = Integer.parseInt(request.getParameter("ustu_id"));
		String ufn = request.getParameter("ufname");
		String uln = request.getParameter("ulname");
		String ug = request.getParameter("ugender");
		String ud = request.getParameter("udob");
		String ue = request.getParameter("uemail");
		String umn = request.getParameter("umobile");
		String ua = request.getParameter("uaddress");

		Updatastudentbean u = new Updatastudentbean();
		u.setUstu_id(usid);
		u.setUfname(ufn);
		u.setUlname(uln);
		u.setUgender(ug);
		u.setUdob(ud);
		u.setUemail(ue);
		u.setUmobile_no(umn);
		u.setUaddress(ua);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch11", "root", "");
			PreparedStatement ps = con.prepareStatement(
					"update admin_staff set fname=?,lname=?,email=?,address=?,dob=?,mobile_no=?,gender=? where sta_id=?");

			ps.setString(1, ufn);
			ps.setString(2, uln);
			ps.setString(3, ue);
			ps.setString(4, ua);
			ps.setString(5, ud);
			ps.setString(6, umn);
			ps.setString(7, ug);
			ps.setInt(8, usid);

			int k = ps.executeUpdate();
			if (k > 0) {

				response.sendRedirect("showstaffdetails.jsp");

			} else

			{
				pw.print("error....");
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
