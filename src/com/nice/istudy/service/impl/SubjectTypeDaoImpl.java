package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.SubjectType;
import com.nice.istudy.service.SubjectTypeDao;
import com.nice.istudy.utils.DBHelper;

public class SubjectTypeDaoImpl implements SubjectTypeDao{

	@Override
	public boolean addSubjectType(SubjectType subjectType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="insert into subjectType (name,modifyUser) values (?,?) ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, subjectType.getName());
			stmt.setInt(2, subjectType.getModifyUser());
			
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
	public boolean deleteSubjectType(int id) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="delete from subjectType where id= ? ";
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
	public boolean updateSubjectType(SubjectType subjectType) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="update  subjectType set name=?,modifyUser=? where id=? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, subjectType.getName());
			stmt.setInt(2, subjectType.getModifyUser());
			stmt.setInt(3, subjectType.getId());
			
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
	public List<SubjectType> selectAllSubjectType() {
		// TODO Auto-generated method stub
			List<SubjectType> subjectTypeList=new ArrayList<SubjectType>();
    	
	 	   
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	 	   
	 	  
	       try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from subjectType";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		      //    System.out.println(resultSet.next());
		          while (resultSet.next()) {
		        	  SubjectType subjectType=new SubjectType();
					  int id= resultSet.getInt(1);
					  String name=resultSet.getString(2);
					  int modifyUser=resultSet.getInt(3);
					  
					  subjectType.setId(id);
					  subjectType.setName(name);
					  subjectType.setModifyUser(modifyUser);
					  subjectTypeList.add(subjectType);
					
					
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

	 	   return subjectTypeList;
	}

	@Override
	public SubjectType selectSubjectTypeById(int id) {
		// TODO Auto-generated method stub
		   SubjectType subjectType=null;
	 	   Connection connection=null;
	 	   PreparedStatement preparedStatement=null;
	 	   ResultSet resultSet=null;
	  
	 	   try {
				connection=(Connection) DBHelper.getConnection();
				   String sql="select * from subjectType where id=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				   preparedStatement.setInt(1, id);
				   resultSet=preparedStatement.executeQuery();
				   if (resultSet.next()) {
		        	  subjectType= new SubjectType();
					  
					  String name=resultSet.getString(2);
					  int modifyUser=resultSet.getInt(3);
					  
					  subjectType.setId(id);
					  subjectType.setName(name);
					  subjectType.setModifyUser(modifyUser);
					 
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
	 	  return subjectType;
	}

}
