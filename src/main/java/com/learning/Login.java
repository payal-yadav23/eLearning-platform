package com.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mail = req.getParameter("email");
		String pass = req.getParameter("password");

		resp.setContentType("text/html");

		// jdbc connectivity

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch227", "root", "Payal@123");
			PreparedStatement ps = c.prepareStatement("SELECT * FROM platform WHERE email =? AND password=?");
			ps.setString(1, mail);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				PrintWriter out = resp.getWriter();
				out.print("<h3 style='color: green; font-weight: bold;'>✅ Login Successfull !</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
				rd.include(req, resp);
			} else {
				PrintWriter out = resp.getWriter();
				out.print("<h3 style='color: red; font-weight: bold;'>❌ Invalid Credentials !</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.include(req, resp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
