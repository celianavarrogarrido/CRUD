package Controlador;

import Clases.Asignatura;
import DAO.AsignaturaDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ControladorAsignatura extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        AsignaturaDAO dao = new AsignaturaDAO();
        
        try {
            if ("eliminar".equals(action)) {
                String idParam = request.getParameter("id");
                if (idParam != null && idParam.matches("\\d+")) {  // Validación básica para evitar errores
                    int id = Integer.parseInt(idParam);
                    dao.eliminarAsignatura(id);
                    request.setAttribute("mensaje", "Asignatura eliminada con éxito.");
                } else {
                    request.setAttribute("mensaje", "ID inválido para eliminar.");
                }
            }
            
            // Listar asignaturas (por defecto)
            request.setAttribute("asignaturas", dao.listarAsignaturas());
            RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "Ocurrió un error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        try {
            if (nombre != null && !nombre.isEmpty() && descripcion != null && !descripcion.isEmpty()) {
                Asignatura asignatura = new Asignatura(nombre, descripcion);
                AsignaturaDAO dao = new AsignaturaDAO();
                dao.insertarAsignatura(asignatura);
                request.setAttribute("mensaje", "Asignatura agregada con éxito.");
            } else {
                request.setAttribute("mensaje", "El nombre y la descripción de la asignatura son obligatorios.");
            }
        } catch (Exception e) {
            request.setAttribute("mensaje", "Error al agregar asignatura: " + e.getMessage());
        }

        // Redirige nuevamente al método GET para listar las asignaturas y mostrar el mensaje
        response.sendRedirect("ControladorAsignatura");
    }
}
