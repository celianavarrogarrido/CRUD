
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author  Celia Navarro Garrido
 */
public class Asignatura {
    private int id;
    private String nombre;
    private String descripcion;

    public Asignatura() {}

    public Asignatura(int id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Asignatura(String nombre, String codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
