<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2021/9/12
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = Array();
        userList.push({username: "wangyu", age: 18});
        userList.push({username: "jiangziting", age: 17});
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/quick15",
            data: JSON.stringify(userList),
            contentType: "application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
