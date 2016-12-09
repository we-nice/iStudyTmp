<%@page import="org.apache.struts2.views.TagLibrary"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <h1 align="center">Hello_struts</h1>
    
    <center>
    	<b>登录</b>
    	<br />
    	<form method="post"  action="User_login">
    		<br/>
    		用户名:<input  type="text" name="username" />
    		<br/>
    		密&nbsp;码：<input type="password" name="password">
    		<br/>
    		<input type="submit" value="提交">
    		<input type="reset" value="重置">
    	 </form>
    </center>
    
  </body>
</html>
