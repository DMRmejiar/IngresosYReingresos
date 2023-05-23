package ingresos.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ingreso_estudiante")
public class IngresoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso_estudiante")
    private int idIngresoEstudiante;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "semestreInscripcion")
    private String semestreInscripcion;

    @Column(name = "tipoIngreso")
    private String tipoIngreso;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "id_sede")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_pensum")
    private Pensum pensum;

    @OneToMany(mappedBy = "ingresoEstudiante")
    private List<DocumentoIngresoEstudiante> documentoIngresoEstudiantes;

    public IngresoEstudiante() {
    }

    public int getIdIngresoEstudiante() {
        return idIngresoEstudiante;
    }

    public void setIdIngresoEstudiante(int idIngresoEstudiante) {
        this.idIngresoEstudiante = idIngresoEstudiante;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Pensum getPensum() {
        return pensum;
    }

    public void setPensum(Pensum pensum) {
        this.pensum = pensum;
    }

    public String getSemestreInscripcion() {
        return semestreInscripcion;
    }

    public void setSemestreInscripcion(String semestreInscripcion) {
        this.semestreInscripcion = semestreInscripcion;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public List<DocumentoIngresoEstudiante> getDocumentoIngresoEstudiantes() {
        return documentoIngresoEstudiantes;
    }

    public void setDocumentoIngresoEstudiantes(List<DocumentoIngresoEstudiante> documentoIngresoEstudiantes) {
        this.documentoIngresoEstudiantes = documentoIngresoEstudiantes;
    }
}
