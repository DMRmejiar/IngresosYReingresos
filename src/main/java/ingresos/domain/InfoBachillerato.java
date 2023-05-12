package ingresos.domain;

import javax.persistence.*;

@Entity
@Table(name = "info-bachillerato")
public class InfoBachillerato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ciudad;

    private String departamento;

    private String pais;

    private String colegio;

    private Integer year;

    private String modalidad;

    private Integer puntajeIcfes;

    public InfoBachillerato(Long id, String ciudad, String departamento, String pais, String colegio, Integer year, String modalidad, Integer puntajeIcfes) {
        this.id = id;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
        this.colegio = colegio;
        this.year = year;
        this.modalidad = modalidad;
        this.puntajeIcfes = puntajeIcfes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getColegio() {
        return this.colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getPuntajeIcfes() {
        return this.puntajeIcfes;
    }

    public void setPuntajeIcfes(Integer puntajeIcfes) {
        this.puntajeIcfes = puntajeIcfes;
    }
}

