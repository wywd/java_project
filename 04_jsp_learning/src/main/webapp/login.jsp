<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2021/9/9
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>jsp-forward</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<jsp:forward page="index.jsp">
    <jsp:param name="sitename" value="百度一下"/>
    <jsp:param name="url" value="www.baidu.com"/>
</jsp:forward>
</body>
</html>
