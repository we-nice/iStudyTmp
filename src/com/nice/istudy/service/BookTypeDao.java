package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.BookType;

public interface BookTypeDao {
	
	public boolean addBookType(BookType bookType);
	
	public boolean deleteBookType(int id);
	
	public boolean updateBookType(BookType bookType);
	
	public List<BookType> SelectAllBookType();
	
	public BookType selectBookTypeById(int id);
}
