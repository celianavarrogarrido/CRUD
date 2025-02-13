package DAO;

import Clases.CriterioEvaluacion;
import java.sql.*;
import java.util.*;

public class CriterioDAO {

    // Método para listar los criterios de evaluación asociados a una asignatura
    public List<CriterioEvaluacion> listarCriterios(int idAsignatura) {
        List<CriterioEvaluacion> criterios = new ArrayList<>();
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM criterios_evaluacion WHERE id_asignatura = ?")) {
            ps.setInt(1, idAsignatura);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                criterios.add(new CriterioEvaluacion(
                        rs.getInt("id"),
                        rs.getString("criterio"),
                        rs.getInt("id_asignatura")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return criterios;
    }

    // Método para insertar un nuevo criterio de evaluación
    public void insertarCriterio(CriterioEvaluacion criterio) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO criterios_evaluacion (criterio, id_asignatura) VALUES (?, ?)")) {
            ps.setString(1, criterio.getCriterio());
            ps.setInt(2, criterio.getIdAsignatura());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para editar un criterio de evaluación existente
    public void editarCriterio(CriterioEvaluacion criterio) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE criterios_evaluacion SET criterio = ? WHERE id = ?")) {
            ps.setString(1, criterio.getCriterio());
            ps.setInt(2, criterio.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un criterio de evaluación por ID
    public void eliminarCriterio(int id) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM criterios_evaluacion WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
