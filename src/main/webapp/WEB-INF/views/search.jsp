<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/20
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <input type="hidden" name="user" value="${user}"/>
    <tr>
        <td>ID=${user.id}</td>
        <td>UserNamer=${user.userName}</td>
        <td>password=${user.password}</td>

    </tr>


</body>
</html>
