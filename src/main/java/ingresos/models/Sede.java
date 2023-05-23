package ingresos.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private int sede;

    @Column(name = "nombre_sede")
    private String nombreSede;

    @Column(name = "direccion_sede")
    private String direccionSede;

    @Column(name = "regional")
    private String regional;

    @OneToMany(mappedBy = "sede")
    private List<IngresoEstudiante> ingresoEstudiantes;

    public Sede() {
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public List<IngresoEstudiante> getIngresoEstudiantes() {
        return ingresoEstudiantes;
    }

    public void setIngresoEstudiantes(List<IngresoEstudiante> ingresoEstudiantes) {
        this.ingresoEstudiantes = ingresoEstudiantes;
    }
}
