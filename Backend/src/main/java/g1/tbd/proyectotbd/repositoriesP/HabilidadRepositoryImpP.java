package g1.tbd.proyectotbd.repositoriesP;

import g1.tbd.proyectotbd.models.Habilidad;
import g1.tbd.proyectotbd.modelsP.HabilidadP;
import g1.tbd.proyectotbd.modelsP.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class HabilidadRepositoryImpP implements HabilidadRepositoryP{

    @Autowired
    private List<Sql2o> sql2oList;  //Credenciales instancias de la db (usuario, contraseña y url de las 3 db)


    @Override
    public List<HabilidadP> getAllHabilidadesP(){
        List<HabilidadP> habilidadesP = new ArrayList<HabilidadP>();
        List<HabilidadP> aux = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                aux = conn.createQuery("SELECT * FROM habilidad").executeAndFetch(HabilidadP.class);
            }
            habilidadesP = Stream.concat(habilidadesP.stream(), aux.stream())
                    .collect(Collectors.toList());
            aux = null;
        }
        return habilidadesP;
    }
    @Override
    public void setHabilidadP(HabilidadP habilidadP) {
        int id = habilidadP.getId();
        Hash h = new Hash();
        int db = h.funcionHash(id);
        final String updateQuery ="UPDATE habilidad SET descrip=:descrip WHERE id=:id";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(updateQuery)
                    .addParameter("id", habilidadP.getId())
                    .addParameter("descrip", habilidadP.getDescrip())


                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }
    /*
    @Override
    public List<HabilidadP> getHabilidadPbyVoluntarioP(String voluntarioP) {
        voluntarioP = voluntarioP.toLowerCase();
        List<HabilidadP> habilidadesP = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2o[i].open()){
                habilidadesP.addAll(conn.createQuery().executeAndFetch(HabilidadP.class)); //insertar query

            }
        }
        return habilidadesP;
    }

     */
    @Override
    public void deleteHabilidadP(int idVoluntario) {
        Hash h = new Hash();
        int db = h.funcionHash(idVoluntario);
        String deleteQuery ="DELETE FROM habilidad WHERE id=:id";

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
    public int countHabilidadesP() {
        int total = 0;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                total = total + conn.createQuery("SELECT COUNT(*) FROM habilidad").executeScalar(Integer.class);
            }
        }

        return total;
    }

    @Override
    public int InsertHabilidadP(HabilidadP habilidadP) {
        int id = habilidadP.getId();
        Hash h = new Hash();
        int db = h.funcionHash(id);
        final String insertQuery =
                "INSERT INTO habilidad (id, descrip) " +
                        "VALUES (:id, :descrip)";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("id", habilidadP.getId())
                    .addParameter("descrip", habilidadP.getDescrip())

                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
        return db;
    }
}

