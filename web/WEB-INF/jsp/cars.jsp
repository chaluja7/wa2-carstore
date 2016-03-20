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

    <h1>CARS</h1>

    <table>
        <tr><th>Name</th><th>Manufacturer</th></tr>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.name}</td>
                <td>${car.manufacturer.name}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="createCar" title="create car">Crete car</a>
    <br/>
    <a href="/" title="home">Home</a>

</body>
</html>
