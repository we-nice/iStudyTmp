package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.nice.istudy.entity.ProblemType;
import com.nice.istudy.service.ProblemTypeDao;
import com.nice.istudy.utils.DBHelper;

public class ProblemTypeDaoImpl implements ProblemTypeDao{

	@Override
	public boolean addProblemType(ProblemType problemType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="insert into problemType (name,modifyUser) values (?,?) ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, problemType.getName());
			stmt.setInt(2, problemType.getModifyUser());
			
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
	public boolean deleteProblemType(int id) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="delete from problemType where id= ? ";
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
	public boolean updateProblemType(ProblemType problemType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="update  problemType set name=?,modifyUser=? where id=? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, problemType.getName());
			stmt.setInt(2, problemType.getModifyUser());
			stmt.setInt(3, problemType.getId());
			
		//	System.out.println(problemType.toString());
			
			
			
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
	public List<ProblemType> SelectAllProblemType() {
		// TODO Auto-generated method stub
		List<ProblemType> problemTypeList=new ArrayList<ProblemType>();
    	
	 	   
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	 	   
	 	  
	       try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from problemType";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		      //    System.out.println(resultSet.next());
		          while (resultSet.next()) {
		        	  ProblemType problemType=new ProblemType();
					  int id= resultSet.getInt(1);
					  String name=resultSet.getString(2);
					  int modifyUser=resultSet.getInt(3);
					  
					  problemType.setId(id);
					  problemType.setName(name);
					  problemType.setModifyUser(modifyUser);
				// System.out.println(userType.toString());
					  problemTypeList.add(problemType);
					
					
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

	 	   return problemTypeList;
	}

	@Override
	public ProblemType selectProblemTypeById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		   ProblemType problemType = new ProblemType();
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	  
	 	   try {
				connection=(Connection) DBHelper.getConnection();
				   String sql="select * from problemType where id=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				    preparedStatement.setInt(1, id);
				    resultSet=preparedStatement.executeQuery();
				    if (resultSet.next()) {
		        	  
					  
					  String name=resultSet.getString(2);
					  int modifyUser=resultSet.getInt(3);
					  
					  problemType.setId(id);
					  problemType.setName(name);
					  problemType.setModifyUser(modifyUser);
				 
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
	 	  
			return problemType;
	}

	
	
	
}
