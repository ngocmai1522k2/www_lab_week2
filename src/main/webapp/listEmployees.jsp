<%@ page import="vn.edu.iuh.fit.backend.configs.models.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lethi
  Date: 11/28/2023
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width: 70%; margin: auto;">
    <h1 style="text-align: center"> Danh sách nhân viên </h1>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Date</th>
        <th>Status</th>
        <th></th>
    </tr>
    <% List<Employee> list ;
        list = (List<Employee>) request.getAttribute("listEmployees");
        for (Employee e  :list
        ) {%>
    <tr style="text-align: center">
        <td><%= e.getEmp_id() %> </td>
        <td><%= e.getFull_name()%> </td>
        <td><%= e.getAddress() %> </td>
        <td><%= e.getEmail()%> </td>
        <td><%= e.getDob()%> </td>
        <td><%= e.getStatus() %> </td>
        <td>
            <a href="insertUpdateEmp.jsp" style="margin-right: 5px">Update</a>
            <a >Delete</a>
        </td>
    </tr>
    <%}%>
    <tr style="text-align: right">
        <td colspan="7">
            <a href="insertUpdateEmp.jsp" style="margin-right: 5px;font-size: 25px;font-weight: bold;">Insert</a>
        </td>
    </tr>
</table>
</body>
</html>
