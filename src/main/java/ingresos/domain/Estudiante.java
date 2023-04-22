package ingresos.domain;

public class Estudiante extends Usuario  {

    private int id;

    private Boolean diligenciado;

    private InfoPersonal infoPersonal;

    private InfoEconomica infoEconomica;

    private InfoAcademica infoAcademica;


    public Estudiante() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public void setInfoPerosnal(InfoPersonal infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public InfoEconomica getinfoEconomica() {
        return this.infoEconomica;
    }

    public void setinfoEconomica(InfoEconomica infoEconomica) {
        this.infoEconomica = infoEconomica;
    }

    public InfoAcademica getinfoAcademica() {
        return this.infoAcademica;
    }

    public void setinfoAcademica(InfoAcademica infoAcademica) {
        this.infoAcademica = infoAcademica;
    }

    public void realizarRegistro(Estudiante estudiante) {
        estudiante.diligenciado = true;
        //estudiante.save();   Se guarda el estudiante en la base de datos
        
    }

    public Estudiante  consultarInfoEstudiante(int ID){
        //se busca el estudiante con el ID en la base de datos
        Estudiante estudiante= new Estudiante();
        return estudiante;
    }

}
