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
    <a href="home-page.jsp" >Home page</a>
    <%@ include file = "show-games.jsp"%>

</body>
</html>