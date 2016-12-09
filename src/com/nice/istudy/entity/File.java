package com.nice.istudy.entity;
/*
 create table file (
 id int unsigned not null auto_increment primary key,
 name varchar(20) not null,
 description varchar(30),
 size int,
 author varchar(10),
 isDel tinyint(1),
 src varchar(30),
 college int not null,
 subject int not null
) engine InnoDB charset utf8;
 */
public class File {
	int id;
	String name;
	String description;
	int size;
	String author;
	int isDel;
	String src;
	int college;
	int subject;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public int getCollege() {
		return college;
	}
	public void setCollege(int college) {
		this.college = college;
	}
	public int getSubject() {
		return subject;
	}
	public void setSubject(int subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", description="
				+ description + ", size=" + size + ", author=" + author
				+ ", isDel=" + isDel + ", src=" + src + ", college=" + college
				+ ", subject=" + subject + "]";
	}
	
}
