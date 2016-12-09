package com.nice.istudy.service.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.Problem;

 
import com.nice.istudy.service.ProblemDao;

import com.nice.istudy.utils.DBHelper;



public class ProblemDaoImpl implements ProblemDao{

	@Override
	public boolean addProblem(Problem problem) {
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "insert into problem (type,title,content,author,writeTime) " +
					"values (?,?,?,?,? ) ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, problem.getType());
		 	stmt.setString(2, problem.getTitle());
		 	stmt.setString(3, problem.getContent());
		 	stmt.setString(4, problem.getAuthor());
		 	stmt.setTimestamp(5, problem.getWriteTime());
	 
			 
			int i=stmt.executeUpdate();
        	if(i==0){
        		return false;
        	}
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{  
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
		
		
		return true;
	}

	@Override
	public boolean deleteProblem(int id) {
		Connection connection=null;
    	PreparedStatement preparedStatement=null;
    	
    	try {
			connection=(Connection) DBHelper.getConnection();
			String sql="delete from problem where id= ? ";
		    preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		    preparedStatement.setInt(1, id);
		    int i=preparedStatement.executeUpdate();
			if(i==0)
			{
				return false;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(preparedStatement!=null){
				  try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
			}
			
			
		}
    	
    	
    	return true;
			
			 
	}

	@Override
	public List<Problem> selectAllProblems() {
		List<Problem> listProblems=new ArrayList<Problem>();
	   	   Connection connection=null;
	   	   PreparedStatement preparedStatement=null;
	   	   ResultSet resultSet=null;
	   	   
	   	  
	         try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from problem";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		         
		          while (resultSet.next()) {
		        	   Problem  problem=new Problem();
		        	   int id=resultSet.getInt(1);
		        	   int type=resultSet.getInt(2);
					   String title=resultSet.getString(3);
					   String content=resultSet.getString(4);
					   String author=resultSet.getString(5);
					   Timestamp writeTime=resultSet.getTimestamp(6);
					  
	 
					   problem.setId(id);
					   problem.setType(type);
					   problem.setTitle(title);
					   problem.setContent(content);
					   problem.setAuthor(author);
					   problem.setWriteTime(writeTime);
					  
		 
					 
					   listProblems.add(problem);
					
					
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
	       
	   	   
	   	   
	   	  
	   	   return listProblems;
	}

	@Override
	public Problem selectProblemById(int id) {
		 Problem problem =null;
  	   Connection connection=null;
  	   PreparedStatement preparedStatement=null;
  	   ResultSet resultSet=null;
   
  	   try {
			connection=(Connection) DBHelper.getConnection();
			   String sql="select * from problem  where id=?";
			   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			   
			    preparedStatement.setInt(1, id);
			    resultSet=preparedStatement.executeQuery();
			   if (resultSet.next()) {
				   
				    problem=new Problem();
	        	  // int id=resultSet.getInt(1);
	        	   int type=resultSet.getInt(2);
				   String title=resultSet.getString(3);
				   String content=resultSet.getString(4);
				   String author=resultSet.getString(5);
				   Timestamp writeTime=resultSet.getTimestamp(6);
				  
 
				   problem.setId(id);
				   problem.setType(type);
				   problem.setTitle(title);
				   problem.setContent(content);
				   problem.setAuthor(author);
				   problem.setWriteTime(writeTime);
				  
				   
				  
			 
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
  	  
		return problem;
	}

	@Override
	public List<Problem> selectProblemByProblemTypeId(int problemTypeId) {
		List<Problem> listProblems=new ArrayList<Problem>();
	   	   Connection connection=null;
	   	   PreparedStatement preparedStatement=null;
	   	   ResultSet resultSet=null;
	   	   
	   	  
	         try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from problem where type=?";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				  preparedStatement.setInt(1, problemTypeId);
		          resultSet=preparedStatement.executeQuery();
		         
		          while (resultSet.next()) {
		        	   Problem  problem=new Problem();
		        	   int id=resultSet.getInt(1);
		        	   int type=resultSet.getInt(2);
					   String title=resultSet.getString(3);
					   String content=resultSet.getString(4);
					   String author=resultSet.getString(5);
					   Timestamp writeTime=resultSet.getTimestamp(6);
					  
	 
					   problem.setId(id);
					   problem.setType(type);
					   problem.setTitle(title);
					   problem.setContent(content);
					   problem.setAuthor(author);
					   problem.setWriteTime(writeTime);
					  
		 
					 
					   listProblems.add(problem);
					
					
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
	       
	   	   
	   	   
	   	  
	   	   return listProblems;
	}
  
	
	
}
