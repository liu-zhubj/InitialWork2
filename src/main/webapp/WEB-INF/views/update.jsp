<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/15
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="${website}update22" method="post">

    <input type="hidden" name="id" value="${user.id }"/>
    用户名: <input type="text" name="userName" value="${user.userName}"/> <br />
    密码： <input type="password" name="password" value="${user.password}"/> <br />

    <input type="submit" value="提交" />
    <input type="reset" value="重置" />

</form>
</body>
</html>
