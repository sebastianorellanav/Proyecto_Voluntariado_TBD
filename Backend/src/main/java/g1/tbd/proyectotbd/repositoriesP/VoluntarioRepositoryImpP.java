package g1.tbd.proyectotbd.repositoriesP;

import g1.tbd.proyectotbd.models.Voluntario;
import g1.tbd.proyectotbd.modelsP.VoluntarioP;
import g1.tbd.proyectotbd.modelsP.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class VoluntarioRepositoryImpP implements VoluntarioRepositoryP{


    @Autowired
    private List<Sql2o> sql2oList;  //Credenciales instancias de la db (usuario, contraseña y url de las 3 db)

    
    @Override
    public int insertVoluntarioP(VoluntarioP voluntarioP) {
        int id = voluntarioP.getId();
        Hash h = new Hash();
        int db = h.funcionHash(id);
        final String insertQuery =
                "INSERT INTO voluntario (id, nombre, fnacimiento) " +
                        "VALUES (:id, :nombre, :fnacimiento)";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("id", voluntarioP.getId())
                    .addParameter("nombre", voluntarioP.getNombre())
                    .addParameter("fnacimiento", voluntarioP.getFnacimiento())

                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
        return db;
    }

    @Override
    public List<VoluntarioP> getAllVoluntariosP(){
        List<VoluntarioP> voluntariosP = new ArrayList<VoluntarioP>();
        List<VoluntarioP> aux = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                aux = conn.createQuery("SELECT * FROM voluntario").executeAndFetch(VoluntarioP.class);
            }
            voluntariosP = Stream.concat(voluntariosP.stream(), aux.stream())
                    .collect(Collectors.toList());
            aux = null;
        }
        return voluntariosP;
    }

    @Override
    public List<VoluntarioP> getVoluntariosPbyHabilidadP(String habilidadP) {
        habilidadP = habilidadP.toLowerCase();
        List<VoluntarioP> voluntariosP = null;
        List<VoluntarioP> aux = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                aux = conn.createQuery("select distinct a.id,a.nombre,a.fnacimiento from voluntario a left join vol_habilidad b on a.id=b.id_voluntario left join habilidad c on b.id_habilidad = c.id where lower(c.descrip) ='" + habilidadP+"'").executeAndFetch(VoluntarioP.class);
            }
            voluntariosP.addAll(aux);
            aux = null;
        }
        return voluntariosP;
    }
    @Override
    public void setVoluntarioP(VoluntarioP voluntarioP) {
        int id = voluntarioP.getId();
        Hash h = new Hash();
        int db = h.funcionHash(id);
        String updateQuery ="UPDATE voluntario SET nombre=:nombre, fnacimiento=:fnacimiento WHERE id=:id";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(updateQuery)
                    .addParameter("id", voluntarioP.getId())
                    .addParameter("nombre", voluntarioP.getNombre())
                    .addParameter("fnacimiento", voluntarioP.getFnacimiento())

                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }

    @Override
    public void deleteVoluntarioP(int idVoluntario) {
        Hash h = new Hash();
        int db = h.funcionHash(idVoluntario);
        String deleteQuery ="DELETE FROM voluntario WHERE id=:id";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", idVoluntario)

                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }
    @Override
    public int countVoluntariosP() {
        int total = 0;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                total = total + conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);
            }
        }    
        return total;
    }

    @Override
    public VoluntarioP getSpecificVoluntaryP(int id){
        List<VoluntarioP> voluntariosP = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                voluntariosP = conn.createQuery("SELECT * FROM voluntario WHERE id = " + id)
                        .executeAndFetch(VoluntarioP.class);
            }
            if(!voluntariosP.isEmpty()){
                i = 3; //salgo del ciclo
                System.out.println(voluntariosP.get(0).getId());
            }
        }

        return voluntariosP.get(0);
    }
}

