<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/31/2024
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link type="text/css" rel="stylesheet" href="home.css">


    <script src="search-bar.js" defer></script>
</head>
<body>
    <ul class="top-navbar">
        <li><a href="home-page.jsp" >Home page</a></li>
        <li> <a href="add-game.html"> Add Game</a> </li>
        <li><h1 style="margin-left: 400px">Admin Page</h1><li>

    </ul>
    <div class="login">
        <input type="text" id="search" placeholder="Search bought games" onkeyup="searchFunction()">
        <div id="results"></div>
    </div>

</body>
</html>
