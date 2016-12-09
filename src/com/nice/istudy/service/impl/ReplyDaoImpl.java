package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.Reply;

import com.nice.istudy.service.ReplyDao;

import com.nice.istudy.utils.DBHelper;



public class ReplyDaoImpl implements ReplyDao{

	@Override
	public boolean addReply(Reply reply) {
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "insert into reply (author,problemID,content,isExcellent,writeTime) " +
					"values (?,?,?,?,? ) ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, reply.getAuthor());
		 	stmt.setInt(2, reply.getProblemID());
		 	stmt.setString(3, reply.getContent());
		 	stmt.setInt(4, reply.getIsExcellent());
		 	stmt.setDate(5, (Date) reply.getWriteTime());
	 
			 
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
	public boolean deleteReply(int id) {
		Connection connection=null;
    	PreparedStatement preparedStatement=null;
    	
    	try {
			connection=(Connection) DBHelper.getConnection();
			String sql="delete from reply where id= ? ";
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
	public List<Reply> selectAllReplys() {
		List<Reply> listReplys=new ArrayList<Reply>();
	   	   Connection connection=null;
	   	   PreparedStatement preparedStatement=null;
	   	   ResultSet resultSet=null;
	   	   
	   	  
	         try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from reply";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		       
		          while (resultSet.next()) {
		        	   Reply  reply=new Reply();
		        	   int id=resultSet.getInt(1);
		        	   String author=resultSet.getString(2);
					   int problemID=resultSet.getInt(3);
					   String content=resultSet.getString(4);
					   int isExcellent=resultSet.getInt(5);
					   Date writeTime=resultSet.getDate(6);
					  
	 
					   reply.setId(id);
					   reply.setAuthor(author);
					   reply.setProblemID(problemID);
					   reply.setContent(content);
					   reply.setIsExcellent(isExcellent);
					   reply.setWriteTime(writeTime);
		 
					 
					   listReplys.add(reply);
					
					
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
	       
	   	   
	   	   
	   	  
	   	   return listReplys;
	}

	@Override
	public Reply selectReplyById(int id) {
		 Reply reply =null;
  	   Connection connection=null;
  	   PreparedStatement preparedStatement=null;
  	   ResultSet resultSet=null;
   
  	   try {
			connection=(Connection) DBHelper.getConnection();
			   String sql="select * from reply  where id=?";
			   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			   
			    preparedStatement.setInt(1, id);
			    resultSet=preparedStatement.executeQuery();
			   if (resultSet.next()) {
				   
				    reply=new Reply();
				    //int id=resultSet.getInt(1);
		        	   String author=resultSet.getString(2);
					   int problemID=resultSet.getInt(3);
					   String content=resultSet.getString(4);
					   int isExcellent=resultSet.getInt(5);
					   Date writeTime=resultSet.getDate(6);
					  
	 
					   reply.setId(id);
					   reply.setAuthor(author);
					   reply.setProblemID(problemID);
					   reply.setContent(content);
					   reply.setIsExcellent(isExcellent);
					   reply.setWriteTime(writeTime);
		 				   
				  
			 
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
  	  
		return reply;
	}

	@Override
	public List<Reply> selectReplyByProblemId(int problemId) {
		List<Reply> listReplys=new ArrayList<Reply>();
	   	   Connection connection=null;
	   	   PreparedStatement preparedStatement=null;
	   	   ResultSet resultSet=null;
	   	   
	   	  
	         try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from reply where problemId=?";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				  preparedStatement.setInt(1, problemId);
		          resultSet=preparedStatement.executeQuery();
		        
		          while (resultSet.next()) {
		        	   Reply  reply=new Reply();
		        	   int id=resultSet.getInt(1);
		        	   String author=resultSet.getString(2);
					   int problemID=resultSet.getInt(3);
					   String content=resultSet.getString(4);
					   int isExcellent=resultSet.getInt(5);
					   Date writeTime=resultSet.getDate(6);
					  
	 
					   reply.setId(id);
					   reply.setAuthor(author);
					   reply.setProblemID(problemID);
					   reply.setContent(content);
					   reply.setIsExcellent(isExcellent);
					   reply.setWriteTime(writeTime);
		 
		 
					 
					   listReplys.add(reply);
					
					
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
	       
	   	   
	   	   
	   	  
	   	   return listReplys;
	}

	 
	
	
}
