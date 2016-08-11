<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.servlet.util.JDBCUtil" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: GUNEY
  Date: 5.08.2016
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    try {
        PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement("DELETE  FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID=?");
        preparedStatement.setInt(1,Integer.parseInt(request.getParameter("campaignId")));
        preparedStatement.executeQuery();
        out.print("Deleted the succesfully");

    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
<a href="campaigns.jsp">All Campaigns</a>
</body>
</html>
