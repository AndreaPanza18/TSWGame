<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/5/2024
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri='http://java.sun.com/jsp/jstl/functions' %>


<html>
<head>
    <title>Shopping cart</title>
    <link type="text/css" rel="stylesheet" href="home.css">
</head>
<body>
<h1>${User.name}'s Shopping cart</h1>
<div class="game-result">
    <c:forEach items="${Cart}" var = "game">
        <div  class="game-display">
            <br><img src="images/${fn:replace(game.name, ' ', '')}.jpg" alt="${game.name}image">
            <p>Game = ${game.name}</p>
        </div><br><br>
    </c:forEach>
</div>
</body>
</html>
