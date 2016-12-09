package com.nice.istudy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.*;

public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver"; //数据库驱动
	//连接数据库的URL地址
	private static final String url="jdbc:mysql://localhost:3306/istudy?useUnicode=true&characterEncoding=UTF-8"; 
	private static final String username="root";//数据库的用户名
	private static final String password="186413";//数据库的密码
	
	private static Connection conn= null;
	
	//加载驱动程序
	static 
	{
		try{
			Class.forName(driver);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//获得数据库连接
	public static Connection getConnection() throws Exception
	{
		if(conn==null){
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBHelper.getConnection();
			if(conn!=null){
				System.out.println("数据库连接正常！");
			}else{
				System.out.println("数据库连接异常！");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
