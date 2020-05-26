package g1.tbd.proyectotbd.models;

import java.sql.Date;

public class Voluntario {
    private Integer id;
    private Integer nombre;
    private Date fnacimiento;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNombre() {
        return this.nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Date getFnacimiento() {
        return this.fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    
}