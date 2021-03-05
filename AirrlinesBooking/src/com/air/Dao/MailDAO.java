package com.air.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.air.JdbcConnection.JDBCconnection;
import com.air.models.FlightRegister;
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
	
	
}
