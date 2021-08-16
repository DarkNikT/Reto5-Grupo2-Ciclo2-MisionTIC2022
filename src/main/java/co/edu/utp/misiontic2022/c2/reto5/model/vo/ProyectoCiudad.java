package co.edu.utp.misiontic2022.c2.reto5.model.vo;

public class ProyectoCiudad {
    // Variables de la consulta requerimiento 1
    private String constructora;
    private String fechaInicio;
    private String clasificacion;

    //constructores
    public ProyectoCiudad(){   
    }

    public ProyectoCiudad(String constructora, String fechaInicio, String clasificacion) {
        this.constructora = constructora;
        this.fechaInicio = fechaInicio;
        this.clasificacion = clasificacion;
    }

    // Getter y Setter
    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
