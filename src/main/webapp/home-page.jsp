<%@ page import="model.GameDOA" %>
<%@ page import="model.Game" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri='http://java.sun.com/jsp/jstl/functions' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TSW Games</title>
    <link type="text/css" rel="stylesheet" href="home.css">
</head>
<body>
<ul class="top-navbar">
    <li><img src="images/TSWGames.jpg"></li>
    <li><h1>TSW Games</h1></li>
    <!--<li><a href='search-category-form.html'>Categories</a></li>-->
    <li><form action="SearchCategory" method="get">
        <p>
            Category:
            <select name="category" size="1" class="category-select">
                <option value="Nintendo"> Nintendo </option>
                <option value="PS4"> PS4 </option>
                <option value="XBOX"> XBOX </option>
                <option value="PC"> PC </option>
            </select>
            <input type="submit" value="Search">
        </p>
    </form><br></li>
    <c:if test="${empty User}">
        <li><a href='login.html'>Login</a></li>
    </c:if>
    <c:if test="${not empty User}">
        <li><a href="profile-page.jsp">${User.name}</a></li>
        <li><a href="${pageContext.request.contextPath}/GetCart">Cart </a> </li>
    </c:if>
    <c:if test="${not empty Permission and Permission}">
        <li><a href="administrator-page.jsp">Admin Page</a></li>
    </c:if>


</ul>

<h2>Highest selling game</h2>
<%
    GameDOA getGame = new GameDOA();
    HttpSession ssn = request.getSession(true);
    int gameid = getGame.MostBoughtGame();
    Game bestGame = getGame.getByID(gameid);

    ssn.setAttribute("BestGame", bestGame);
%>
<div class="most-bought">
    <img src="images/${fn:replace(BestGame.name, ' ', '')}.jpg" alt="${game.name}image">
</div>
<h2>Trending games</h2>
<% GameDOA gameSearch = new GameDOA();
    List<Game> games = gameSearch.getTrending();


    ssn.setAttribute("games", games);
%>
<%@include file = "show-games.jsp"%>

</body>
</html>