package Clases;

import java.util.Date;

public class ResultadoAprendizaje {

    private int id;
    private int idAsignatura;
    private String resultado;
    private Date fechaCreacion;

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
