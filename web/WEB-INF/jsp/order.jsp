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

    <form:form method="POST" action="/orders/doCreateOrder">
        <table>
            <tr>
                <td><form:label path="personId">Person id:</form:label></td>
                <td><form:input path="personId" /></td>
            </tr>
            <tr>
                <td><form:label path="carId">Car id:</form:label></td>
                <td><form:input path="carId" /></td>
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
