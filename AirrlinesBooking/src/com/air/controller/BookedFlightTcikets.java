package com.air.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.Dao.MailDAO;
import com.air.models.TicketBooking;

/**
 * Servlet implementation class BookedFlightTcikets
 */
@WebServlet("/BookedFlightTcikets")
public class BookedFlightTcikets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookedFlightTcikets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TicketBooking t=new TicketBooking();
		MailDAO m=new MailDAO();
		t.setName(request.getParameter("passenger"));
		t.setGender(request.getParameter("gender"));
		t.setAge(request.getParameter("age"));
		t.setAadharCard(request.getParameter("aadhar"));
		t.setPrice(request.getParameter("price"));
		t.setUserName(request.getParameter("user"));
		t.setFlightName(request.getParameter("flightname"));
		t.setFlightId(request.getParameter("flightid"));
		
		try {
			m.Tickets(t);
			request.getRequestDispatcher("BookFlight.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("BookFlight.jsp").forward(request, response);

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
