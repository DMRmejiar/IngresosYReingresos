package ingresos.models;

import javax.persistence.*;

@Entity
@Table(name = "documento_reingreso_estudiante")
public class DocumentoReingresoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private int idDocumento;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    @Column(name = "descripcion_documento")
    private String descripcionDocumento;

    @ManyToOne
    @JoinColumn(name = "id_solicitud_reingreso")
    private SolicitudReingreso solicitudReingreso;

    public DocumentoReingresoEstudiante() {
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(String descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }

    public SolicitudReingreso getSolicitudReingreso() {
        return solicitudReingreso;
    }

    public void setSolicitudReingreso(SolicitudReingreso solicitudReingreso) {
        this.solicitudReingreso = solicitudReingreso;
    }
}
