package DAO;

/**
 *
 * @author Celia Navarro Garrido
 */

import Clases.Asignatura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {

    public List<Asignatura> listarAsignaturas() {
        List<Asignatura> asignaturas = new ArrayList<>();
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM asignaturas");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                asignaturas.add(new Asignatura(rs.getInt("id"), rs.getString("nombre"), rs.getString("codigo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asignaturas;
    }

    public void insertarAsignatura(Asignatura asignatura) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO asignaturas (nombre, descripcion) VALUES (?, ?)")) {
            ps.setString(1, asignatura.getNombre());
            ps.setString(2, asignatura.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarAsignatura(int id) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM asignaturas WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Asignatura obtenerPorId(int id) {
    Asignatura asignatura = null;
    String sql = "SELECT * FROM asignaturas WHERE id = ?";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            asignatura = new Asignatura(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return asignatura;
}

}
