<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/panel/header.jsp" %>


<div class="card-body">
    <form:form method="post" modelAttribute="user">
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <label for="user"><b>Nowe hasło</b></label>
            <input name="password" type="text" class="form-control" id=user
                   placeholder="Wpisz tutaj">
        </div>
        <div class="form-group">
            <label for="username"><b>Powtórz hasło</b></label>
            <input name="matchingPassword" type="text" class="form-control" id=username
                   placeholder="Wpisz tutaj">
        </div>

        <div class="d-sm-flex align-items-center justify-content-center ">

            <label>
                <button type="submit" name="submit" class="btn btn-outline-primary">Akceptuj
                </button>
            </label>
        </div>
    </form:form>
</div>



<%@ include file="/WEB-INF/views/panel/footer.jsp" %>