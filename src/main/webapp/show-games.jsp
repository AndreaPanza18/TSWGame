<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/30/2024
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri='http://java.sun.com/jsp/jstl/functions' %>

<html>
<head>
    <title>Title</title>
  <link type="text/css" rel="stylesheet" href="home.css">
</head>
<body>
<div class="game-result">
  <c:forEach items="${games}" var = "game">
    <div  class="game-display">
      <br><img src="images/${fn:replace(game.name, ' ', '')}.jpg" alt="${game.name}image">
      <p>Game = ${game.name}</p>
      <p>Price = $${game.price}0</p>
      <input type="button" value="Add to cart"><br>
    </div><br><br>
  </c:forEach>
</div>
</body>
</html>
