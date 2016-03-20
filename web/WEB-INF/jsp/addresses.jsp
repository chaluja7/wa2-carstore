<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <h1>ADDRESSES</h1>

    <table>
        <tr><th>City</th><th>Street</th><th>Number</th><th>Note</th><th>Person ID</th></tr>
        <c:forEach items="${addresses}" var="address">
            <tr>
                <td>${address.city}</td>
                <td>${address.street}</td>
                <td>${address.number}</td>
                <td>${address.note}</td>
                <td>${address.person.id}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="createAddress" title="create address">Crete address</a>
    <br/>
    <a href="addressesByCity?cityPattern=Praha" title="addressesByCity">Addresses in Prague</a>
    <br/>
    <a href="/" title="home">Home</a>

</body>
</html>
