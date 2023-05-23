package ingresos.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pensum")
public class Pensum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pensum")
    private int idPensum;

    @Column(name = "numero_pensum")
    private int numeroPensum;

    @OneToMany(mappedBy = "pensum")
    private List<MateriaPensum> materiasPensum;

    @OneToMany(mappedBy = "pensum")
    private List<IngresoEstudiante> ingresoEstudiantes;

    public Pensum() {
    }

    public Pensum(int idPensum, int numeroPensum) {
        this.idPensum = idPensum;
        this.numeroPensum = numeroPensum;
    }

    public int getIdPensum() {
        return idPensum;
    }

    public void setIdPensum(int idPensum) {
        this.idPensum = idPensum;
    }

    public int getNumeroPensum() {
        return numeroPensum;
    }

    public void setNumeroPensum(int numeroPensum) {
        this.numeroPensum = numeroPensum;
    }

    public List<MateriaPensum> getMateriasPensum() {
        return materiasPensum;
    }

    public void setMateriasPensum(List<MateriaPensum> materiasPensum) {
        this.materiasPensum = materiasPensum;
    }
}
