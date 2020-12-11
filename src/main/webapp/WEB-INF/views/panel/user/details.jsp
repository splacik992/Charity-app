
<%@ include file="/WEB-INF/views/panel/header.jsp" %>


<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Informacje</h6>
    </div>

    <div class="card sidebar-light shadow m-5">
        <div class="card-header ">

                <table class="table">

                    <tr>
                        <th>Email</th>
                        <td>${user.email}</td>
                    </tr>
                    <tr>
                        <th>Imie</th>
                        <td>${user.firstName}</td>
                    </tr>
                    <tr>
                        <th>Nazwisko</th>
                        <td>${user.lastName}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

<%@ include file="/WEB-INF/views/panel/footer.jsp" %>