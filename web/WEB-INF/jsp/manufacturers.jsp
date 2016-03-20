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

    <h1>MANUFACTUERS</h1>

    <table>
        <tr><th>Name</th><th>Suppliers</th></tr>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <tr>
                <td>${manufacturer.name}</td>
                <td>
                    <c:forEach items="${manufacturer.suppliers}" var="supplier">
                        ${supplier.name}
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="createManufacturer" title="create manufacturer">Crete manufacturer</a>
    <br/>
    <a href="/" title="home">Home</a>

</body>
</html>
