package ingresos.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private int idCarrera;

    @Column(name = "nombre_carrera")
    private String nombreCarrera;

    @Column(name = "modalidad")
    private String modalidad;

    @Column(name = "facultad")
    private String facultad;

    @OneToMany(mappedBy = "carrera")
    private List<IngresoEstudiante> ingresoEstudiante;

    @OneToMany(mappedBy = "carreraSolicitada")
    private List<SolicitudReingreso> solicitudReingreso;


    public Carrera() {
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public List<IngresoEstudiante> getIngresoEstudiante() {
        return ingresoEstudiante;
    }

    public void setIngresoEstudiante(List<IngresoEstudiante> ingresoEstudiante) {
        this.ingresoEstudiante = ingresoEstudiante;
    }

    public List<SolicitudReingreso> getSolicitudReingreso() {
        return solicitudReingreso;
    }

    public void setSolicitudReingreso(List<SolicitudReingreso> solicitudReingreso) {
        this.solicitudReingreso = solicitudReingreso;
    }
}
