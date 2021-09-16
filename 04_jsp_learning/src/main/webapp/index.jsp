<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<body>
<h2>百度一下</h2>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
您好，欢迎登录<%= request.getParameter("sitename")%>!<br/>
网址是<%= request.getParameter("url")%>

</body>
</html>
