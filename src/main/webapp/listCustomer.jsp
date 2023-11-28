<%@ page import="vn.edu.iuh.fit.backend.configs.models.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lethi
  Date: 11/28/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width: 70%; margin: auto;">
    <h1 style="text-align: center"> Danh sách khách hàng </h1>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>PhoneNumber</th>
        <th></th>
    </tr>
    <% List<Customer> list ;
        list = (List<Customer>) request.getAttribute("listCustomer");
        for (Customer e  :list
        ) {%>
    <tr style="text-align: center">
        <td><%= e.getCus_id() %> </td>
        <td><%= e.getAddress() %> </td>
        <td><%= e.getEmail()%> </td>
        <td><%= e.getPhone() %> </td>
        <td>
            <a href="insertUpdateCus.jsp" style="margin-right: 5px">update</a>
            <a >delete</a>
        </td>
    </tr>
    <%}%>
    <tr style="text-align: right">
        <td colspan="7">
            <a href="insertUpdateCus.jsp" style="margin-right: 5px;font-size: 25px;font-weight: bold;">Insert</a>
        </td>
    </tr>
</table>
</body>
</html>
