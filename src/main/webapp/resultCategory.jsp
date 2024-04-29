<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/6/2024
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri='http://java.sun.com/jsp/jstl/functions' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${search} games</title>
    <link type="text/css" rel="stylesheet" href="home.css">
</head>
<body>
    <h1 style="text-align: center">All ${search} games</h1>
    <div class="game-result">
    <c:forEach items="${games}" var = "game">
        <div style="border: 1px solid black" class="game-display">
        <br><img src="images/${fn:replace(game.name, ' ', '')}.jpg" alt="${game.name}image">
        <p>Game = ${game.name}</p>
        <p>Price = $${game.price}0</p>
        <input type="button" value="Add to cart"><br>
        </div><br><br>
    </c:forEach>
    </div>

</body>
</html>