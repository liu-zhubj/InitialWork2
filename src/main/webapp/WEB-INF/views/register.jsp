<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/1
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${website}register" method="post">
    用户名: <input type="text" name="userName" /> <br />
    密码： <input type="password" name="password" /> <br />
    <input type="submit" value="注册" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
