package com.jts.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jts.DAO.MainDAO;

/**
 * Servlet implementation class CloudServerLogin
 */
@WebServlet("/DataUserlogin")
public class DataUserlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataUserlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MainDAO m=new MainDAO();
		String user=request.getParameter("userName");
		
		try {
			Login z=m.readDataUser(request.getParameter("userName"));
			
			if(z==null) {
				request.setAttribute("message", "user Doesn't Exixst");
				request.getRequestDispatcher("datauser.jsp").include(request, response);
			}
			else { 
				if(request.getParameter("password").equals(z.getPassword())){
					
					HttpSession session=request.getSession();
					session.setAttribute("datauser", z);
					request.setAttribute("message", request.getParameter("userName"));
					request.getRequestDispatcher("HomePageUser.jsp").forward(request, response);
					}
				else
				{
					
					request.setAttribute("message", "password is wrong");
					request.getRequestDispatcher("datauser.jsp").include(request, response);
				}
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
