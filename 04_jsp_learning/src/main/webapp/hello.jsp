<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2021/9/9
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="bc" uri="/tlds/custom.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="head.jsp"%>
<% String name = "王瑜";%>
name:<%=name%>
    <bc:Hello/>
</body>
</html>
