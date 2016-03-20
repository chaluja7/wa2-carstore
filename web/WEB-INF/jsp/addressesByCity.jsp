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

    <h1>ADDRESSES in city</h1>

    <table>
        <tr><th>Address</th><th>Person</th><th>Orders</th></tr>
        <c:forEach items="${addresses}" var="address">
            <tr>
                <td>${address.city} - ${address.street} - ${address.number} - ${address.note}</td>
                <td>${address.person.name} ${address.person.surname}</td>
                <td>
                    <table>
                        <tr><th>Date from</th><th>Date to</th><th>Car</th><th>Manufacturer</th><th>Suppliers</th></tr>
                        <c:forEach items="${address.person.orders}" var="order">
                            <tr>
                                <td>${order.dateFrom}</td>
                                <td>${order.dateTo}</td>
                                <td>${order.car.name}</td>
                                <td>${order.car.manufacturer.name}</td>
                                <td>
                                    <table>
                                        <c:forEach items="${order.car.manufacturer.suppliers}" var="supplier">
                                            <tr>
                                                <td>${supplier.name} - WAREHOUSES:
                                                    <c:forEach items="${supplier.warehouses}" var="warehouse">
                                                        ${warehouse.name},
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="/" title="home">Home</a>

</body>
</html>
