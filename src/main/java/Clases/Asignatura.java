package Clases;

/**
 * Clase que representa una asignatura.
 * 
 * @author Celia Navarro Garrido
 */
public class Asignatura {
    private int id;
    private String nombre;
    private String descripcion;

    // Constructor por defecto
    public Asignatura() {}

    // Constructor con id, nombre y descripcion (según la base de datos)
    public Asignatura(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Constructor sin id (usado al insertar una nueva asignatura)
    public Asignatura(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters para cada campo
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
