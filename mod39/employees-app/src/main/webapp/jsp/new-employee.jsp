<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form action="/employee" method="post"  role="form" data-toggle="validator" >
        <c:if test ="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <input type="hidden" id="action" name="action" value="${action}"/>
        <input type="hidden" id="idEmployee" name="idEmployee" value="${employee.id}"/>
        <h2>Funcionario</h2>
        <div class="form-group col-xs-4">
            <label for="name" class="control-label col-xs-4">Nome:</label>
            <input type="text" name="name" id="name" class="form-control" value="${employee.name}"
                   required="true"/>

            <label for="lastName" class="control-label col-xs-4">Sobrenome:</label>
            <input type="text" name="lastName" id="lastName" class="form-control" value="${employee.lastName}"
                   required="true"/>

            <label for="birthdate" class="control-label col-xs-4">Data de Nascimento</label>
            <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="birthDate" id="birthdate" class="form-control"
                   value="${employee.birthDate}" maxlength="10" placeholder="dd-MM-yyy" required="true"/>

            <label for="role" class="control-label col-xs-4">Cargo:</label>
            <input type="text" name="role" id="role" class="form-control" value="${employee.role}"
                   required="true"/>

            <label for="department" class="control-label col-xs-4">Departamento:</label>
            <input type="text" name="department" id="department" class="form-control"
                   value="${employee.department}" required="true"/>

            <label for="department" class="control-label col-xs-4">E-mail:</label>
            <input type="text" name="email" id="email" class="form-control" value="${employee.email}"
                   placeholder="smith@aol.com" required="true"/>

            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Registrar</button>
        </div>
    </form>
</div>
</body>
</html>