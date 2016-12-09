package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.Book;

public interface BookDao {
	
	public boolean addBook(Book book);
	
	public boolean deleteBook(int id);
	
	public boolean updateBook(Book book);
	
	public List<Book> selectAllBooks();
	
	public List<Book> selectBookByBookName(String name);
	
	public List<Book> selectBookByTypeId(int typeId);
	
	public Book selectBookById(int id);
	
}
