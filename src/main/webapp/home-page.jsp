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
<h1>TSW Games</h1>

<ul class="top-navbar">
    <li><img src="images/TSWGames.jpg"></li>
    <li><a href='search-category-form.html'>Categories</a></li>
    <c:if test="${empty User}">
        <li><a href='login.html'>Login</a></li>
    </c:if>
    <c:if test="${not empty User}">
        <li><a href="profile-page.jsp">${User.name}</a></li>
        <li><a href="${pageContext.request.contextPath}/GetCart">Cart</a> </li>
    </c:if>
    <li><a>Search</a></li>

</ul>

<% GameDOA gameSearch = new GameDOA();
    HttpSession ssn = request.getSession(true);
    List<Game> games = gameSearch.getTrending();


    ssn.setAttribute("games", games);
    %>
<%@include file = "show-games.jsp"%>
<h2>Trending games</h2>
</body>
</html>