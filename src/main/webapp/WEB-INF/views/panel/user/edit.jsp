<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/panel/header.jsp" %>





<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Edycja</h6>
    </div>

    <div class="card sidebar-light shadow m-5">
        <div class="card-header py-3">
            <div class="card-body">
                <form:form method="post" modelAttribute="user">
                    <input type="hidden" name="id" value="${user.id}"/>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input value="${user.email}" name="email" type="email" class="form-control" id=email
                               placeholder="Email">
                    </div>

                    <div class="form-group">
                        <label for="firstName">Imie</label>
                        <input value="${user.firstName}" name="firstName" type="text" class="form-control"
                               id=firstName
                               placeholder="Imie">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Nazwisko</label>
                        <input value="${user.lastName}" name="lastName" type="text" class="form-control"
                               id=lastName
                               placeholder="Nazwisko">
                    </div>

                    <div class="d-sm-flex align-items-center justify-content-center ">

                        <label>

                            <button type="submit" name="submit" class="btn btn-outline-primary">Akceptuj
                            </button>
                        </label>

                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/panel/footer.jsp" %>