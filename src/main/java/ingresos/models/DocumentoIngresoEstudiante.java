package ingresos.models;

import javax.persistence.*;

@Entity
@Table(name = "documento_ingreso_estudiante")
public class DocumentoIngresoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private int idDocumento;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    @Column(name = "descripcion_documento")
    private String descripcionDocumento;

    @ManyToOne
    @JoinColumn(name = "id_ingreso_estudiante")
    private IngresoEstudiante ingresoEstudiante;

    public DocumentoIngresoEstudiante() {
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

    public IngresoEstudiante getIngresoEstudiante() {
        return ingresoEstudiante;
    }

    public void setIngresoEstudiante(IngresoEstudiante ingresoEstudiante) {
        this.ingresoEstudiante = ingresoEstudiante;
    }
}
