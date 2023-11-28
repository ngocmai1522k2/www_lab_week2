<%--
  Created by IntelliJ IDEA.
  User: lethi
  Date: 11/28/2023
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="hello-servlet?action=insertUpdateCus" method="post">
    Name: <input type="text" name="nameCus"><br>
    Address: <input type="text" name="addCus"><br>
    Email: <input type="email" name="emailCus"><br>
    PhoneNumber: <input type="text" name="phoneCus"><br>
    <input type="submit" value="Insert">
    <input type="reset" value="Reset">
</form>

</body>
</html>
