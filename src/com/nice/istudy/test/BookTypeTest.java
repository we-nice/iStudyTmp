package com.nice.istudy.test;


import java.util.List;


import com.nice.istudy.entity.BookType;
import com.nice.istudy.service.BookTypeDao;
import com.nice.istudy.service.impl.BookTypeDaoImpl;

public class BookTypeTest {
	
	BookTypeDao bookTypeDao = new BookTypeDaoImpl();
	
	public void addBookType(){
		BookType bookType=new BookType();
        
    	bookType.setName("admin");
    	bookType.setModifyUser(666);
    	   
    	System.out.println(bookTypeDao.addBookType(bookType));
	}
	
	public void deleteBookType(){
		System.out.println(bookTypeDao.deleteBookType(1));
	}
	
	public void updateBookType(){
		BookType bookType=new BookType();
        bookType.setId(1);
    	bookType.setName("admin1");
    	bookType.setModifyUser(888);
    	System.out.println(bookTypeDao.updateBookType(bookType));
	}
	
	public void selectAllBookType(){
		List<BookType> list =bookTypeDao.SelectAllBookType();
		
		System.out.println(list.size());
		
		for(BookType b:list){
			System.out.println(b.toString());
		}	
	}
	
	public void selectBookTypeById(){
		BookType bookType = bookTypeDao.selectBookTypeById(1);
		System.out.println(bookType);
	}
	
	public static void main(String[] args) {
		BookTypeTest bookTypeTest=new BookTypeTest();
	//	bookTypeTest.addBookType();
	//	bookTypeTest.deleteBookType();
	//	bookTypeTest.updateBookType();
	//	bookTypeTest.selectAllBookType();
		bookTypeTest.selectBookTypeById();
	}
}
