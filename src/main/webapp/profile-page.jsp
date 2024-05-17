<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/4/2024
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri='http://java.sun.com/jsp/jstl/functions' %>
<html>
<head>
    <title>Profile Page</title>
    <link type="text/css" rel="stylesheet" href="home.css">
</head>
<body>
    <h1>${User.name} ${User.lastName}'s profile</h1><br>
    <p>Email : ${User.email}</p><br>
    <a href="home-page.jsp" >Home page</a>
    <h2>Bought games:</h2><br>
    <div class="game-result">
        <c:forEach items="${BoughtGames}" var = "game">
            <div  class="game-display">
                <br><img src="images/${fn:replace(game.name, ' ', '')}.jpg" alt="${game.name}image">
                <p>Game = ${game.name}</p>
                <form ACTION="AddToCart" method="post">
                    <input type="hidden" name="gameID" value="${game.id}" />
                    <input type="submit" value="Purchase Again"><br>
                </form>

            </div><br><br>
        </c:forEach>
    </div>
    <h2>Wishlist</h2><br>
    <div class="game-result">
        <c:forEach items="${Wishlist}" var = "game">
            <div  class="game-display">
                <br><img src="images/${fn:replace(game.name, ' ', '')}.jpg" alt="${game.name}image">
                <p>Game = ${game.name}</p>
                <form ACTION="AddToCart" method="post">
                    <input type="hidden" name="gameID" value="${game.id}" />
                    <input type="submit" value="Add to cart"><br>
                </form>

            </div><br><br>
        </c:forEach>
    </div>

</body>
</html>
