<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h2>Funcionarios</h2>
    <!--Search Form -->
    <form action="/employee" method="get" id="seachEmployeeForm" role="form">
        <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
        <div class="form-group col-xs-5">
            <input type="text" name="employeeName" id="employeeName" class="form-control" required="true" placeholder="Digite o Nome e Sobrenome do funcionario"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Buscar
        </button>
        <br></br>
        <br></br>
    </form>

    <!--Employees List-->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
    <form action="/employee" method="post" id="employeeForm" role="form" >
        <input type="hidden" id="idEmployee" name="idEmployee">
        <input type="hidden" id="action" name="action">
        <c:choose>
            <c:when test="${not empty employeeList}">
                <table  class="table table-striped">
                    <thead>
                    <tr>
                        <td>#</td>
                        <td>Nome</td>
                        <td>Sobrenome</td>
                        <td>Data de Nascimento</td>
                        <td>Cargo</td>
                        <td>Departamento</td>
                        <td>E-mail</td>
                        <td></td>
                    </tr>
                    </thead>
                    <c:forEach var="employee" items="${employeeList}">
                        <c:set var="classSucess" value=""/>
                        <c:if test ="${idEmployee == employee.id}">
                            <c:set var="classSucess" value="info"/>
                        </c:if>
                        <tr class="${classSucess}">
                            <td>
                                <a href="/employee?idEmployee=${employee.id}&searchAction=searchById">${employee.id}</a>
                            </td>
                            <td>${employee.name}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.birthDate}</td>
                            <td>${employee.role}</td>
                            <td>${employee.department}</td>
                            <td>${employee.email}</td>
                            <td><a href="#" id="remove"
                                   onclick="document.getElementById('action').value = 'remove';document.getElementById('idEmployee').value = '${employee.id}';

                                           document.getElementById('employeeForm').submit();">
                                <span class="glyphicon glyphicon-trash"/>
                            </a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-info">
                    Nenhum registro encontrado
                </div>
            </c:otherwise>
        </c:choose>
    </form>
    <form action ="jsp/new-employee.jsp">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Adicionar Funcionario</button>
    </form>
</div>
</body>
</html>