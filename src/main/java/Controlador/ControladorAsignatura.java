package Controlador;

import Clases.Asignatura;
import DAO.AsignaturaDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ControladorAsignatura extends HttpServlet {

    // Método para mostrar la lista de asignaturas
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("eliminar".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            AsignaturaDAO dao = new AsignaturaDAO();
            dao.eliminarAsignatura(id);
            response.sendRedirect("ControladorAsignatura");
        } else {
            AsignaturaDAO dao = new AsignaturaDAO();
            request.setAttribute("asignaturas", dao.listarAsignaturas());
            RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Método para insertar una nueva asignatura
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("codigo");

        Asignatura asignatura = new Asignatura(nombre, codigo);
        AsignaturaDAO dao = new AsignaturaDAO();
        dao.insertarAsignatura(asignatura);

        response.sendRedirect("ControladorAsignatura");
    }
}
