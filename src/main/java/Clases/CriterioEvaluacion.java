/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author DAW2
 */
public class CriterioEvaluacion {
    private int id;
    private String descripcion;
    private int resultadoAprendizajeId;

    // Constructor vacío
    public CriterioEvaluacion() {
    }

    // Constructor con parámetros
    public CriterioEvaluacion(int id, String descripcion, int resultadoAprendizajeId) {
        this.id = id;
        this.descripcion = descripcion;
        this.resultadoAprendizajeId = resultadoAprendizajeId;
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

    public int getResultadoAprendizajeId() {
        return resultadoAprendizajeId;
    }

    public void setResultadoAprendizajeId(int resultadoAprendizajeId) {
        this.resultadoAprendizajeId = resultadoAprendizajeId;
    }

    // Método toString (opcional, pero útil para depuración)
    @Override
    public String toString() {
        return "CriterioEvaluacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", resultadoAprendizajeId=" + resultadoAprendizajeId +
                '}';
    }
}
