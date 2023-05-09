package ingresos.domain;

import javax.persistence.*;

@Entity
@Table(name = "info-economica")
public class InfoEconomica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;

    private String barrio;

    private String ciudad;

    private String departamento;

    private Integer estrato;

    private Boolean dependeEcono;

    private Boolean trabaja;

    private Boolean tieneDependientes;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartmento() {
        return this.departamento;
    }

    public void setDepartmento(String departmento) {
        this.departamento = departmento;
    }

    public Integer getEstrato() {
        return this.estrato;
    }

    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }

    public Boolean getDependeEcono() {
        return this.dependeEcono;
    }

    public void setDependeEcono(Boolean dependeEcono) {
        this.dependeEcono = dependeEcono;
    }

    public Boolean getTrabaja() {
        return this.trabaja;
    }

    public void setTrabaja(Boolean trabaja) {
        this.trabaja = trabaja;
    }

    public Boolean getTieneDependientes() {
        return this.tieneDependientes;
    }

    public void setTieneDependientes(Boolean tieneDependientes) {
        this.tieneDependientes = tieneDependientes;
    }
}
