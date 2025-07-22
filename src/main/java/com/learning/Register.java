package com.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		int age1 = Integer.parseInt(age);
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dateofbirth");
		String pass = req.getParameter("password");
		String course = req.getParameter("course");

		resp.setContentType("text/html");

		// JDBC Connection

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch227", "root", "Payal@123");
			PreparedStatement ps = c.prepareStatement(
					"INSERT INTO platform(full_name, email, age , gender, dob, password, course) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, fname);
			ps.setString(2, email);
			ps.setInt(3, age1);
			ps.setString(4, gender);
			ps.setString(5, dob);
			ps.setString(6, pass);
			ps.setString(7, course);
			int check = ps.executeUpdate();

			PrintWriter out = resp.getWriter();
			if (check > 0) {
				out.print("<h3 style='color: green; font-weight: bold;'>"+"✅ Registered Successfully!"+"</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			} else {
				out.print("<h3 style='color: red; font-weight: bold;'>❌ Registration Failed!</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.include(req, resp);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
