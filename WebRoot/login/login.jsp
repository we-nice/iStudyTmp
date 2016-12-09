
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="styles/public.css">
  <link rel="stylesheet" href="styles/css.css">
</head>
<body>
    <div id="cont">
   
       <div class="loginForm" >
            <form action="User_login" method="post">
                <div><span>用户名</span></div>
                <input type="text" name="studentNo">
                <div><span>密码</span></div>
              
                <input type="text" name="password">
                <div class="button">
                     <input type="submit" value="登录">
                </div>
             
            </form>

       </div>

    </div>

</body>
</html>