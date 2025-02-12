<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Inicio - Gestión de Asignaturas</title>
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
            margin-top: 50px;
        }

        .alert-info {
            background-color: #e0f7fa; /* Azul suave */
            color: #00796b;
        }

        .card {
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 15px;
            margin-bottom: 20px;
            transition: transform 0.3s ease; /* Agregar animación en hover */
        }

        .card:hover {
            transform: translateY(-5px); /* Efecto hover */
        }

        .card-header {
            background-color: #4CAF50; /* Verde */
            color: white;
            font-size: 1.2rem;
            border-radius: 15px 15px 0 0;
        }

        .card-body {
            background-color: #ffffff;
        }

        .btn-primary {
            background-color: #00796b; /* Verde oscuro */
            border-color: #00796b;
            padding: 10px 20px;
            font-size: 1rem;
        }

        .btn-primary:hover {
            background-color: #004d40; /* Verde más oscuro */
            border-color: #004d40;
        }

        .btn-link {
            color: #00796b;
            font-weight: bold;
        }

        .btn-link:hover {
            text-decoration: underline;
        }

        /* Estilos para dispositivos móviles */
        @media (max-width: 768px) {
            .card-body {
                text-align: center;
            }
        }
    </style>
</head>
<body>

      <!-- Incluir el navbar -->
    <%@ include file="navbar.jsp" %>

    <!-- Contenedor principal -->
    <div class="container">
        <div class="alert alert-info" role="alert">
            ¡Bienvenido a la Gestión de Asignaturas! Selecciona una de las siguientes opciones para gestionar las entidades.
        </div>

        <!-- Opciones en formato de tarjeta -->
        <div class="row">
            <!-- Tarjeta de Asignaturas -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-header">
                        <i class="fas fa-book"></i> Asignaturas
                    </div>
                    <div class="card-body">
                        <p>Administra las asignaturas que forman parte de la gestión académica.</p>
                        <a href="asignaturas.jsp" class="btn btn-primary">Ir a Asignaturas</a>
                    </div>
                </div>
            </div>
            <!-- Tarjeta de Resultados -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-header">
                        <i class="fas fa-chart-line"></i> Resultados de Aprendizaje
                    </div>
                    <div class="card-body">
                        <p>Administra los resultados obtenidos por los estudiantes.</p>
                        <a href="resultados.jsp" class="btn btn-primary">Ir a Resultados</a>
                    </div>
                </div>
            </div>
            <!-- Tarjeta de Criterios -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-header">
                        <i class="fas fa-list-alt"></i> Criterios de Evaluación
                    </div>
                    <div class="card-body">
                        <p>Define los criterios que se utilizarán para evaluar a los estudiantes.</p>
                        <a href="criterios.jsp" class="btn btn-primary">Ir a Criterios</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
