<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakubchalupa
  Date: 20.03.16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form method="POST" action="/addresses/doCreateAddress">
        <table>
            <tr>
                <td><form:label path="city">City:</form:label></td>
                <td><form:input path="city" /></td>
            </tr>
            <tr>
                <td><form:label path="street">Street:</form:label></td>
                <td><form:input path="street" /></td>
            </tr>
            <tr>
                <td><form:label path="number">Number:</form:label></td>
                <td><form:input path="number" /></td>
            </tr>
            <tr>
                <td><form:label path="personId">Person ID:</form:label></td>
                <td><form:input path="personId" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>
