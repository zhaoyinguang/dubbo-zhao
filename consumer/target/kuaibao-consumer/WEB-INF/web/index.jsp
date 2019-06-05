<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/14
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转化服务</title>
</head>
<body>
<form action="/translate" method="POST" enctype="multipart/form-data">
    文件：<input type="file" name="fileName"/>
    <input type="submit"/>
    通知地址：<input type="text" name="url" placeholder="请输地址，以便及时通知您">
    <input type="text" name="userName" hidden=hidden value="zhao">
</form>
</body>
</html>
