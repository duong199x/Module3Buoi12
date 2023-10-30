<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 10/27/2023
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="" method="post">
    <input type="text" name="id" placeholder="${editProduct.id}" disabled>
    <input type="text" name="name" value="${editProduct.name}">
    <input type="text" name="quantity" value="${editProduct.quantity}">
    <input type="text" name="price" value="${editProduct.price}">
    <input type="text" name="image" value="${editProduct.image}">
    <button>Submit</button>
</form>
</body>
</html>
