<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2021/9/9
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>属性获取测试</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="site" class="com.wangyu.jsp01.Site"/>
<jsp:setProperty name="site" property="*"/>
<jsp:getProperty name="site" property="name"/>
<jsp:getProperty name="site" property="url"/>
</body>
</html>
