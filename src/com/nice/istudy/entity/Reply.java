package com.nice.istudy.entity;

import java.util.Date;

/*
 create table reply (
 id int unsigned not null auto_increment primary key,
 author varchar(30) ,
 problemID int not null,
 content text,
 isExcellent tinyint(1),
 writeTime date
) engine InnoDB charset utf8;

 */
public class Reply {
	int id;
	String author;
	int problemID;
	String content;
	int isExcellent;
	Date writeTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getProblemID() {
		return problemID;
	}
	public void setProblemID(int problemID) {
		this.problemID = problemID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsExcellent() {
		return isExcellent;
	}
	public void setIsExcellent(int isExcellent) {
		this.isExcellent = isExcellent;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	@Override
	public String toString() {
		return "Reply [id=" + id + ", author=" + author + ", problemID="
				+ problemID + ", content=" + content + ", isExcellent="
				+ isExcellent + ", writeTime=" + writeTime + "]";
	}
	
	
}
