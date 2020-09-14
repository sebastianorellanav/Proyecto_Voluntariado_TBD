package g1.tbd.proyectotbd.mongoModels;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class InstitucionM {

    public class Institucion {
        @BsonId
        private ObjectId _id;
        private String nombre;
        private String descrip;
        private List<String> emergencias;
    /*    public Institucion(ObjectId id,String nombre,String descrip){
            this._id=id;
            this.nombre=nombre;
            this.descrip=descrip;
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
        public List<String> getEmergenciasM(){
            return this.emergencias;
        }
        public  void setEmergencias(List<String> sE){
            this.emergencias=sE;
        }
    }
}
