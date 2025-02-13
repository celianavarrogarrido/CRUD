<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="DAO.Database" %>


<!-- Incluir el navbar -->
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Asignaturas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Gestión de Asignaturas</h1>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iteramos sobre las asignaturas con JSTL -->
                <c:forEach var="asignatura" items="${asignaturas}">
                    <tr>
                        <td>${asignatura.id}</td> <!-- Se mantiene el 'id' -->
                        <td>${asignatura.nombre}</td> <!-- Se mantiene el 'nombre' -->
                        <td>${asignatura.descripcion}</td> <!-- Se mantiene la 'descripcion' -->
                        <td>
                            <!-- Enlace de edición -->
                            <a href="editarAsignaturas.jsp?id=${asignatura.id}" class="btn btn-warning btn-sm">Editar</a>
                            <!-- Enlace de eliminación con confirmación -->
                            <a href="ControladorAsignatura?action=eliminar&id=${asignatura.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Estás seguro de que deseas eliminar esta asignatura?');">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <!-- Botón para agregar nueva asignatura -->
        <a href="nuevaAsignatura.jsp" class="btn btn-primary">Nueva Asignatura</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
