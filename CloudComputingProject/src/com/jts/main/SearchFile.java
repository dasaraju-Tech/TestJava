package com.jts.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jts.DAO.MainDAO;
import com.jts.login.Fileowner;

/**
 * Servlet implementation class SearchFile
 */
@WebServlet("/SearchFiles")
public class SearchFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String f= request.getParameter("keyword");
		
		try {
			List<Fileowner> flist=MainDAO.readsearchfile(f);
			System.out.println(flist);
			request.setAttribute("list",flist);  
			if(flist.isEmpty()) {
				request.setAttribute("message", "No such files");
				request.getRequestDispatcher("SearchFileUser.jsp").include(request, response);
			}
			else {
				request.getRequestDispatcher("SearchFileUser.jsp").include(request, response);
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
