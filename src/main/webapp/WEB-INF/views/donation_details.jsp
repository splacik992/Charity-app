<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Zacznij pomagać!<br/>
            Oddaj niechciane rzeczy w zaufane ręce
        </h1>
    </div>
</div>
</header>
<section class="help" id="help">
    <h2>Lista Twoich Darów</h2>

    <div class="help--slides active" data-id="1">
        <li class="help--slides-items">
            <table class="dary">
                <tr>


                    <th>Organizacja</th>
                    <th>Ilość</th>
                    <th>Data</th>

                </tr>

                <c:forEach items="${donations}" var="don">

                    <tr>
                        <td>${don.organization.name}</td>
                        <td>${don.quantity}</td>
                        <td>${don.pickUpDate}</td>
                    </tr>

                </c:forEach>
            </table>
        </li>
    </div>

</section>
<section class="steps" id="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>
    <sec:authorize access="hasRole('USER')">
        <a href="/form" class="btn btn--large">Wyślij rzeczy</a>
    </sec:authorize>
</section>



<%@ include file="/WEB-INF/views/footer.jsp" %>
