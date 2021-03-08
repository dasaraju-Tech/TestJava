package com.air.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.air.JdbcConnection.JDBCconnection;
import com.air.models.FlightRegister;
import com.air.models.TicketBooking;
import com.air.models.Users;

public class MailDAO {
	Connection con;
	PreparedStatement pst;
	
	//registering users
	
	public void UserRegistration(Users p ) throws SQLException {
		
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
		pst.setInt(1, p.getId());
		pst.setString(2, p.getFullName());
		pst.setString(3, p.getGender());
		pst.setString(4, p.getPassportNumber());
		pst.setString(5, p.getUsername());
		pst.setString(6, p.getPassword());
		pst.setString(7, p.getMobileNumber());
		pst.executeUpdate();
		System.out.println("Inserted user");
		
		
		
		
	}
	
	//delete flight from flights list
	
	public void DeleteFlight(String s) throws SQLException {
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("delete from flights where flightid=?");
		pst.setString(1,s);
		pst.executeUpdate();
		
		
		
	}
	
	
	//user login
	
	public Users LoginUser(String s) throws SQLException {
		Users u=new Users();
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("select email,passcode from users where email=?");
		pst.setString(1, s);
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
		u.setUsername(rs.getString("email"));
		System.out.println(rs.getString("email"));
		u.setPassword(rs.getString("passcode"));
		}
		return u;
		
	}
	
	// admin login
	
	public Users LoginAdmin() throws SQLException {
		Users u=new Users();
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("select * from adminlogin");
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
		u.setUsername(rs.getString("username"));
		
		u.setPassword(rs.getString("passcode"));
		}
		return u;
		
	}
	
	// booked tickets inserting into dabase
	
	public void Tickets(TicketBooking t) throws SQLException {
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("insert into tickets values(?,?,?,?,?,?,?,?)");
		pst.setString(1, t.getName());
		pst.setString(2, t.getGender());
		pst.setString(3, t.getAge());
		pst.setString(4, t.getAadharCard());
		pst.setString(5, t.getPrice());
		pst.setString(6, t.getUserName());
		pst.setString(7, t.getFlightName());
		pst.setString(8, t.getFlightId());
		pst.executeUpdate();
		System.out.println("Ticket inserted");
		
	}
	
	// registering new flight
	
	public void flightRegistration(FlightRegister p ) throws SQLException {
		
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("insert into flights values(?,?,?,?,?,?,?,?,?)");
		pst.setString(1, p.getFlightId());
		pst.setString(2, p.getFlightName());
		pst.setString(3, p.getFrom());
		pst.setString(4, p.getTo());
		pst.setString(5, p.getTime());
		pst.setString(6, p.getDate());
		pst.setString(7, p.getAirport());
		pst.setString(8, p.getPrice());
		pst.setString(9, p.getDetails());
		pst.executeUpdate();
		System.out.println("Inserted user");
		
		
		
		
	}
	
	//to display all the registered flights list
	
	public List<FlightRegister>  ReadFlights() throws SQLException{
		con=JDBCconnection.getConnection();
		List< FlightRegister> l = new ArrayList<FlightRegister>();
		FlightRegister f;
		pst=con.prepareStatement("select * from flights");
		ResultSet rs=pst.executeQuery();
		while (rs.next()) {
			f=new FlightRegister();
			f.setFlightId(rs.getString("flightid"));
			f.setFlightName(rs.getString("flightName"));
			f.setFrom(rs.getString("fromCity"));
			f.setTo(rs.getString("toCity"));
			f.setTime(rs.getString("departureTime"));
			f.setDate(rs.getString("departuredate"));
			f.setAirport(rs.getString("airport"));
			f.setPrice(rs.getString("price"));
			f.setDetails(rs.getString("details"));
			l.add(f);
		}
		
		return l;
		
	}
	
	public List<TicketBooking> ViewTickets() throws SQLException{
		con=JDBCconnection.getConnection();
		List<TicketBooking> l=new ArrayList<TicketBooking>();
		TicketBooking t;
		pst=con.prepareStatement("select * from tickets");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			t=new TicketBooking();
			t.setName(rs.getString("passenger_name"));
			t.setUserName(rs.getString("username"));
			t.setAadharCard(rs.getString("aadhar_number"));
			t.setAge(rs.getString("age"));
			t.setFlightId(rs.getString("flightId"));
			t.setFlightName(rs.getString("flightName"));
			t.setGender(rs.getString("gender"));
			t.setPrice(rs.getString("price"));
			l.add(t);
		}
		
		return l;
		
		
	}
	
	//inserting into contacts
	
	public void Contact(com.air.models.Contact c) throws SQLException {
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("insert into contact values (?,?,?)");
		pst.setString(1, c.getName());
		pst.setString(2, c.getEmail());
		pst.setString(3, c.getMessage());
		pst.executeUpdate();
		
	}
	
	//read reports in contacts
	
	public List<com.air.models.Contact> readContacts() throws SQLException{
		com.air.models.Contact c;
		List<com.air.models.Contact> l= new ArrayList<com.air.models.Contact>();
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("select * from contact");
		ResultSet rs=pst.executeQuery();
		while (rs.next()) {
			c=new com.air.models.Contact();
			c.setName(rs.getString(1));
			c.setEmail(rs.getString(2));
			c.setMessage(rs.getString(3));
			l.add(c);
		}
		
		return l;
	}
	
	//cancel ticket
	
	public void CancelTicket(String s) throws SQLException {
		con=JDBCconnection.getConnection();
		pst=con.prepareStatement("delete from tickets where username=?");
		pst.setString(1, s);
		pst.executeUpdate();
	}
	
	
	
}
