<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2021/9/9
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@ page import="com.wangyu.jsp01.TestJsp" %>--%>
<html>
<head>
    <title>测试useBean动作</title>
</head>
<body>
<jsp:useBean id="test" class="com.wangyu.jsp01.TestJsp" />
<%
//    TestJsp test = new TestJsp();
    String str = "百度一下：";
    out.print(test.concatStr(str));
%>
</body>
</html>
