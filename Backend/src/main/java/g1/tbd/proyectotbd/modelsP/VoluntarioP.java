package g1.tbd.proyectotbd.modelsP;

import java.sql.Date;

public class VoluntarioP {
    private Integer id;         //se realizará el hash utilizando la columna id
    private String nombre;
    private Date fnacimiento;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFnacimiento() {
        return this.fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    
}