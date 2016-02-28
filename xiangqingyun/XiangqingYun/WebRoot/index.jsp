<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script type="text/javascript">
	 	function login(){
	 		
	 	}
	 	
	 
	 </script>
  </head>
 
  
  
  
  <body>
   <form action="https://localhost:8443/XiangqingYun/servlet/LoginServlet">
   用户名<input type="text" id="denglu" name="username">
  密码<input type="password" id="zhuce" name="password">
  	<input type="text" value="web" name="tag" style="display:none">
   <input type="submit" value="登陆">
   <input type="button" value="注册" >
   </form>
  </body>
</html>
