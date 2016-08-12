<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.servlet.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%--
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
<form name="campaignForm" method="get" class="CampaignServlet" action="update">
<input type="hidden" name="campaignId" value="<% out.print(campaignId); %>">
    <table border="0" cellpadding=2 cellspacing="2">
        <tr>
            <td align="right">
                Name <font color="red">(*)</font>
            </td>
            <td><input type="text" name="name" value="campaign_7402" style="background-color:#EEF7FF;" value="<% out.print(resultSet.getInt("CAMPAIGN_ID")); %>" required/>
            </td>
        </tr>
        <tr>
            <td align="right">
                External Campaign Id<font color="red">(*)</font>
            </td>
            <td><input type="text" name="externalCampaignId" style="background-color:#EEF7FF;" value="<% out.print(resultSet.getString("EXTERNAL_CAMPAIGN_ID")); %>" required />
            </td>
        </tr>
        <tr>
            <td align="right">Start Date<font color="red">(*)</font></td>
            <td><input type="date" name="startDate" style="background-color:#EEF7FF;" value="<% out.print(resultSet.getDate("START_DATE")); %>" required/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Type<font color="red">(*)</font></td>
            <td>
                <select name="type" style="background-color:#EEF7FF;" required>
                    <option value="0">0 - NON-RECURRING</option>
                    <option value="1">1 - NON-RECURRING</option>
                    <option value="2">2 - NON-RECURRING</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">End Date</td>
            <td><input type="date" name="endDate" style="background-color:#EEF7FF;"value="<% out.print(resultSet.getDate("END_DATE")); %>" /></td>
        </tr>
        <tr>
            <td align="right">Count Control</td>
            <td><input type="text" name="countControl" style="background-color:#EEF7FF;"  value="<% out.print(resultSet.getInt("COUNT_CONTROL")); %>" /></td>
        </tr>
        <tr>
            <td align="right">Option <font color="red">(*)</font></td>
            <td>
                <select name="countOption" style="background-color:#EEF7FF;" required>
                    <option value="0">0 - SCHEDULE</option>
                    <option value="0">1 - SCHEDULE</option>
                    <option value="0">2 - SCHEDULE</option>
                    <option value="0">3 - SCHEDULE</option>
                </select>
            </td>
        </tr>
        <tr>

            <td align="right" style="vertical-align: top">Description</td>
            <td><textarea name="description" cols="30" rows="10" style="background-color:#EEF7FF; "><% out.print(resultSet.getString("DESCRIPTION")); %></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Submit" style="background-color:#EEF7FF;"></td>
        </tr>
    </table>
</form>
</body>
</html>
