package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.Book;

import com.nice.istudy.service.BookDao;
import com.nice.istudy.utils.DBHelper;

public class BookDaoImpl implements BookDao{

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="insert into book (bookId,bookName,typeId,author,price,total) values (?,?,?,?,?,?) ";
			stmt = conn.prepareStatement(sql);			
			stmt.setInt(1,book.getBookId());
			stmt.setString(2, book.getBookName());
			stmt.setInt(3, book.getTypeId());
			stmt.setString(4, book.getAuthor());
			stmt.setInt(5, book.getPrice());
			stmt.setInt(6, book.getTotal());
			if(stmt.executeUpdate()==0) return false;
			else return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			//释放数据集对象
			if(rs!=null){
				try{
					rs.close();
					rs=null;
				}catch(Exception e)
				{
					e.printStackTrace();
					
				}
			}
			
			if(stmt!=null){
				try{
					stmt.close();
					stmt=null;
				}catch(Exception e)
				{
					e.printStackTrace();
					
				}
			}
			
		}
		
		
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="delete from book where id= ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			if(stmt.executeUpdate()==0) return false;
			else return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			//释放数据集对象
			if(rs!=null){
				try{
					rs.close();
					rs=null;
				}catch(Exception e)
				{
					e.printStackTrace();
					
				}
			}
			
			if(stmt!=null){
				try{
					stmt.close();
					stmt=null;
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}

	}

	@Override
	public List<Book> selectAllBooks() {
		// TODO Auto-generated method stub
		
		   List<Book> bookList=new ArrayList<Book>();
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	 	   
	 	  
	       try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from book";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		      //    System.out.println(resultSet.next());
		          while (resultSet.next()) {
		        	  Book book=new Book();
					  int id= resultSet.getInt(1);
					  int bookId = resultSet.getInt(2);
					  String bookName = resultSet.getString(3);
					  int typeId = resultSet.getInt(4);
					  String author = resultSet.getString(5);
					  int total = resultSet.getInt(6);
					  book.setId(id);
					  book.setBookId(bookId);
					  book.setBookName(bookName);
					  book.setTypeId(typeId);
					  book.setAuthor(author);
					  book.setTotal(total);
					  bookList.add(book);
				}
		          
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(resultSet!=null){
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(preparedStatement!=null){
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

	 	   return bookList;
	}

	@Override
	public List<Book> selectBookByBookName(String name) {
		// TODO Auto-generated method stub
		List<Book> bookList=new ArrayList<Book>();
		   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	  
	 	   try {
				connection=(Connection) DBHelper.getConnection();
				   String sql="select * from book where bookName=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				   preparedStatement.setString(1, name);
				   resultSet=preparedStatement.executeQuery();
				   while (resultSet.next()) {
		        	  Book book= new Book();
					  
		        	  int id = resultSet.getInt(1);
					  int bookId = resultSet.getInt(2);
					  String bookName = resultSet.getString(3);
					  int typeId = resultSet.getInt(4);
					  String author = resultSet.getString(5);
					  int total = resultSet.getInt(6);
					  int loan_num = resultSet.getInt(7);
					  String description = resultSet.getString(8);
					  int isRecommend = resultSet.getInt(9);
					  book.setId(id);
					  book.setBookId(bookId);
					  book.setBookName(bookName);
					  book.setTypeId(typeId);
					  book.setAuthor(author);
					  book.setTotal(total);
					  book.setLoan_num(loan_num);
					  book.setDescription(description);
					  book.setIsRecommend(isRecommend);
					  bookList.add(book);
				   }
				   
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(resultSet!=null){
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(preparedStatement!=null){
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
	 	  return bookList;
	}

	@Override
	public List<Book> selectBookByTypeId(int typeId) {
		// TODO Auto-generated method stub
		   List<Book> bookList=new ArrayList<Book>();
		   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	  
	 	   try {
				connection=(Connection) DBHelper.getConnection();
				   String sql="select * from book where typeid=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				   preparedStatement.setInt(1, typeId);
				   resultSet=preparedStatement.executeQuery();
				   while (resultSet.next()) {
		        	  Book book= new Book();
					  
		        	  int id = resultSet.getInt(1);
					  int bookId = resultSet.getInt(2);
					  String bookName = resultSet.getString(3);
					  String author = resultSet.getString(5);
					  int total = resultSet.getInt(6);
					  int loan_num = resultSet.getInt(7);
					  String description = resultSet.getString(8);
					  int isRecommend = resultSet.getInt(9);
					  book.setId(id);
					  book.setBookId(bookId);
					  book.setBookName(bookName);
					  book.setTypeId(typeId);
					  book.setAuthor(author);
					  book.setTotal(total);
					  book.setLoan_num(loan_num);
					  book.setDescription(description);
					  book.setIsRecommend(isRecommend);
					  bookList.add(book);
				   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(resultSet!=null){
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(preparedStatement!=null){
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
	 	  return bookList;
	}

	@Override
	public Book selectBookById(int id) {
		// TODO Auto-generated method stub
		   Book book=null;
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	  
	 	   try {
				connection=(Connection) DBHelper.getConnection();
				   String sql="select * from book where id=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				   preparedStatement.setInt(1, id);
				   resultSet=preparedStatement.executeQuery();
				   if (resultSet.next()) {
		        	  book= new Book();
					  
		        	  
					  int bookId = resultSet.getInt(2);
					  String bookName = resultSet.getString(3);
					  int typeId = resultSet.getInt(4);
					  String author = resultSet.getString(5);
					  int total = resultSet.getInt(6);
					  int loan_num = resultSet.getInt(7);
					  String description = resultSet.getString(8);
					  int isRecommend = resultSet.getInt(9);
					  book.setId(id);
					  book.setBookId(bookId);
					  book.setBookName(bookName);
					  book.setTypeId(typeId);
					  book.setAuthor(author);
					  book.setTotal(total);
					  book.setLoan_num(loan_num);
					  book.setDescription(description);
					  book.setIsRecommend(isRecommend);
				   }
				   else return null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(resultSet!=null){
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(preparedStatement!=null){
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
	 	  return book;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="update  bookType set bookId=?,bookName=?,typeId=?,price=?,author=?,total=? where id=? ";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, book.getBookId());
			stmt.setString(2, book.getBookName());
			stmt.setInt(3, book.getTypeId());
			stmt.setInt(4, book.getPrice());
			stmt.setString(5, book.getAuthor());
			stmt.setInt(6, book.getTotal());
			if(stmt.executeUpdate()<=0) return false;
			else return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			//释放数据集对象
			if(rs!=null){
				try{
					rs.close();
					rs=null;
				}catch(Exception e)
				{
					e.printStackTrace();
					
				}
			}
			
			if(stmt!=null){
				try{
					stmt.close();
					stmt=null;
				}catch(Exception e)
				{
					e.printStackTrace();
					
				}
			}
			
		}
	}

}
