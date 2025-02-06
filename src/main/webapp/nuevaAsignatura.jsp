<%-- 
    Document   : nuevaAsignatura
    Created on : 4 feb 2025, 11:30:20
    Author     : DAW2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Nueva Asignatura</h1>
        <form action="ControladorAsignatura" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" required>
            </div>
            <div class="mb-3">
                <label for="codigo" class="form-label">Código</label>
                <input type="text" class="form-control" name="codigo" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="ControladorAsignatura" class="btn btn-secondary">Cancelar</a>
            <a href="nuevaAsignatura.jsp" class="btn btn-primary mb-3">Nueva Asignatura</a>

        
        </form>
        
    </div>
</body>
</html>

