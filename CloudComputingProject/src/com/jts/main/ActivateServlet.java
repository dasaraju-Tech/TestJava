package com.jts.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jts.DAO.MainDAO;

/**
 * Servlet implementation class ActivateServlet
 */
@WebServlet("/ActivateServlet")
public class ActivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateServlet() {
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
		System.out.println(request.getParameter("id"));
		
		Registration r=null;
		
		
		// read from register table
		try {
			r=m.readRegisterdUser(Integer.parseInt(request.getParameter("id")));
			System.out.println(r);
			r.setStatus(true);
			m.updateRegisteredUser(Integer.parseInt(request.getParameter("id")));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(r.getUserType().equals("Data Owner")) {
			
			//insert into dataowners table
			
			try {
				int x=m.dataOwnres(r);
				if(x>0) {
					System.out.println("success");
				}
				else
				{
					System.out.println("fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("viewDataOwners.jsp").include(request, response);
			
		}
		else {
			//insert into data users
			try {
				int k=m.dataUsers(r);
				if(k>0) {
					System.out.println("success");
				}
				else
				{
					System.out.println("fail");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("viewDataUsers.jsp").include(request, response);
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
