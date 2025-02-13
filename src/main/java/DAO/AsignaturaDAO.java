package DAO;

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
            Asignatura asignatura = new Asignatura(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
            asignaturas.add(asignatura);
            System.out.println("Asignatura encontrada: " + asignatura.getId() + " - " + asignatura.getNombre());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return asignaturas;
}

    public void insertarAsignatura(Asignatura asignatura) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO asignaturas (nombre, descripcion) VALUES (?, ?)")) { // 'asignaturas' en lugar de 'asignatura'
            ps.setString(1, asignatura.getNombre());
            ps.setString(2, asignatura.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarAsignatura(int id) {
        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM asignaturas WHERE id = ?")) {  // Asegúrate de que es 'asignaturas'
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Asignatura obtenerPorId(int id) {
        Asignatura asignatura = null;
        String sql = "SELECT * FROM asignaturas WHERE id = ?";  // 'asignaturas' aquí también
        
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
