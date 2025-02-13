package DAO;

import Clases.ResultadoAprendizaje;
import java.sql.*;

public class ResultadoAprendizajeDAO {

    // Método para obtener un resultado de aprendizaje por su ID
    public ResultadoAprendizaje obtenerResultadoPorId(int id) {
        ResultadoAprendizaje resultado = null;
        try (Connection con = Database.getConnection()) {
            String sql = "SELECT * FROM resultados_aprendizaje WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        resultado = new ResultadoAprendizaje();
                        resultado.setId(rs.getInt("id"));
                        resultado.setIdAsignatura(rs.getInt("id_asignatura"));
                        resultado.setResultado(rs.getString("resultado"));
                        resultado.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    // Método para actualizar un resultado de aprendizaje
    public void actualizarResultado(ResultadoAprendizaje resultado) {
        try (Connection con = Database.getConnection()) {
            String sql = "UPDATE resultados_aprendizaje SET resultado = ?, id_asignatura = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, resultado.getResultado());
                ps.setInt(2, resultado.getIdAsignatura());
                ps.setInt(3, resultado.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un resultado de aprendizaje por su ID
    public void eliminarResultado(int id) {
        try (Connection con = Database.getConnection()) {
            String sql = "DELETE FROM resultados_aprendizaje WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
