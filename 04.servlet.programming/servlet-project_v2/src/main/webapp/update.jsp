
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${camp}" var="campaign">

<form   method="post" action="update">


<input type="hidden" name="campaignId" value="${campaign.campaignID}" />
    <table border="0" cellpadding=2 cellspacing="2">
        <tr>
            <td align="right">
                Name <font color="red">(*)</font>
            </td>
            <td><input type="text" name="name" value="${campaign.campaignName}" style="background-color:#EEF7FF;"  required />
            </td>
        </tr>
        <tr>
            <td align="right">
                External Campaign Id<font color="red">(*)</font>
            </td>
            <td><input type="text" name="externalCampaignId" style="background-color:#EEF7FF;" value="${campaign.externalCampaignID}" required />
            </td>
        </tr>
        <tr>
            <td align="right">Start Date<font color="red">(*)</font></td>
            <td><input type="date" name="startDate" style="background-color:#EEF7FF;" value="${campaign.startDate}" required/>
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
            <td><input type="date" name="endDate" style="background-color:#EEF7FF;"value="${campaign.endDate}" /></td>
        </tr>
        <tr>
            <td align="right">Count Control</td>
            <td><input type="text" name="countControl" style="background-color:#EEF7FF;"  value="${campaign.countControl}" /></td>
        </tr>
        <tr>
            <td align="right">Option <font color="red">(*)</font></td>
            <td>
                <select name="countOption" style="background-color:#EEF7FF;" required>
                    <option value="0">0 - SCHEDULE</option>
                    <option value="1">1 - SCHEDULE</option>
                    <option value="2">2 - SCHEDULE</option>
                    <option value="3">3 - SCHEDULE</option>
                </select>
            </td>
        </tr>
        <tr>

            <td align="right" style="vertical-align: top">Description</td>
            <td><textarea name="description" cols="30" rows="10" style="background-color:#EEF7FF; ">${campaign.description}</textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Submit" style="background-color:#EEF7FF;"></td>
        </tr>
    </table>

</form>
</c:forEach>
</body>
</html>
