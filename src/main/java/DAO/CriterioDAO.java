/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import Clases.CriterioEvaluacion;
import java.sql.*;
import java.util.*;

public class CriterioDAO {

    // Método para listar los criterios de evaluación asociados a un Resultado de Aprendizaje
    public List<CriterioEvaluacion> listarCriterios(int resultadoAprendizajeId) {
        List<CriterioEvaluacion> criterios = new ArrayList<>();
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM criterios WHERE resultado_aprendizaje_id = ?")) {
            ps.setInt(1, resultadoAprendizajeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                criterios.add(new CriterioEvaluacion(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getInt("resultado_aprendizaje_id")
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
             PreparedStatement ps = con.prepareStatement("INSERT INTO criterios (descripcion, resultado_aprendizaje_id) VALUES (?, ?)")) {
            ps.setString(1, criterio.getDescripcion());
            ps.setInt(2, criterio.getResultadoAprendizajeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para editar un criterio de evaluación existente
    public void editarCriterio(CriterioEvaluacion criterio) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE criterios SET descripcion = ? WHERE id = ?")) {
            ps.setString(1, criterio.getDescripcion());
            ps.setInt(2, criterio.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un criterio de evaluación por ID
    public void eliminarCriterio(int id) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM criterios WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

