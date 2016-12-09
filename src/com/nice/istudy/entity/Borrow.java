package com.nice.istudy.entity;

import java.util.Date;

/*
create table borrow (
 id int unsigned not null auto_increment primary key,
 bookId varchar(20) not null unique key,
 bookName varchar(30),
 startTime date,
 lastTime date,
 studentNo char(9) not null,
 book_num int,
 isReturn tinyint(1)
) engine InnoDB charset utf8;
 */



public class Borrow {
	int id;
	String bookId;
	String bookName;
	Date startTime;
	Date lastTime;
	String studentNo;
	int book_num;
	int isReturn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(int isReturn) {
		this.isReturn = isReturn;
	}
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", bookId=" + bookId + ", bookName="
				+ bookName + ", startTime=" + startTime + ", lastTime="
				+ lastTime + ", studentNo=" + studentNo + ", book_num="
				+ book_num + ", isReturn=" + isReturn + "]";
	}
	
	
}


