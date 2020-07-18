<%--
  Created by IntelliJ IDEA.
  User: king-hacki
  Date: 7/18/20
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <%
        String firstName  = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
    %>
    No such address with First name : <%=firstName%> and Last name : <%=lastName%>
</body>
</html>
