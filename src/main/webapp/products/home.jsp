<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 10/27/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<style>
    img {
        width: 100px;
        height: 100px;
    }
</style>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="http://localhost:8080/products?action=create" type="button">Add</a>
<table border="1px solid black">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Image</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="item" items="${productList}">
        <tr>
            <td> ${item.id}</td>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>${item.price}</td>
            <td><img src="${item.image}"></td>
            <td>
                <button><a href="http://localhost:8080/products?action=edit&id=${item.id}"> Edit</a></button>
            </td>
            <td>
                <button onclick="confirmFunction('/products?action=delete&id=${item.id}')">Delete</button>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
<script>
    function confirmFunction(url) {
        let a = confirm(`ok`);
        if (a) {
            window.location.href = url;
        }

    }
</script>
