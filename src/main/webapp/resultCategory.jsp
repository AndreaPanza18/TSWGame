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

    <ul class="top-navbar">
        <li><a href="home-page.jsp" >Home page</a></li>
        <li><h1 style="margin-left: 400px">All ${search} games</h1><li>
    </ul>

    <%@ include file = "show-games.jsp"%>

</body>
</html>