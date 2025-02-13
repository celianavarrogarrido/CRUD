package Clases;

public class CriterioEvaluacion {
    private int id;
    private String criterio;
    private int idAsignatura;

    // Constructor vacío
    public CriterioEvaluacion() {}

    // Constructor con parámetros
    public CriterioEvaluacion(int id, String criterio, int idAsignatura) {
        this.id = id;
        this.criterio = criterio;
        this.idAsignatura = idAsignatura;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public String toString() {
        return "CriterioEvaluacion{" +
               "id=" + id +
               ", criterio='" + criterio + '\'' +
               ", idAsignatura=" + idAsignatura +
               '}';
    }
}
