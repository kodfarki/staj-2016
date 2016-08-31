<%@ page import="com.servlet.dao.CampaignDAOImpl" %>
<%@ page import="com.servlet.model.Campaign" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: GUNEY
  Date: 11.08.2016
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">

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
    <c:forEach items="${campaigns}" var="campaign">
        <tr>
            <td>${campaign.campaignID}</td>
            <td>${campaign.externalCampaignID}</td>
            <td>${campaign.startDate}</td>
            <td>${campaign.endDate}</td>
            <td>${campaign.countControl}</td>
            <td>${campaign.campaignOption}</td>
            <td>${campaign.type}</td>
            <td>${campaign.campaignName}</td>
            <td>${campaign.description}</td>
            <td>${campaign.creationDate}</td>
            <td>${campaign.modificationDate}</td>
            <td>${campaign.version}</td>
            <td><a href="update?campaignId=${campaign.campaignID}" >Update </a> </td>
            <td><a href="Delete?campaignId=${campaign.campaignID}" >Delete</a> </td>
        </tr>
    </c:forEach>
    <a href="CampaignForm.jsp">Add New Campaigns</a>
</table>
</body>
</html>
