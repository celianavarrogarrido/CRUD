/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author DAW2
 */
public class ResultadoApredizaje {
    private int id;
    private String descripcion;
    private int asignaturaId;

 
    // Constructor con parámetros
    public ResultadoApredizaje(int id, String descripcion, int asignaturaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.asignaturaId = asignaturaId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    // Método toString (opcional para depuración)
    @Override
    public String toString() {
        return "ResultadoAprendizaje{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", asignaturaId=" + asignaturaId +
                '}';
    }
}
