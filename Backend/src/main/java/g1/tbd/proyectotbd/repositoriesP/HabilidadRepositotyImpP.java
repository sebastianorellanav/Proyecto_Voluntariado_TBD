package g1.tbd.proyectotbd.repositoriesP;

import g1.tbd.proyectotbd.modelsP.HabilidadP;
import g1.tbd.proyectotbd.modelsP.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.List;

@Repository
public class HabilidadRepositoryImpP implements HabilidadRepositoryP{

    @Autowired
    private Sql2o sql2o[] = new Slq2o[3];

    
    @Override
    public void insertHabilidadP(HabilidadP habilidadP) {
        int id = habilidadP.getId();
        Hash h = new Hash();
        db = h.funcionHash(id);
        final String insertQuery =
                "INSERT INTO habilidad (id, descrip) " +
                        "VALUES (:id, :descrip)";

        try (Connection con = sql2o[db].beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("id", habilidadP.getId())
                    .addParameter("nombre", habilidadP.getDescrip())

                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }

    @Override
    public List<HabilidadP> getAllHabilidadesP(){
        List<HabilidadP> habilidadesP = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2o.open()){
                habilidadesP.add(conn.createQuery("SELECT * FROM habilidad").executeAndFetch(HabilidadP.class));
            }
        }
        return habilidadesP;
    }
    @Override
    public void setHabilidadP(HabilidadP habilidadP) {
        int id = habilidadP.getId();
        Hash h = new Hash();
        db = h.funcionHash(id);
        final String updateQuery ="UPDATE habilidad SET descrip=:descrip WHERE id=:id";

        try (Connection con = sql2o[db].beginTransaction()) {
            con.createQuery(updateQuery)
                    .addParameter("id", habilidadP.getId())
                    .addParameter("descrip", habilidadP.getDescrip())


                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }
    @Override
    public List<HabilidadP> getHabilidadPbyVoluntarioP(String voluntarioP) {
        voluntarioP = voluntarioP.toLowerCase();
        List<HabilidadP> habilidadesP = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2o.open()){
                habilidadesP.add(conn.createQuery().executeAndFetch(HabilidadP.class)); //insertar query

            }
        }
        return habilidadesP;
    }
    @Override
    public void deleteHabilidadP(HabilidadP habilidadP) {
        int id = habilidadP.getId();
        Hash h = new Hash();
        db = h.funcionHash(id);
        String deleteQuery ="DELETE FROM habilidad WHERE id=:id";

        try (Connection con = sql2o[db].beginTransaction()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", habilidadP.getId())

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
            try(Connection conn = sql2o.open()){
                total = total + conn.createQuery("SELECT COUNT(*) FROM habilidad").executeScalar(Integer.class);
            }
        }

        return total;
    }
}

