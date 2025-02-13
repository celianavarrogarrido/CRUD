package Controlador;

import DAO.CriterioDAO;
import Clases.CriterioEvaluacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/ControladorCriterio")
public class ControladorCriterio extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CriterioDAO criterioDAO;

    public ControladorCriterio() {
        super();
        this.criterioDAO = new CriterioDAO();
    }

    // Mostrar la lista de criterios
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("listar".equals(action)) {
            int idAsignatura = Integer.parseInt(request.getParameter("id_asignatura"));
            List<CriterioEvaluacion> criterios = criterioDAO.listarCriterios(idAsignatura);
            request.setAttribute("criterios", criterios);
            request.getRequestDispatcher("gestionarCriterios.jsp").forward(request, response);

        } else if ("eliminar".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            criterioDAO.eliminarCriterio(id);
            response.sendRedirect("ControladorCriterio?action=listar&id_asignatura=" + request.getParameter("id_asignatura"));
        }
    }

    // Crear o editar un criterio
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insertar".equals(action)) {
            String criterio = request.getParameter("criterio");
            int idAsignatura = Integer.parseInt(request.getParameter("id_asignatura"));

            CriterioEvaluacion nuevoCriterio = new CriterioEvaluacion();
            nuevoCriterio.setCriterio(criterio);
            nuevoCriterio.setIdAsignatura(idAsignatura);

            criterioDAO.insertarCriterio(nuevoCriterio);
            response.sendRedirect("ControladorCriterio?action=listar&id_asignatura=" + idAsignatura);

        } else if ("editar".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String criterio = request.getParameter("criterio");

            CriterioEvaluacion criterioExistente = new CriterioEvaluacion();
            criterioExistente.setId(id);
            criterioExistente.setCriterio(criterio);

            criterioDAO.editarCriterio(criterioExistente);
            response.sendRedirect("ControladorCriterio?action=listar&id_asignatura=" + request.getParameter("id_asignatura"));
        }
    }
}
