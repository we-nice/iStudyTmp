package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.nice.istudy.entity.CollegeType;
import com.nice.istudy.service.CollegeTypeDao;
import com.nice.istudy.utils.DBHelper;

public class CollegeTypeDaoImpl implements CollegeTypeDao{

	@Override
	public boolean addCollegeType(CollegeType collegeType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="insert into collegeType (name,modifyUser,father) values (?,?,?) ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, collegeType.getName());
			stmt.setInt(2, collegeType.getModifyUser());
			stmt.setInt(3, collegeType.getFather());
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
	public boolean deleteCollegeType(int id) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="delete from collegeType where id= ? ";
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
	public boolean updateCollegeType(CollegeType collegeType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="update  collegeType set name=?,modifyUser=?,father=? where id=? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, collegeType.getName());
			stmt.setInt(2, collegeType.getModifyUser());
			stmt.setInt(4, collegeType.getId());
			stmt.setInt(3, collegeType.getFather());
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
	public List<CollegeType> selectAllCollegeType() {
		// TODO Auto-generated method stub
		   List<CollegeType> collegeTypeList=new ArrayList<CollegeType>();
	    	
	 	   
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	 	   
	 	  
	       try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from collegeType";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		          while (resultSet.next()) {
		        	  CollegeType collegeType=new CollegeType();
					  int id= resultSet.getInt(1);
					  String name=resultSet.getString(2);
					  int modifyUser=resultSet.getInt(3);
					  
					  collegeType.setId(id);
					  collegeType.setName(name);
					  collegeType.setModifyUser(modifyUser);
					  collegeTypeList.add(collegeType);
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

	 	  	return collegeTypeList;
	}

	@Override
	public CollegeType selectCollegeTypeById(int id) {
		// TODO Auto-generated method stub
		   CollegeType collegeType=null;
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	  
	 	   try {
				   connection=(Connection) DBHelper.getConnection();
				   String sql="select * from collegeType where id=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				   preparedStatement.setInt(1, id);
				   resultSet=preparedStatement.executeQuery();
				   if (resultSet.next()) {
		        	  collegeType= new CollegeType();
					  
					  String name=resultSet.getString(2);
					  int modifyUser=resultSet.getInt(3);
					  
					  collegeType.setId(id);
					  collegeType.setName(name);
					  collegeType.setModifyUser(modifyUser);
					 
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
	 	  return collegeType;
			
	}

	
	
}
