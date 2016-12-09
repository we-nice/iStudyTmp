package com.nice.istudy.entity;


/*
 *  id int unsigned not null auto_increment primary key,
 bookId varchar(20) not null unique key,
 bookName varchar(30),
 typeId int not null,
 author varchar(10),
 price int,
 total int,
 loan_num int,
 desciption varchar(255),
 isRecommend tinyint(1),
 book_imgsrc varchar(30)
 * */

public class Book {
	int id;
	int bookId;
	String bookName;
	int typeId;
	String author;
	int price;
	int total;
	int loan_num;
	String description;
	int isRecommend;
	String book_imgsrc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLoan_num() {
		return loan_num;
	}
	public void setLoan_num(int loan_num) {
		this.loan_num = loan_num;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}
	public String getBook_imgsrc() {
		return book_imgsrc;
	}
	public void setBook_imgsrc(String book_imgsrc) {
		this.book_imgsrc = book_imgsrc;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookId=" + bookId + ", bookName="
				+ bookName + ", typeId=" + typeId + ", author=" + author
				+ ", price=" + price + ", total=" + total + ", loan_num="
				+ loan_num + ", description=" + description + ", isRecommend="
				+ isRecommend + ", book_imgsrc=" + book_imgsrc + "]";
	}
	
	
	
	
}
