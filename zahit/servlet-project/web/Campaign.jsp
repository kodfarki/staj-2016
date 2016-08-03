<%--
  Created by IntelliJ IDEA.
  User: GUNEY
  Date: 3.08.2016
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${allCamp}" var="employee">
        <tr>
            <td><c:out value="${employee.campaignId}"/></td>
            <td><c:out value="${employee.type}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
