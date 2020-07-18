<%@ page import="com.softserve.itacademy.Model.Address" %><%--
  Created by IntelliJ IDEA.
  User: king-hacki
  Date: 7/17/20
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Record</title>
</head>
<body>
    <%@include file="header.html"%>
    <%
        Address address = (Address) request.getAttribute("address");
    %>
    <p>First name: <b><%=address.getFirstName()%></b> </p>
    <p>Last name: <b><%=address.getLastName()%></b> </p>
    <p>Address: <b><%=address.getAddress()%></b> </p>
</body>
</html>
