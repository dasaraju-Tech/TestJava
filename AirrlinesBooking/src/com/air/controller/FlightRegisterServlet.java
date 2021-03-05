package com.air.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.Dao.MailDAO;
import com.air.models.FlightRegister;

/**
 * Servlet implementation class FlightRegisterServlet
 */
@WebServlet("/FlightRegisterServlet")
public class FlightRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FlightRegister f= new FlightRegister();
		f.setFlightId(request.getParameter("flightid"));
		f.setFlightName(request.getParameter("flightname"));
		f.setFrom(request.getParameter("from"));
		f.setTo(request.getParameter("to"));
		f.setAirport(request.getParameter("airport"));
		f.setTime(request.getParameter("time"));
		f.setDate(request.getParameter("date"));
		f.setPrice(request.getParameter("price"));
		f.setDetails(request.getParameter("details"));
		
		
		MailDAO m= new MailDAO();
		try {
			m.flightRegistration(f);
			request.getRequestDispatcher("FlightRegister.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("FlightRegister.jsp").forward(request, response);
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
