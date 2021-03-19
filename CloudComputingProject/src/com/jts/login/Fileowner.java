package com.jts.login;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

public class Fileowner {
	
	int id;
	String FileOwner;
    String FileName;
    String Keyword;
	InputStream File;
	boolean request;
	boolean generate;
	String ReqUser;
	String fileType;
	
	
	
    public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getReqUser() {
		return ReqUser;
	}
	public void setReqUser(String reqUser) {
		ReqUser = reqUser;
	}
	public boolean isGenerate() {
		return generate;
	}
	public void setGenerate(boolean generate) {
		this.generate = generate;
	}
	public boolean isRequest() {
		return request;
	}
	public void setRequest(boolean request) {
		this.request = request;
	}
	public InputStream getFile() {
		return File;
	}
	public void setFile(InputStream file) {
		File = file;
	}
	Date Uploadtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileOwner() {
		return FileOwner;
	}
	public void setFileOwner(String fileOwner) {
		FileOwner = fileOwner;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getKeyword() {
		return Keyword;
	}
	public void setKeyword(String keyword) {
		Keyword = keyword;
	}
	
	public Date getUploadtime() {
		return Uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		Uploadtime = uploadtime;
	}
}
