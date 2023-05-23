package ingresos.models;

import javax.persistence.*;

@Entity
@Table(name = "materias_pensum")
public class MateriaPensum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mat_carrera")
    private int idMatCarrera;

    @ManyToOne
    @JoinColumn(name = "id_pensum")
    private Pensum pensum;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    public MateriaPensum() {
    }

    public int getIdMatCarrera() {
        return idMatCarrera;
    }

    public void setIdMatCarrera(int idMatCarrera) {
        this.idMatCarrera = idMatCarrera;
    }

    public Pensum getPensum() {
        return pensum;
    }

    public void setPensum(Pensum pensum) {
        this.pensum = pensum;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
