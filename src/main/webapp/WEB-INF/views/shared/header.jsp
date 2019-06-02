<%-- 
    Document   : header
    Created on : Jun 2, 2019, 5:04:27 PM
    Author     : HP B&O
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${SITE_URL}/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
            <link rel="stylesheet" href="${SITE_URL}/webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css"/>
</head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>