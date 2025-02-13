<%@ page import="java.util.List" %>
<%@ page import="DAO.CriterioDAO" %>
<%@ page import="DAO.ResultadoAprendizajeDAO" %>
<%@ page import="Clases.CriterioEvaluacion" %>
<%@ page import="Clases.ResultadoAprendizaje" %>

<%
    // Obtener el id del Resultado de Aprendizaje desde la URL
    int resultadoAprendizajeId = Integer.parseInt(request.getParameter("resultadoId"));
    
    // Crear instancias de los DAOs
    CriterioDAO criterioDAO = new CriterioDAO();
    ResultadoAprendizajeDAO resultadoDAO = new ResultadoAprendizajeDAO();

    // Obtener los criterios de evaluación asociados a este resultado de aprendizaje
    List<CriterioEvaluacion> criterios = criterioDAO.listarCriterios(resultadoAprendizajeId);

    // Obtener el Resultado de Aprendizaje (RA) usando su ID
    ResultadoAprendizaje resultadoAprendizaje = resultadoDAO.obtenerResultadoPorId(resultadoAprendizajeId);
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Criterios - <%= resultadoAprendizaje.getResultado() %></title>

    <!-- Bootstrap 5.3 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Fuentes de Google -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet">
    
    <!-- Font Awesome (para los iconos) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    
    <!-- Estilos personalizados -->
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f8f9; /* Fondo claro */
        }

        .container {
            margin-top: 100px; /* Espacio superior */
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); /* Sombra */
            padding: 20px;
            background-color: white;
            border-radius: 15px;
        }

        .btn-primary {
            background-color: #00796b;
            border-color: #00796b;
        }

        .btn-primary:hover {
            background-color: #004d40;
            border-color: #004d40;
        }

        .alert-info {
            background-color: #e0f7fa; /* Azul suave */
            color: #00796b;
        }

        .navbar-custom {
            background-color: #00796b;
        }

        .navbar-custom a {
            color: white;
        }

        .navbar-custom a:hover {
            color: #004d40;
        }
    </style>
</head>
<body>

    <!-- Incluir el navbar -->
    <%@ include file="navbar.jsp" %>

    <!-- Contenedor principal -->
    <div class="container">
        <h1>Gestión de Criterios de Evaluación</h1>
        <h3>Resultado de Aprendizaje: <%= resultadoAprendizaje.getResultado() %></h3>

        <!-- Tabla de Criterios -->
        <table class="table mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descripción</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Iterar sobre los criterios de evaluación
                    for (CriterioEvaluacion criterio : criterios) {
                %>
                <tr>
                    <td><%= criterio.getId() %></td>
                    <td><%= criterio.getCriterio() %></td> <!-- Se cambió a criterio.getCriterio() -->
                    <td>
                        <!-- Enlace para editar el criterio -->
                        <a href="editarCriterio.jsp?id=<%= criterio.getId() %>&resultadoId=<%= resultadoAprendizajeId %>" class="btn btn-warning btn-sm">Editar</a>
                        <!-- Enlace para eliminar el criterio -->
                        <a href="eliminarCriterio.jsp?id=<%= criterio.getId() %>&resultadoId=<%= resultadoAprendizajeId %>" class="btn btn-danger btn-sm">Eliminar</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <!-- Botón para crear un nuevo criterio -->
        <a href="nuevoCriterio.jsp?resultadoId=<%= resultadoAprendizajeId %>" class="btn btn-primary">Nuevo Criterio</a>

        <!-- Volver a la página de resultados de aprendizaje -->
        <a href="resultados.jsp" class="btn btn-secondary mt-3">Volver a Resultados de Aprendizaje</a>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
