package com.nice.istudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nice.istudy.po.User;
import com.nice.istudy.util.DBHelper;



public class userDAO {

	public boolean check(String username,String password)
	{
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from user where studentNo = ? and password = ?"; //SQL 语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				return true;
			}
			return false;
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
	
	public boolean adduser(User user)
	{
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "insert into user(studentNo,password,name,nickName,role,college,isForbidden) " +
					"values(?,?,?,?,?,?,?) "; //SQL 语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getStudenetNo());
		//	stmt.setString(2, password);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				return true;
			}
			return false;
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
