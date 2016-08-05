<%@ page import="java.io.PrintWriter" %>

<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.servlet.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>

<%--
  Created by IntelliJ IDEA.
  User: GUNEY
  Date: 2.08.2016
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    String query = "SELECT * FROM SLCM_CAMPAIGN";
    PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();


%>
<table border="1" class="table table-striped">
    <tr>
        <th>ID</th>
        <th>EXTERNAL_ID</th>
        <th>START_DATE</th>
        <th>END_DATE</th>
        <th>COUNT</th>
        <th>OPTION</th>
        <th>TYPE</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>CREATION_DATE</th>
        <th>MODIFICATION_DATE</th>
        <th>VERSION</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>

    <%
        while (resultSet.next()) {
    %>

    <tr>
        <td><% long campaign_id = resultSet.getLong("CAMPAIGN_ID");
            out.println(campaign_id); %></td>
        <td><% out.println(resultSet.getString("EXTERNAL_CAMPAIGN_ID")); %></td>
        <td><% out.println(resultSet.getDate("START_DATE")); %></td>
        <td><% out.println(resultSet.getDate("END_DATE")); %></td>
        <td><% out.println(resultSet.getInt("COUNT_CONTROL")); %></td>
        <td><% out.println(resultSet.getInt("CAMPAIGN_OPTION")); %></td>
        <td><% out.println(resultSet.getInt("TYPE")); %></td>
        <td><% out.println(resultSet.getString("CAMPAIGN_NAME")); %></td>
        <td><% out.println(resultSet.getString("DESCRIPTION")); %></td>
        <td><% out.println(resultSet.getTime("CREATION_DATE")); %></td>
        <td><% out.println(resultSet.getTime("MODIFICATION_DATE")); %></td>
        <td><% out.println(resultSet.getLong("VERSION")); %></td>
        <td><a href="update.jsp?campaignId=<% out.println(campaign_id);  %>" >Update </a> </td>

    </tr>
    <% } %>
</table>
</body>
</html>
