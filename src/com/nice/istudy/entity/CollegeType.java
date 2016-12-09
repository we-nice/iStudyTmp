package com.nice.istudy.entity;

/*
create table collegeType (
id int unsigned not null auto_increment primary key,
name varchar(20) not null,
modifyUser int not null,
father int not null default 0
) engine InnoDB charset utf8;
 */

public class CollegeType {
	int id;
	String name;
	int modifyUser;
	int father;
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
	public int getFather() {
		return father;
	}
	public void setFather(int father) {
		this.father = father;
	}
	@Override
	public String toString() {
		return "CollegeType [id=" + id + ", name=" + name + ", modifyUser="
				+ modifyUser + ", father=" + father + "]";
	}
	
}
