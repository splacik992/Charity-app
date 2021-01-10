
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form method="post" action="/change/password/${user.email}/${user.hashCodeForSetAccountEnabled}">
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
            <form:errors path="password"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
            <form:errors path="password"/>
        </div>
        <div class="form-group--buttons">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn" type="submit">Akceptuj</button>
        </div>
    </form>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>