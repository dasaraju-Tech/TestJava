package com.jts.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jts.DAO.MainDAO;
import com.jts.login.Fileowner;
import com.jts.login.Login;

/**
 * Servlet implementation class FileRequest
 */
@WebServlet("/FileRequest")
public class FileRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		
	
		
		MainDAO m=new MainDAO();
		HttpSession s=request.getSession();
		Login u=(Login)s.getAttribute("datauser");
		
		
		
		int x=Integer.parseInt(request.getParameter("req"));
		try {
			Fileowner fo=m.readFileOwnerById(x);
			
			fo.setRequest(true);
			fo.setGenerate(false);
			m.requestFile(fo,u.getUserName());
			request.getRequestDispatcher("ViewFileResponse.jsp").include(request, response);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
