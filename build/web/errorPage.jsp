<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("pageTitle", "404 Not Found - MyShop");%>
<%@ include file="_header.jsp" %>
<%@ include file="_navbar.jsp" %>
<div class="container">
    <h1 class="mt-3">Uh oh, Something went wrong...</h1>
    <a class="btn btn-primary" href="home">Back Home</a>
</div>


<%@ include file="_footer.jsp" %>