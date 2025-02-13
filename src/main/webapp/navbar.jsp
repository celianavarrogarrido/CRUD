<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Inicio</title>
    <!-- Bootstrap 5.3 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos personalizados (opcional) -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f8f9; /* Fondo claro */
            margin: 0;
        }
        .navbar {
            background-color: #46dbce; /* Color actualizado del navbar */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Sombra suave */
            border-radius: 10px; /* Bordes redondeados */
            padding: 10px 20px;
        }
        .navbar .navbar-brand, .navbar .nav-link {
            color: #ffffff !important;
            transition: color 0.3s ease; /* Transición suave para los enlaces */
        }
        .navbar .nav-link:hover {
            color: #fff5e6 !important; /* Efecto hover suave */
        }
        .navbar .navbar-brand img {
            max-width: 120px;  /* Tamaño de la imagen */
            height: auto;      /* Mantener la proporción de la imagen */
        }
        .navbar .navbar-nav {
            margin-left: auto; /* Centrar los elementos a la derecha */
        }
        .navbar-nav .nav-item {
            margin-left: 15px;
            font-size: 1.1rem;
        }
        .navbar-toggler-icon {
            background-color: #ffffff;
        }

        /* Estilos para dispositivos móviles */
        @media (max-width: 768px) {
            .navbar .navbar-nav {
                text-align: center;
            }
            .navbar .navbar-brand {
                text-align: center;
                margin-bottom: 10px;
            }
        }
    </style>
</head>
<body>

     <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <!-- Aquí está la imagen centrada -->
            <a class="navbar-brand" href="#">
                <img src="images/logo_gestion.png" alt="logo gestor" />
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="index.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="asignaturas.jsp">Asignaturas</a> <!-- Enlace actualizado -->
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="resultados.jsp">R.A</a> <!-- Enlace actualizado -->
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="criterios.jsp">Criterios</a> 
                </ul>
            </div>
        </div>
    </nav>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
