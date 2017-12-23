<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/16
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加賬戶</title>
</head>
<body>
<form action="${website}insert" method="post">
    <input type="hidden" name="id" value="${user.id }"/>
    用户名: <input type="text" name="userName" /> <br />
    密码： <input type="password" name="password" /> <br />
    <input type="submit" value="提交" />
    <input type="reset" value="重置" />
</body>
</html>
