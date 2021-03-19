package com.jts.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jts.login.Fileowner;
import com.jts.login.Login;
import com.jts.main.Registration;

import JDBCConnection.JdbcConnection;

public class MainDAO<UploadFileOwner> {
	 static Connection connection = JdbcConnection.getConnection();
	    static PreparedStatement pst;


	public int register(Registration r) throws SQLException{
		
		
		String query="insert into RegisterTable values(?,?,?,?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(query);
		pst.setInt(1, r.getId());
		pst.setString(2, r.getFirstName());
		pst.setString(3, r.getLastname());
		pst.setString(4, r.getUsername());
		pst.setString(5, r.getPassword());
		pst.setString(6, r.getContactNumber());
		pst.setString(7,r.getEmail());
		pst.setString(8,r.getAddress());
		pst.setString(9, r.getGender());
		pst.setString(10, r.getUserType());
		pst.setBoolean(11, r.isStatus());
		
		int x=pst.executeUpdate();
		
		return x;
		
	}
	
	
	
	public Login readCloudUser(String uname) throws SQLException {
	
		Login l=null;
		pst=connection.prepareStatement("select * from cloudusers where cuname=?");  
		pst.setString(1,uname);  
		ResultSet rs=pst.executeQuery();  
		if(rs.next()) {
			l=new Login();
		    l.setUserName(rs.getString(1));
		    l.setPassword(rs.getString(2));
		}
		return l;
	}
	
	public Login readDataOwner(String uname) throws SQLException {
		
		Login l=null;
		pst=connection.prepareStatement("select username,upassword from dataowners where username=? ");  
		pst.setString(1,uname);  
		ResultSet rs=pst.executeQuery();  
		if(rs.next()) {
			l=new Login();
		    l.setUserName(rs.getString(1));
		    l.setPassword(rs.getString(2));
		}
	
		return l;
	}
	
	public Login readDataUser(String uname) throws SQLException {
	    
	    Login l=null;
	    pst=connection.prepareStatement("select username,upassword from datausers where username=?");  
	    pst.setString(1,uname);  
	    ResultSet rs=pst.executeQuery();  
	    if(rs.next()) {
	      l=new Login();
	        l.setUserName(rs.getString(1));
	        l.setPassword(rs.getString(2));
	    }
	    return l;
	  }

	
	public static List<Registration> readDataOwners() throws SQLException{
		List<Registration> list=new ArrayList<Registration>();
		Registration r;
		pst=connection.prepareStatement("select * from RegisterTable where usertype = ?");  
        pst.setString(1,"Data Owner");  
        ResultSet rs=pst.executeQuery();  
        while(rs.next()){  
            r=new Registration();
            r.setId(rs.getInt(1));
            r.setFirstName(rs.getString(2));
            r.setLastname(rs.getString(3));
            r.setUsername(rs.getString(4));
            r.setPassword(rs.getString(5));
            r.setContactNumber(rs.getString(6));
            r.setEmail(rs.getString(7));
            r.setAddress(rs.getString(8));
            r.setGender(rs.getString(9));
            r.setUserType(rs.getString(10));
            r.setStatus(rs.getBoolean(11));
            list.add(r);
			}
        
	System.out.println(list);
        return list;

	}
	
	public static List<Registration> readDataUsers() throws SQLException{
		List<Registration> list=new ArrayList<Registration>();
		Registration r=null;
		pst=connection.prepareStatement("select * from RegisterTable where usertype = ?");  
        pst.setString(1,"Data User");  
        ResultSet rs=pst.executeQuery();  
        while(rs.next()){  
            r=new Registration();
            r.setId(rs.getInt(1));
            r.setFirstName(rs.getString(2));
            r.setLastname(rs.getString(3));
            r.setUsername(rs.getString(4));
            r.setPassword(rs.getString(5));
            r.setContactNumber(rs.getString(6));
            r.setEmail(rs.getString(7));
            r.setAddress(rs.getString(8));
            r.setGender(rs.getString(9));
            r.setUserType(rs.getString(10));
            r.setStatus(rs.getBoolean(11));
            list.add(r);
			}
        
	System.out.println(list);
        return list;

	}
	
	public Registration readRegisterdUser(int id) throws SQLException {
		
		Registration r=null;
		pst=connection.prepareStatement("select * from RegisterTable where id = ?");  
        pst.setInt(1,id);  
        ResultSet rs=pst.executeQuery();  
        if(rs.next()){  
            r=new Registration();
            r.setId(rs.getInt(1));
            r.setFirstName(rs.getString(2));
            r.setLastname(rs.getString(3));
            r.setUsername(rs.getString(4));
            r.setPassword(rs.getString(5));
            r.setContactNumber(rs.getString(6));
            r.setEmail(rs.getString(7));
            r.setAddress(rs.getString(8));
            r.setGender(rs.getString(9));
            r.setUserType(rs.getString(10));
            r.setStatus(rs.getBoolean(11)); 
            
			}
        	return r;

			}
	
	
public int dataOwnres(Registration r) throws SQLException{
		
		
		String query="insert into DataOwners values(?,?,?,?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(query);
		pst.setInt(1, r.getId());
		pst.setString(2, r.getFirstName());
		pst.setString(3, r.getLastname());
		pst.setString(4, r.getUsername());
		pst.setString(5, r.getPassword());
		pst.setString(6, r.getContactNumber());
		pst.setString(7,r.getEmail());
		pst.setString(8,r.getAddress());
		pst.setString(9, r.getGender());
		pst.setString(10, r.getUserType());
		pst.setBoolean(11, r.isStatus());
		
		int x=pst.executeUpdate();
		
		return x;
		
	}


public int dataUsers(Registration r) throws SQLException{
	
	
	String query="insert into DataUsers values(?,?,?,?,?,?,?,?,?,?,?)";
	pst=connection.prepareStatement(query);
	pst.setInt(1, r.getId());
	pst.setString(2, r.getFirstName());
	pst.setString(3, r.getLastname());
	pst.setString(4, r.getUsername());
	pst.setString(5, r.getPassword());
	pst.setString(6, r.getContactNumber());
	pst.setString(7,r.getEmail());
	pst.setString(8,r.getAddress());
	pst.setString(9, r.getGender());
	pst.setString(10, r.getUserType());
	pst.setBoolean(11, r.isStatus());
	
	int x=pst.executeUpdate();
	
	return x;
	
}

public void updateRegisteredUser(int x) throws SQLException{
	
	
	String query="update RegisterTable set rstatus=? where id=?";
	pst=connection.prepareStatement(query);
	pst.setBoolean(1, true);
	pst.setInt(2, x);
	
	
    pst.executeUpdate();
	

}

 public void UploadFileOwner(Fileowner f) throws SQLException {
	 
	 String query="insert into Uploadfile values (?, ?, ?, ?, ?, ?,?)";
      pst=connection.prepareStatement(query);
      pst.setInt(1,f.getId());
      pst.setString(2, f.getFileName());
      pst.setString(3,f.getKeyword());
      pst.setString(4, f.getFileOwner());
      pst.setBlob(5,f.getFile());
      pst.setDate(6,f.getUploadtime());
      pst.setString(7,f.getFileType());
      pst.executeUpdate();
      	  
	    
 }
 
 public static List<Fileowner> readFiledata(String owner) throws SQLException{
	 List<Fileowner> flist=new ArrayList<Fileowner>();
	 Fileowner f=null;
	 pst=connection.prepareStatement("select * from uploadfile where fileowner = ?"); 
	 pst.setString(1,owner);
	 
	 ResultSet rs=pst.executeQuery();
	 while(rs.next()) {
		 
		 f = new Fileowner();
		 f.setId(rs.getInt(1));
		 f.setFileName(rs.getString(2));
		 f.setKeyword(rs.getString(3));  
		 f.setFileOwner(rs.getString(4));
		 f.setUploadtime(rs.getDate(6));
		 
		 flist.add(f);
	 }
	 
	return flist;
	 

 }

 public static List<Fileowner> readviewFile() throws SQLException{
	 List<Fileowner> flist=new ArrayList<Fileowner>();
	 Fileowner f=null;
	 pst=connection.prepareStatement("select * from uploadfile"); 

	 
	 ResultSet rs=pst.executeQuery();
	 while(rs.next()) {
		 
		 f = new Fileowner();
		 f.setId(rs.getInt(1));
		 f.setFileName(rs.getString(2));
		 f.setKeyword(rs.getString(3));  
		 f.setFileOwner(rs.getString(4));
		 f.setUploadtime(rs.getDate(6));
		 
		 flist.add(f);
	 }
	 
	return flist;
	 

 }
 
 public static List<Fileowner> readsearchfile(String f) throws SQLException{
	 List<Fileowner> flist=new ArrayList<Fileowner>();
	 Fileowner fo=null;
	 pst=connection.prepareStatement("select * from uploadfile where keyword like ? "); 
     pst.setString(1, f + "%");
	 
	 ResultSet rs=pst.executeQuery();
	 while(rs.next()) {
		 
		 fo = new Fileowner();
		 fo.setId(rs.getInt(1));
		 fo.setFileName(rs.getString(2));
		 fo.setKeyword(rs.getString(3));  
		 fo.setFileOwner(rs.getString(4));
		 fo.setUploadtime(rs.getDate(6));
		 
		 flist.add(fo);
	 }
	 
	return flist;
	 

 }
 
 
 public static Fileowner readFileOwnerById(int id) throws SQLException{
	 
	 Fileowner fo=null;
	 pst=connection.prepareStatement("select * from uploadfile where id=?"); 
     pst.setInt(1,id);
	 
	 ResultSet rs=pst.executeQuery();
	 if(rs.next()) {
		 
		 fo = new Fileowner();
		 fo.setId(rs.getInt(1));
		 fo.setFileName(rs.getString(2));
		 fo.setKeyword(rs.getString(3));  
		 fo.setFileOwner(rs.getString(4));
		 fo.setUploadtime(rs.getDate(6));
		 
	
	 }
	 
	return fo;
 }

 public void requestFile(Fileowner f,String user) throws SQLException {
	 String query="insert into Requestfile values (?, ?, ?, ?, ?, ?,?)";
     pst=connection.prepareStatement(query);
     pst.setInt(1,f.getId());
     pst.setString(2, f.getFileName());
     pst.setString(3,f.getFileOwner());
     pst.setString(4, user);
     pst.setDate(5,f.getUploadtime());
     pst.setBoolean(6, f.isRequest());
     pst.setBoolean(7, f.isGenerate());
     pst.executeUpdate();
 }
	
 public static List<Fileowner> readRequestFiles() throws SQLException{
	 List<Fileowner> flist=new ArrayList<Fileowner>();
	 Fileowner fo=null;
	 pst=connection.prepareStatement("select * from Requestfile"); 
	 ResultSet rs=pst.executeQuery();
	 while(rs.next()) {
		 
		 fo = new Fileowner();
		 fo.setId(rs.getInt(1));
		 fo.setFileName(rs.getString(2));
		 fo.setFileOwner(rs.getString(3));
		 fo.setReqUser(rs.getString(4));
		 fo.setUploadtime(rs.getDate(5));
		 fo.setRequest(rs.getBoolean(6));
		 fo.setGenerate(rs.getBoolean(7));
		
		 
		 flist.add(fo);
	 }
	 
	return flist;
	 

 }
 
 public void update(int id) throws SQLException {
	 pst=connection.prepareStatement("update Requestfile set status=? where id=?");
	 pst.setBoolean(1, true);
	 pst.setInt(2, id);
	 pst.executeUpdate();
 }
 
public Fileowner getImage(int id) throws SQLException {
	Fileowner f=new Fileowner();
	pst=connection.prepareStatement("select ufile from uploadfile where id=?");
	pst.setInt(1, id);
	ResultSet rs=pst.executeQuery();
	 if(rs.next()) {
		
		 f.setId(rs.getInt(1));
		 f.setFileName(rs.getString(2));
		 f.setKeyword(rs.getString(3));  
		 f.setFileOwner(rs.getString(4));
		 f.setFile((InputStream)rs.getBlob(5));
		 f.setUploadtime(rs.getDate(6));
	 }
	return f;
}
}
