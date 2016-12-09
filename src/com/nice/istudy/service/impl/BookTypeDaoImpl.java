package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.BookType;
import com.nice.istudy.service.BookTypeDao;
import com.nice.istudy.utils.DBHelper;

public class BookTypeDaoImpl implements BookTypeDao{

	@Override
	public boolean addBookType(BookType bookType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="insert into bookType (name,modifyUser) values (?,?) ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bookType.getName());
			stmt.setInt(2, bookType.getModifyUser());
			
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
	public boolean deleteBookType(int id) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="delete from bookType where id= ? ";
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
	public boolean updateBookType(BookType bookType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="update  bookType set name=?,modifyUser=? where id=? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, bookType.getName());
			stmt.setInt(2, bookType.getModifyUser());
			stmt.setInt(3, bookType.getId());
			
		//	System.out.println(bookType.toString());
			
			
			
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

	@Override
	public List<BookType> SelectAllBookType() {
		// TODO Auto-generated method stub
	   List<BookType> bookTypeList=new ArrayList<BookType>();
    	
 	   
 	   Connection connection=null;
 	   PreparedStatement preparedStatement=null;
 	   ResultSet resultSet=null;
 	   
 	  
       try {
			connection=(Connection) DBHelper.getConnection();
			  String sql="select * from bookType";
			  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
	          resultSet=preparedStatement.executeQuery();
	      //    System.out.println(resultSet.next());
	          while (resultSet.next()) {
	        	  BookType bookType=new BookType();
				  int id= resultSet.getInt(1);
				  String name=resultSet.getString(2);
				  int modifyUser=resultSet.getInt(3);
				  
				  bookType.setId(id);
				  bookType.setName(name);
				  bookType.setModifyUser(modifyUser);
				  bookTypeList.add(bookType);
				
				
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

 	   return bookTypeList;
	}

	@Override
	public BookType selectBookTypeById(int id) {
		// TODO Auto-generated method stub
	   BookType bookType=null;
 	   Connection connection=null;
 	   PreparedStatement preparedStatement=null;
 	   ResultSet resultSet=null;
  
 	   try {
			connection=(Connection) DBHelper.getConnection();
			   String sql="select * from bookType where id=?";
			   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			   
			   preparedStatement.setInt(1, id);
			   resultSet=preparedStatement.executeQuery();
			   if (resultSet.next()) {
	        	  bookType= new BookType();
				  
				  String name=resultSet.getString(2);
				  int modifyUser=resultSet.getInt(3);
				  
				  bookType.setId(id);
				  bookType.setName(name);
				  bookType.setModifyUser(modifyUser);
				 
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
 	  return bookType;
		
	}

	
	
}
