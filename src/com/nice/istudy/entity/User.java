package com.nice.istudy.entity;

public class User {
	private int id;
	private String studentNo;
	private String password;
	private String name;
	private String nickName;
	private String email;
	private String college;
	private int role;
	private int isForbidden;
	private String imgsrc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", studentNo=" + studentNo + ", password="
				+ password + ", name=" + name + ", nickName=" + nickName
				+ ", email=" + email + ", college=" + college + ", role="
				+ role + ", isForbidden=" + isForbidden + ", imgsrc=" + imgsrc
				+ "]";
	}
	
	
	
	
	
}
