package ingresos.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "solicitud_reingreso")
public class SolicitudReingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_reingreso")
    private int idSolicitudReingreso;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;

    @Column(name = "motivo")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carreraSolicitada")
    private Carrera carreraSolicitada;

    @OneToMany(mappedBy = "solicitudReingreso")
    private List<DocumentoReingresoEstudiante> documentoReingresoEstudiantes;

    public SolicitudReingreso() {
    }

    public int getIdSolicitudReingreso() {
        return idSolicitudReingreso;
    }

    public void setIdSolicitudReingreso(int idSolicitudReingreso) {
        this.idSolicitudReingreso = idSolicitudReingreso;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarreraSolicitada() {
        return carreraSolicitada;
    }

    public void setCarreraSolicitada(Carrera carreraSolicitada) {
        this.carreraSolicitada = carreraSolicitada;
    }

    public List<DocumentoReingresoEstudiante> getDocumentoReingresoEstudiantes() {
        return documentoReingresoEstudiantes;
    }

    public void setDocumentoReingresoEstudiantes(List<DocumentoReingresoEstudiante> documentoReingresoEstudiantes) {
        this.documentoReingresoEstudiantes = documentoReingresoEstudiantes;
    }
}
