package ingresos.domain;

import javax.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diligenciado")
    private Boolean diligenciado;

    @OneToOne
    @JoinColumn(name = "id-info-personal")
    private InfoPersonal infoPersonal;

    @OneToOne
    @JoinColumn(name = "id-info-economica")
    private InfoEconomica infoEconomica;

    @OneToOne
    @JoinColumn(name = "id-info-academica")
    private InfoAcademica infoAcademica;


    public Estudiante() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDiligenciado() {
        return this.diligenciado;
    }

    public void setDiligenciado(Boolean diligenciado) {
        this.diligenciado = diligenciado;
    }

    public InfoPersonal getInfoPersonal() {
        return this.infoPersonal;
    }

    public void setInfoPersonal(InfoPersonal infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public InfoEconomica getInfoEconomica() {
        return this.infoEconomica;
    }

    public void setInfoEconomica(InfoEconomica infoEconomica) {
        this.infoEconomica = infoEconomica;
    }

    public InfoAcademica getInfoAcademica() {
        return this.infoAcademica;
    }

    public void setInfoAcademica(InfoAcademica infoAcademica) {
        this.infoAcademica = infoAcademica;
    }

}
