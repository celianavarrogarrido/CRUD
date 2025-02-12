<%@page import="java.util.List"%>
<%@page import="Clases.Asignatura"%>
<%@page import="DAO.AsignaturaDAO"%>

<%
    AsignaturaDAO dao = new AsignaturaDAO();
    List<Asignatura> asignaturas = dao.listarAsignaturas();
%>
<!DOCTYPE html>
<html lang="es">
    <head>
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
                        <th>Código</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Asignatura asignatura : asignaturas) {
                    %>
                    <tr>
                        <td><%= asignatura.getId() %></td>
                        <td><%= asignatura.getNombre() %></td>
                        <td><%= asignatura.getCodigo() %></td>
                        <td>
                            <a href="editarAsignaturas.jsp?id=<%= asignatura.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                            <a href="ControladorAsignatura?action=eliminar&id=<%= asignatura.getId() %>" class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Estás seguro de que deseas eliminar esta asignatura?');">Eliminar</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="nuevaAsignatura.jsp" class="btn btn-primary">Nueva Asignatura</a>
        </div>
    </body>
</html>
