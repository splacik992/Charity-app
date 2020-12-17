<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
    </header>

    <section class="login-page">

      <h2>Załóż konto</h2>
      <form:form method="post" modelAttribute="user">

        <div class="form-group">
          <form:input path="email" type="email" placeholder="Email" />
          <form:errors path="email"/> ${message}
        </div>

        <div class="form-group">
          <form:input path="password" type="password" name="password" placeholder="Hasło" />
          <form:errors path="password"/> ${messagePassword}
        </div>

        <div class="form-group">
          <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>
        <div class="form-group">
          <form:input path="firstName" type="text" name="firstName" placeholder="Imię" />
        </div>
        <div class="form-group">
          <form:input path="lastName" type="text" name="lastName" placeholder="Nazwisko" />
        </div>
      <div class="form-group--buttons">
        <div class="form-group--buttons">
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </div>
      </form:form>
    </section>

<%@ include file="/WEB-INF/views/footer.jsp" %>