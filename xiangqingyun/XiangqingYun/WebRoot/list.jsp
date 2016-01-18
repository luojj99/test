<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
    <div align="center">
    	<h2>游戏列表</h2>
    <div>${messageNotFind}</div>
     <table >
     	<thead>
     		<tr><a href="findsome.jsp">返回</a></tr>
		     <tr>
		     <th>游戏名称</th>  <th>游戏类别</th>  <th>发行公司</th>  <th>发行年份</th>  
		     </tr>
	    </thead>
	    <tbody>
	   
		     <c:forEach var="game" items="${list}">
			     <tr>
				     <td>${game.gid}</td>
				     <td>${game.gtype}</td>
				     <td>${game.gcompany}</td>
				     <td>${game.gyear}</td>
				     
			     </tr>
		     </c:forEach>
		
	     </tbody>
     </table>
    
    
    </div>
  </body>
</html>
