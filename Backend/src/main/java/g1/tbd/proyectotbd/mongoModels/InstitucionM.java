package g1.tbd.proyectotbd.mongoModels;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InstitucionM {

    @BsonId
    private ObjectId _id;
    private String nombre;
    private String descrip;
    private List<String> emergencias;

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

    public List<String> getEmergenciasM(){
        return this.emergencias;
    }
    public  void setEmergencias(List<String> sE){
        this.emergencias=sE;
    }
}

