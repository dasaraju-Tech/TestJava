package com.air.controller;

import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.Dao.MailDAO;
import com.air.models.*;
/**
 * Servlet implementation class UserRegistrationControl
 */
@WebServlet("/UserRegistrationControl")
public class UserRegistrationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users u=new Users();
		MailDAO m = new MailDAO();
		u.setFullName(request.getParameter("fullname"));
		u.setGender(request.getParameter("gender"));
		u.setMobileNumber(request.getParameter("mobile"));
		u.setPassportNumber(request.getParameter("passport"));
		u.setUsername(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
			
		try {
			m.UserRegistration(u);
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			e.printStackTrace();
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
