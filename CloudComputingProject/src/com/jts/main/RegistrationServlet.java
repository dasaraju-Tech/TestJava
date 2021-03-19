package com.jts.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jts.DAO.MainDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int result=0;
		PrintWriter out = response.getWriter();
		
		
		Registration r=new Registration();
		r.setId(Integer.parseInt(request.getParameter("id")));
		r.setFirstName(request.getParameter("firstName"));
		r.setLastname(request.getParameter("lastName"));
		r.setUsername(request.getParameter("userName"));
		r.setPassword(request.getParameter("password"));
		r.setContactNumber(request.getParameter("cnumber"));
		r.setEmail(request.getParameter("email"));
		r.setAddress(request.getParameter("address"));
		r.setGender(request.getParameter("gender"));
		r.setUserType(request.getParameter("utype"));
		r.setStatus(false);
		
		System.out.println(r.getFirstName()+" "+r.getGender()+" "+r.isStatus()+" "+r.getUserType());
		
		MainDAO m=new MainDAO();
				
		try {
			result=m.register(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0) {
			request.setAttribute("message", "Sucessfully Added");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		}
		else {
			request.setAttribute("message", "Failed to Add");
			request.getRequestDispatcher("registration.jsp").include(request, response);
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
