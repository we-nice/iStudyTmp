package com.nice.istudy.po;

public class User {
	
	private String studenetNo;
	private String password;
	private String name;
	private String nickName;
	private int role;
	private int isForbidden;
	private String imgsrc;
	
	public String getStudenetNo() {
		return studenetNo;
	}
	public void setStudenetNo(String studenetNo) {
		this.studenetNo = studenetNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getIsForbidden() {
		return isForbidden;
	}
	public void setIsForbidden(int isForbidden) {
		this.isForbidden = isForbidden;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	
	
}
