<%--
  Created by IntelliJ IDEA.
  User: xiaozl
  Date: 2015/8/18
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>获取信息</title>
</head>
<body>

<table>
    <a href="${website}add">增加用户</a>
    <form action="${website}findBYId" method="post">
        查询<input type="text" name="id"/>
        <input type="submit" value="提交"/>
</form>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>ID=${user.id}</td>
            <td>UserNamer=${user.userName}</td>
            <td>password=${user.password}</td>
            <td>
                <a href="${website}update11?id=${user.id}" rel="external nofollow" >修改</a>
                    <a href="${website}deleteByid?id=${user.id}" rel="external nofollow" >删除</a>

      </td>
  </tr>
</c:forEach>

</table>

<form action="upload" enctype="multipart/form-data" method="post">
    <table>

        <tr>
            <td>请上传头像:</td>
            <td><input type="file" name="image"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>

</form>
</body>
</html>
