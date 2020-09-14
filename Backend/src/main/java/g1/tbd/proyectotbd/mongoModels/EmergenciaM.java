package g1.tbd.proyectotbd.mongoModels;

import net.minidev.json.annotate.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.sql.Date;

public class EmergenciaM {
    @BsonId
    ObjectId _id;
    private String nombre;
    private String descrip;
    private String finicio;
    private String ffin;

/*    public EmergenciaM(ObjectId _id, String nombre, String descrip, String finicio, String ffin, ObjectId id_institucion) {
        this._id = _id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.finicio = finicio;
        this.ffin = ffin;
        this.id_institucion = id_institucion;
    }
*/

/*    public String getStringId(){
        return this._id.toString();
    }*/
    public ObjectId getId() {
        return this._id;
    }
    public void setId(ObjectId id) {
        this._id = id;
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getFinicio() {
        return this.finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    public String getFfin() {
        return this.ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }


   /* public String getStringId_institucion() {
        return this.id_institucion.toString();
    }*/
}

