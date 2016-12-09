package com.nice.istudy.entity;

import java.sql.Timestamp;


/*
 create table problem (
 id int unsigned not null auto_increment primary key,
 type int not null,
 title varchar(30),
 content text,
 author varchar(10),
 writeTime date
) engine InnoDB charset utf8;
 */

public class Problem {
	int id;
	int type;
	String title;
	String content;
	String author;
	Timestamp writeTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Timestamp getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", type=" + type + ", title=" + title
				+ ", content=" + content + ", author=" + author
				+ ", writeTime=" + writeTime + "]";
	}
	
}
