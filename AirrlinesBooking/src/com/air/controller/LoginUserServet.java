package com.air.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.air.Dao.MailDAO;
import com.air.models.Users;

/**
 * Servlet implementation class LoginUserServet
 */
@WebServlet("/LoginUserServet")
public class LoginUserServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MailDAO m =new MailDAO();
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		
		try {
			Users us = m.LoginUser(user);
			System.out.println(user);
			System.out.println(pass);
			System.out.println(us.getUsername());
			System.out.println(us.getPassword());
			if(user.equals(us.getUsername())) {
				System.out.println("here user");
				if(pass.equals(us.getPassword())){
					System.out.println("pass");
					HttpSession session=request.getSession();
					session.setAttribute("log", user);
			
					request.getRequestDispatcher("UserHome.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
