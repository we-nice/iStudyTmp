package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.File;

 
 
import com.nice.istudy.service.FileDao;
 
import com.nice.istudy.utils.DBHelper;



public class FileDaoImpl implements FileDao{

	@Override
	public boolean addFile(File file) {
		Connection conn= null;
		PreparedStatement  stmt = null ;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "insert into file (name,description,size,author,isDel,src,college,subject) " +
					"values (?,?,?,?,?,  ?,?,?) "; //SQL
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, file.getName());
		 	stmt.setString(2, file.getDescription());
		 	stmt.setInt(3, file.getSize());
		 	stmt.setString(4, file.getAuthor());
		 	stmt.setInt(5,file.getIsDel());
		 	stmt.setString(6, file.getSrc());
		 	stmt.setInt(7, file.getCollege());
		 	stmt.setInt(8, file.getSubject());
		 	
		  
			 
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
	public boolean deleteFile(int id) {
		Connection connection=null;
    	PreparedStatement preparedStatement=null;
    	
    	try {
			connection=(Connection) DBHelper.getConnection();
			String sql="delete from file where id= ? ";
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
	public List<File> selectAllFiles() {
		  List<File > fileList=new ArrayList<File>();
	    	
	   	   
	   	   Connection connection=null;
	   	   PreparedStatement preparedStatement=null;
	   	   ResultSet resultSet=null;
	   	   
	   	  
	         try {
				connection=(Connection) DBHelper.getConnection();
				  String sql="select * from File";
				  preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		          resultSet=preparedStatement.executeQuery();
		         
		          while (resultSet.next()) {
		        	   File  File=new File();
		        	   int id=resultSet.getInt(1);
		        	   String name=resultSet.getString(2);
					   String description=resultSet.getString(3);
					   int size=resultSet.getInt(4);
					   String author=resultSet.getString(5);
					   int isDel=resultSet.getInt(6);
					   String src=resultSet.getString(7);
					   int college=resultSet.getInt(8);
					  
					   int subject=resultSet.getInt(9);
					 
					   
	 
					   
					  
					  File.setId(id);
					  File.setName(name);
					  File.setDescription(description);
					  File.setSize(size);
					  File.setAuthor(author);
					  File.setIsDel(isDel);
					  File.setSrc(src);
					  File.setCollege(college);
					  File.setSubject(subject);
					  
					 
					  fileList.add(File);
					
					
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
	       
	   	   
	   	   
	   	  // System.out.println(FileTypeList);
	   	   return fileList;
	}

	@Override
	public List<File> selectFileByCollegeId(int collegeId) {
		  List<File > fileList=new ArrayList<File>();
   	   Connection connection=null;
   	   PreparedStatement preparedStatement=null;
   	   ResultSet resultSet=null;
    
   	   try {
			connection=(Connection) DBHelper.getConnection();
			   String sql="select * from file  where college=?";
			   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			   
			    preparedStatement.setInt(1, collegeId);
			    resultSet=preparedStatement.executeQuery();
			   while(resultSet.next()) {
				   
				   File  File=new File();
	        	   int id=resultSet.getInt(1);
	        	   String name=resultSet.getString(2);
				   String description=resultSet.getString(3);
				   int size=resultSet.getInt(4);
				   String author=resultSet.getString(5);
				   int isDel=resultSet.getInt(6);
				   String src=resultSet.getString(7);
				   int college=resultSet.getInt(8);
				  
				   int subject=resultSet.getInt(9);
				 
				   
 
				   
				  
				  File.setId(id);
				  File.setName(name);
				  File.setDescription(description);
				  File.setSize(size);
				  File.setAuthor(author);
				  File.setIsDel(isDel);
				  File.setSrc(src);
				  File.setCollege(college);
				  File.setSubject(subject);
				  
				 
				  fileList.add(File);
				 
			 
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
   	  
		return fileList;
	}

	@Override
	public List<File> selectFileBySubjectId(int subjectId) {
		  List<File > fileList=new ArrayList<File>();
	   	   Connection connection=null;
	   	   PreparedStatement preparedStatement=null;
	   	   ResultSet resultSet=null;
	    
	   	   try {
				connection=(Connection) DBHelper.getConnection();
				   String sql="select * from file  where subject=?";
				   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				   
				    preparedStatement.setInt(1, subjectId);
				    resultSet=preparedStatement.executeQuery();
				   while(resultSet.next()) {
					   
					   File  File=new File();
		        	   int id=resultSet.getInt(1);
		        	   String name=resultSet.getString(2);
					   String description=resultSet.getString(3);
					   int size=resultSet.getInt(4);
					   String author=resultSet.getString(5);
					   int isDel=resultSet.getInt(6);
					   String src=resultSet.getString(7);
					   int college=resultSet.getInt(8);
					  
					   int subject=resultSet.getInt(9);
					 
					   
	 
					   
					  
					  File.setId(id);
					  File.setName(name);
					  File.setDescription(description);
					  File.setSize(size);
					  File.setAuthor(author);
					  File.setIsDel(isDel);
					  File.setSrc(src);
					  File.setCollege(college);
					  File.setSubject(subject);
					  
					 
					  fileList.add(File);
					 
				 
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
	   	  
			return fileList;
	}

	@Override
	public List<File> selectFileByName(String name) {
		List<File > fileList=new ArrayList<File>();
  	   Connection connection=null;
  	   PreparedStatement preparedStatement=null;
  	   ResultSet resultSet=null;
   
  	   try {
			connection=(Connection) DBHelper.getConnection();
			   String sql="select * from file  where name like ?";
			   preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			   
			    preparedStatement.setString(1, name);
			    resultSet=preparedStatement.executeQuery();
			   while (resultSet.next()) {
				   
				   File  File=new File();
	        	   int id=resultSet.getInt(1);
	        	   //String name=resultSet.getString(2);
				   String description=resultSet.getString(3);
				   int size=resultSet.getInt(4);
				   String author=resultSet.getString(5);
				   int isDel=resultSet.getInt(6);
				   String src=resultSet.getString(7);
				   int college=resultSet.getInt(8);
				  
				   int subject=resultSet.getInt(9);
				 
				   
 
				   
				  
				  File.setId(id);
				  File.setName(name);
				  File.setDescription(description);
				  File.setSize(size);
				  File.setAuthor(author);
				  File.setIsDel(isDel);
				  File.setSrc(src);
				  File.setCollege(college);
				  File.setSubject(subject);
				  
				 
				  fileList.add(File);
			 
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
  	  
		return fileList;	
	}
  
	
}
