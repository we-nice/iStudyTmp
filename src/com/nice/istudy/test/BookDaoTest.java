package com.nice.istudy.test;

import java.util.List;

import com.nice.istudy.entity.Book;
import com.nice.istudy.service.BookDao;
import com.nice.istudy.service.impl.BookDaoImpl;

public class BookDaoTest {
	
	BookDao bookDao = new BookDaoImpl();
	
	public void addBook()
	{
		Book book = new Book();
		book.setBookId(1234);
		book.setBookName("ศํนค");
		book.setTypeId(1);
		book.setPrice(100);
		book.setAuthor("zhangsan");
		book.setTotal(3);
		System.out.println(bookDao.addBook(book));
	}
	
	public void deleteBook()
	{
		System.out.println(bookDao.deleteBook(2));
	}
	
	public void selectAllBook()
	{
		List<Book> bookList = bookDao.selectAllBooks();
		
		for(Book b:bookList){
			System.out.println(b.toString());
		}
		
	}
	
	public void selectBookById()
	{
		Book book = bookDao.selectBookById(1);
		System.out.println(book.toString());
	}
	
	public void selectBookByBookName()
	{
		List<Book> bookList = bookDao.selectBookByBookName("ศํนค");
		for(Book b:bookList){
			System.out.println(b.toString());
		}
	}
	
	public void selectBookByTypeId()
	{
		List<Book> bookList = bookDao.selectBookByTypeId(1);
		System.out.println(bookList.size());
		for(Book b:bookList){
			System.out.println(b.toString());
		}
	}
	
	public static void main(String[] args) {
		BookDaoTest bookDaoTest = new BookDaoTest();
		
	//	bookDaoTest.addBook();
	//	bookDaoTest.deleteBook();
	//	bookDaoTest.selectAllBook();
	//	bookDaoTest.selectBookById();
		bookDaoTest.selectBookByBookName();
	//	bookDaoTest.selectBookByTypeId();
	}
	
}
