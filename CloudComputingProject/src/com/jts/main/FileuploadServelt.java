package com.jts.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jts.DAO.MainDAO;
import com.jts.login.Fileowner;
import com.jts.login.Login;

@WebServlet("/FileuploadServlet")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class FileuploadServelt extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MainDAO m = new MainDAO();

		Fileowner f = new Fileowner();

		// gets values of text fields

		f.setFileName(request.getParameter("filename"));
		f.setKeyword(request.getParameter("keyword"));
		HttpSession s=request.getSession();
		Login x=(Login)s.getAttribute("dataowner");
		f.setFileOwner(x.getUserName());
		f.setFileType(request.getParameter("doctype"));
		
		//f.setRequest(false);

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);
		f.setUploadtime(sqlDate);

		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("file");
		if (filePart != null) {

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}

		f.setFile(inputStream);

		try {
			m.UploadFileOwner(f);
			request.setAttribute("message", "Sucessfully Added");
			request.getRequestDispatcher("HomePageowner.jsp").include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// sets the message in request scope
//			request.setAttribute("Message", message);
//
//			// forwards to the message page
//			getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	}
}
