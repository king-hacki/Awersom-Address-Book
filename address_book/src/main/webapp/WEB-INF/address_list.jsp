<%@ page import="com.softserve.itacademy.Model.Address" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: king-hacki
  Date: 7/17/20
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Records</title>
</head>
<body>

    <%@include file="header.html"%>

    <div>
        Sorted by:
        <a href="/records/ascending">ascending</a>
        <a href="/records/descending">descending</a>
    </div>

    <table border="1">
        <tr>
            <th>No.</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th colspan="3">Operations</th>
        </tr>

        <%
            for (Address address : (List<Address>)request.getAttribute("addressBook")) {
        %>

        <tr>
            <td><%=address.getId()%></td>
            <td><%=address.getFirstName()%></td>
            <td><%=address.getLastName()%></td>
            <td><%=address.getAddress()%></td>
            <td>
                <a href="/records/read?firstName=<%=address.getFirstName()%>&lastName=<%=address.getLastName()%>">Read</a>
            </td>
            <td>
                <a href="/records/update?firstName=<%=address.getFirstName()%>&lastName=<%=address.getLastName()%>">Update</a>
            </td>
            <td>
                <a href="/records/delete?firstName=<%=address.getFirstName()%>&lastName=<%=address.getLastName()%>">Delete</a>
            </td>
        </tr>

        <%
            }
        %>
    </table>
</body>
</html>
