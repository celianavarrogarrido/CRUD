<%@ page import="clases.Asignatura, dao.AsignaturaDAO" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    AsignaturaDAO dao = new AsignaturaDAO();
    Asignatura asignatura = dao.obtenerPorId(id);
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Editar Asignatura</h1>
        <form action="ControladorAsignatura" method="post">
            <input type="hidden" name="id" value="<%= asignatura.getId() %>">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" value="<%= asignatura.getNombre() %>" required>
            </div>
            <div class="mb-3">
                <label for="codigo" class="form-label">Código</label>
                <input type="text" class="form-control" name="codigo" value="<%= asignatura.getCodigo() %>" required>
            </div>
            <button type="submit" class="btn btn-success">Guardar Cambios</button>
            <a href="ControladorAsignatura" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
