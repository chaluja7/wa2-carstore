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

    <h1>ORDERS</h1>

    <table>
        <tr><th>Date from</th><th>Date to</th><th>Car</th><th>Person ID</th></tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.dateFrom}</td>
                <td>${order.dateTo}</td>
                <td>${order.car.name}</td>
                <td>${order.person.id}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="createOrder" title="create order">Crete order</a>
    <br/>
    <a href="/" title="home">Home</a>

</body>
</html>
