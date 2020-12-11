<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="isAuthenticated()">
            <li class="nav--actions">
            <li class="logged-user">
                Witaj <sec:authentication property="principal.username"/>

                <sec:authorize access="hasRole('ADMIN')">
                    <ul class="dropdown">
                        <li><a href="/admin/dashboard">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="#">Wyloguj</a></li>
                    </ul>
                </sec:authorize>
                <sec:authorize access="hasRole('USER')">
                    <ul class="dropdown">
                        <li><a href="/user/dashboard">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="#">Wyloguj</a></li>
                    </ul>
                </sec:authorize>
            </li>
            </sec:authorize>
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>


