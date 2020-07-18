<%--
  Created by IntelliJ IDEA.
  User: king-hacki
  Date: 7/17/20
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new address</title>
</head>

<body>
    <%@include file="header.html"%>

    <%
        if (request.getParameter("error") != null) {
    %>

        <p>
            <b><%=request.getParameter("error")%></b>
        </p>

    <% } %>

    <form method="post">
        <table>
            <tr>
                <td>
                    <label for="firstName">First name: </label>
                </td>
                <td>
                    <input type="text" id="firstName" name="firstName">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lastName">Last name: </label>
                </td>
                <td>
                    <input type="text" id="lastName" name="lastName">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="address">Address: </label>
                </td>
                <td>
                    <input type="text" id="address" name="address">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create">
                </td>
                <td>
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
