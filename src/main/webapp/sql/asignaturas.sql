/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  DAW2
 * Created: 5 feb 2025
 */

-- Crear la tabla de asignaturas
CREATE TABLE asignaturas (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- Identificador único para cada asignatura
    nombre VARCHAR(255) NOT NULL,          -- Nombre de la asignatura
    descripcion TEXT,                     -- Descripción de la asignatura
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Fecha de creación automática
);

-- Crear la tabla de resultados de aprendizaje
CREATE TABLE resultados_aprendizaje (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- Identificador único para el resultado de aprendizaje
    id_asignatura INT,                    -- Relación con la tabla asignaturas
    resultado TEXT NOT NULL,              -- Descripción del resultado de aprendizaje
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación automática
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id) ON DELETE CASCADE -- Relación con asignaturas
);

-- Crear la tabla de criterios de evaluación
CREATE TABLE criterios_evaluacion (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- Identificador único para el criterio de evaluación
    id_asignatura INT,                    -- Relación con la tabla asignaturas
    criterio TEXT NOT NULL,               -- Descripción del criterio de evaluación
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación automática
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id) ON DELETE CASCADE -- Relación con asignaturas
);
-- Insertar las asignaturas del ciclo de Desarrollo de Aplicaciones Web
INSERT INTO asignaturas (nombre, descripcion)
VALUES
('Programación', 'Desarrollo de algoritmos y programas utilizando lenguajes como Java, C#, y Python.'),
('Desarrollo Web en Entorno Servidor', 'Creación de aplicaciones web en el lado del servidor utilizando PHP, Node.js, o Java.'),
('Bases de Datos', 'Fundamentos de bases de datos relacionales, administración y manejo de datos utilizando SQL.');

-- Insertar los Resultados de Aprendizaje (RA) para cada asignatura
-- Para Programación
INSERT INTO resultados_aprendizaje (id_asignatura, resultado)
VALUES
(1, 'El estudiante debe ser capaz de desarrollar programas funcionales utilizando diversos lenguajes de programación.'),
(1, 'El estudiante debe comprender y aplicar principios de programación orientada a objetos.');

-- Para Desarrollo Web en Entorno Servidor
INSERT INTO resultados_aprendizaje (id_asignatura, resultado)
VALUES
(2, 'El estudiante debe desarrollar aplicaciones web dinámicas en el servidor utilizando tecnologías como Node.js o PHP.'),
(2, 'El estudiante debe ser capaz de trabajar con bases de datos y conectarlas con aplicaciones web.');

-- Para Bases de Datos
INSERT INTO resultados_aprendizaje (id_asignatura, resultado)
VALUES
(3, 'El estudiante debe ser capaz de diseñar y gestionar bases de datos relacionales utilizando SQL.'),
(3, 'El estudiante debe poder implementar procedimientos almacenados y optimizar consultas en bases de datos.');

-- Insertar los Criterios de Evaluación para cada asignatura
-- Para Programación
INSERT INTO criterios_evaluacion (id_asignatura, criterio)
VALUES
(1, 'Se evaluará la capacidad de desarrollar programas funcionales, optimizados y bien estructurados.'),
(1, 'La evaluación será tanto teórica como práctica, con énfasis en la resolución de problemas reales.');

-- Para Desarrollo Web en Entorno Servidor
INSERT INTO criterios_evaluacion (id_asignatura, criterio)
VALUES
(2, 'Se evaluará el desarrollo y la implementación de aplicaciones web en el lado del servidor con uso de bases de datos.'),
(2, 'Se evaluará la capacidad de aplicar técnicas de seguridad en aplicaciones web.');

-- Para Bases de Datos
INSERT INTO criterios_evaluacion (id_asignatura, criterio)
VALUES
(3, 'Se evaluará la capacidad de diseñar esquemas de bases de datos eficientes.'),
(3, 'Se evaluará el uso adecuado de SQL para la gestión y manipulación de grandes volúmenes de datos.');
