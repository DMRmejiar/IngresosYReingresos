package ingresos.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @Column(name = "id_materia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;

    @Column(name = "nombre_materia")
    private String nombreMateria;

    @Column(name = "creditos")
    private int creditos;

    @OneToMany(mappedBy = "materia")
    private List<MateriaPensum> materiasPensum;


    public Materia() {
    }

    public Materia(int idMateria, String nombreMateria, int creditos, List<MateriaPensum> materiasPensum) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
        this.materiasPensum = materiasPensum;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<MateriaPensum> getMateriasPensum() {
        return materiasPensum;
    }

    public void setMateriasPensum(List<MateriaPensum> materiasPensum) {
        this.materiasPensum = materiasPensum;
    }
}
