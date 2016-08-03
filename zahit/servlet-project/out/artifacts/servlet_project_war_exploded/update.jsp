<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.mehmetzahit.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: GUNEY
  Date: 3.08.2016
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int campaignId = Integer.parseInt(request.getParameter("campaignId"));
    PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement("SELECT * FROM SLCM_CAMPAIGN WHERE CAMPAIGN_ID=?");
    preparedStatement.setInt(1, campaignId);
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();

%>
<form method="get" action="campaign">

    <input type="date">
    <table border="0" cellpadding=2 cellspacing="2">
        <tr>
            <td>Name <font color="red">(*)</font></td>
            <td><input type="text" name="name" value="<% out.print(resultSet.getInt("CAMPAIGN_ID")); %>"/></td>
        </tr>
        <tr>
            <td>External Campaign Id (*)</td>
            <td><input type="text" name="externalCampaignId" value="<% out.print(resultSet.getString("EXTERNAL_CAMPAIGN_ID")); %>"/></td>
        </tr>
        <tr>
            <td>Start Date (*)</td>
            <td><input type="text" name="startDate" value="<% out.print(resultSet.getDate("START_DATE")); %>"/></td>
        </tr>
        <tr>
            <td>Type (*)</td>
            <td>
                <select name="type">
                    <option>0 - NON-RECURRING</option>
                    <option>1 - NON-RECURRING</option>
                    <option>2 - NON-RECURRING</option>
                    <option>3 - NON-RECURRING</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>End Date</td>
            <td><input type="text" name="endDate" value="<% out.print(resultSet.getDate("END_DATE")); %>"/></td>
        </tr>
        <tr>
            <td>Count Control</td>
            <td><input type="text" name="countControl" value="<% out.print(resultSet.getInt("COUNT_CONTROL")); %>"/></td>
        </tr>
        <tr>
            <td>Option (*)</td>
            <td>
                <select name="option">
                    <option>0 - SCHEDULE</option>
                    <option>1 - SCHEDULE</option>
                    <option>2 - SCHEDULE</option>
                    <option>3 - SCHEDULE</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Description (*)</td>
            <td><textarea cols="30" rows="10" value="<% out.print(resultSet.getString("DESCRIPTION")); %>"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Submit"></td>

        </tr>
    </table>
</form>
</body>
</html>
