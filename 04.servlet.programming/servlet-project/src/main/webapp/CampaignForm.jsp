<%--
  Created by IntelliJ IDEA.
  User: mustafasarac
  Date: 4.08.2016
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Campaign Form</title>
</head>
<body>
<form name="campaignForm" method="get" class="CampaignServlet" action="campaignServlet">

    <table border="0" cellpadding=2 cellspacing="2">
        <tr>
            <td align="right">
                Name <font color="red">(*)</font>
            </td>
            <td><input type="text" name="name" value="campaign_7402" style="background-color:#EEF7FF;" required/>
            </td>
        </tr>
        <tr>
            <td align="right">
                External Campaign Id<font color="red">(*)</font>
            </td>
            <td><input type="text" name="externalCampaignId" value="7402" style="background-color:#EEF7FF;" required/>
            </td>
        </tr>
        <tr>
            <td align="right">Start Date<font color="red">(*)</font></td>
            <td><input type="date" name="startDate" style="background-color:#EEF7FF;" required/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Type<font color="red">(*)</font></td>
            <td>
                <select name="type" style="background-color:#EEF7FF;" required>
                    <option>0 - NON-RECURRING</option>
                    <option>1 - NON-RECURRING</option>
                    <option>2 - NON-RECURRING</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">End Date</td>
            <td><input type="date" name="endDate" style="background-color:#EEF7FF;"/></td>
        </tr>
        <tr>
            <td align="right">Count Control</td>
            <td><input type="text" name="countControl" style="background-color:#EEF7FF;"/></td>
        </tr>
        <tr>
            <td align="right">Option <font color="red">(*)</font></td>
            <td>
                <select name="countOption" style="background-color:#EEF7FF;" required>
                    <option>0 - SCHEDULE</option>
                    <option>1 - SCHEDULE</option>
                    <option>2 - SCHEDULE</option>
                    <option>3 - SCHEDULE</option>
                </select>
            </td>
        </tr>
        <tr>
            <%
                out.println();
            %>
            <td align="right" style="vertical-align: top">Description</td>
            <td><textarea name="description" cols="30" rows="10" style="background-color:#EEF7FF;"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Submit" style="background-color:#EEF7FF;"></td>
        </tr>
    </table>
</form>
</body>
</html>
