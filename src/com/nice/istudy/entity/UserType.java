package com.nice.istudy.entity;

/*
 create table userType (
id int unsigned not null auto_increment primary key,
name varchar(20) not null,
modifyUser int not null
) engine InnoDB charset utf8;

 */

public class UserType {
	int id;
	String name;
	int modifyUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(int modifyUser) {
		this.modifyUser = modifyUser;
	}
	
}
