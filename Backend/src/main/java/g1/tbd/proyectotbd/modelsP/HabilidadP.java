package g1.tbd.proyectotbd.modelsP;

public class Habilidad {
    private Integer id;     //se realizará el hash utilizando la columna id
    private String descrip;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
}