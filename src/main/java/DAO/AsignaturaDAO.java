
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Asignatura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Celia Navarro Garrido
 */
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
             PreparedStatement ps = con.prepareStatement("INSERT INTO asignaturas (nombre, codigo) VALUES (?, ?)")) {
            ps.setString(1, asignatura.getNombre());
            ps.setString(2, asignatura.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    //Método para obtener por ID la asignatura
    public Asignatura obtenerPorId(int id) {
    Asignatura asignatura = null;
    try (Connection con = Database.getConnection();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM asignaturas WHERE id = ?")) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            asignatura = new Asignatura(rs.getInt("id"), rs.getString("nombre"), rs.getString("codigo"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return asignatura;
}

public void actualizarAsignatura(Asignatura asignatura) {
    try (Connection con = Database.getConnection();
         PreparedStatement ps = con.prepareStatement("UPDATE asignaturas SET nombre = ?, codigo = ? WHERE id = ?")) {
        ps.setString(1, asignatura.getNombre());
        ps.setString(2, asignatura.getCodigo());
        ps.setInt(3, asignatura.getId());
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//Método para eliminar asgnaturas
public void eliminarAsignatura(int id) { //método para eliminar una asignatura por su ID.
    try (Connection con = Database.getConnection();
         PreparedStatement ps = con.prepareStatement("DELETE FROM asignaturas WHERE id = ?")) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
