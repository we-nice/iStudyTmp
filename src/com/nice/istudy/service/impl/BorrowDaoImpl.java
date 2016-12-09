package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nice.istudy.entity.Borrow;
import com.nice.istudy.service.BorrowDao;
import com.nice.istudy.utils.DBHelper;

public class BorrowDaoImpl implements BorrowDao{

	@Override
	public boolean addBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql="insert into borrow (bookId,bookName,typeId,author,price,total) values (?,?,?,?,?,?) ";
			stmt = conn.prepareStatement(sql);			
			
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

	@Override
	public boolean deleteBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		return false;
	}

}
