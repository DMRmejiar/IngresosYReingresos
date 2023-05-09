package ingresos.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Info-academica")
public class InfoAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id-info-bachillerato")
    private InfoBachillerato bachillerato;

    @OneToMany
    @JoinColumn(name = "id-otros-estudios")
    private List<OtroEstudioFormal> otrosEstudios;

    @OneToMany
    @JoinColumn(name = "id-matricula-semestre")
    private List<MatriculaSemestre> informacionU;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InfoBachillerato getBachillerato(){
        return this.bachillerato;
    }

    public void setBachillerato(InfoBachillerato bachillerato){
        this.bachillerato = bachillerato;
    }

    public List<OtroEstudioFormal> getOtrosEstudios(){
        return this.otrosEstudios;
    }

    public void setOtrosEstudios(List<OtroEstudioFormal> otrosEstudios){
        this.otrosEstudios = otrosEstudios;
    }

    public void setInformacionU(List<MatriculaSemestre> informacionU){
        this.informacionU = informacionU;
    }

    public List<MatriculaSemestre> getInformacionU(){
        return this.informacionU;
    }

    public void addMatriculaSemestre(MatriculaSemestre matriculaSemestre){
        this.informacionU.add(matriculaSemestre);
    }

    public void removeMatriculaSemestre(MatriculaSemestre matriculaSemestre){
        this.informacionU.remove(matriculaSemestre);
    }

}

