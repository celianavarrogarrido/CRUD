/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Clases.Asignatura;
import DAO.AsignaturaDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ControladorAsignatura extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AsignaturaDAO dao = new AsignaturaDAO();
        request.setAttribute("listaAsignaturas", dao.listarAsignaturas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("codigo");

        Asignatura asignatura = new Asignatura(nombre, codigo);
        AsignaturaDAO dao = new AsignaturaDAO();
        dao.insertarAsignatura(asignatura);

        response.sendRedirect("ControladorAsignatura");
    }
}
