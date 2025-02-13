package Controlador;

import DAO.ResultadoAprendizajeDAO;
import Clases.ResultadoAprendizaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/ResultadoAprendizajeController")
public class ControladorResultado extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Instancia del DAO
    private ResultadoAprendizajeDAO resultadoDAO;

    // Inicialización del servlet
    public void init() {
        resultadoDAO = new ResultadoAprendizajeDAO(); // Inicializar el DAO
    }

    // Método para procesar las solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el parámetro 'resultadoId' de la URL
        String action = request.getParameter("action");

        if (action != null && action.equals("ver")) {
            // Mostrar un resultado de aprendizaje por su ID
            int resultadoId = Integer.parseInt(request.getParameter("resultadoId"));
            ResultadoAprendizaje resultado = resultadoDAO.obtenerResultadoPorId(resultadoId);

            if (resultado != null) {
                // Si el resultado existe, lo pasamos al JSP
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("/verResultado.jsp").forward(request, response);
            } else {
                // Si no se encuentra el resultado
                response.sendRedirect("error.jsp");
            }
        }
    }
} 


          

