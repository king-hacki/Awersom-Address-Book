<%@ page import="com.softserve.itacademy.Model.Address" %><%--
  Created by IntelliJ IDEA.
  User: king-hacki
  Date: 7/18/20
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address</title>
</head>
<body>
    <%@include file="header.html"%>
    <%
        Address address = (Address) request.getAttribute("address");
    %>
    <form method="post">
        <table>
            <tr>
                <td>
                    <label for="first">First name: </label>
                </td>
                <td>
                    <input type="text" id="first" name="first" value="<%=address.getFirstName()%>">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="last">Last name: </label>
                </td>
                <td>
                    <input type="text" id="last" name="last" value="<%=address.getLastName()%>">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="address">Address: </label>
                </td>
                <td>
                    <input type="text" id="address" name="address" value="<%=address.getAddress()%>">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update">
                </td>
                <td>
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
