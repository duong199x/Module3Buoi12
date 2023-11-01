<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 10/27/2023
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="http://localhost:8080/products?action=create" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="quantity" placeholder="quantity">
    <input type="text" name="price" placeholder="price">
    <input type="text" name="image" placeholder="image">
    <button>Submit</button>
</form>
</body>
</html>
