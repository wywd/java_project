<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2021/9/9
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<%
    int a= 100/0;
%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String name = request.getParameter("username");
    String url = request.getParameter("url");
    out.print("欢迎" + name + ",我们的网址是：" + url);
%>
<br/><%="欢迎来到JSP的世界！"%>
<!--HTML 注释内容<%="JSP 表达式"%>-->
<br/>您登录的时间是<%=new Date()%>
</body>
</html>
