package g1.tbd.proyectotbd.repositoriesP;

import g1.tbd.proyectotbd.modelsP.VoluntarioP;
import g1.tbd.proyectotbd.modelsP.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.List;

@Repository
public class VoluntarioRepositoryImpP implements VoluntarioRepositoryP{

    @Autowired
    private Sql2o sql2o[] = new Slq2o[3];

    
    @Override
    public void insertVoluntarioP(VoluntarioP voluntarioP) {
        int id = voluntarioP.getId();
        Hash h = new Hash();
        db = h.funcionHash(id);
        final String insertQuery =
                "INSERT INTO voluntario (id, nombre, fnacimiento) " +
                        "VALUES (:id, :nombre, :fnacimiento)";

        try (Connection con = sql2o[db].beginTransaction()) {
            con.createQuery(insertQuery)
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
    public List<VoluntarioP> getAllVoluntariosP(){
        List<VoluntarioP> voluntariosP = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2o[i].open()){
                voluntariosP.add(conn.createQuery("SELECT * FROM voluntario").executeAndFetch(VoluntarioP.class));
            }
        }
        return voluntariosP;
    }

    @Override
    public List<VoluntarioP> getVoluntariosPbyHabilidadP(String habilidadP) {
        habilidadP = habilidadP.toLowerCase();
        List<VoluntarioP> voluntariosP = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2o[i].open()){
                voluntariosP.add(conn.createQuery("select distinct a.id,a.nombre,a.fnacimiento from voluntario a left join vol_habilidad b on a.id=b.id_voluntario left join habilidad c on b.id_habilidad = c.id where lower(c.descrip) ='" + habilidad+"'").executeAndFetch(VoluntarioP.class));

            }
        }
        return voluntariosP;
    }
    @Override
    public void setVoluntarioP(VoluntarioP voluntarioP) {
        int id = voluntarioP.getId();
        Hash h = new Hash();
        db = h.funcionHash(id);
        String updateQuery ="UPDATE voluntario SET nombre=:nombre, fnacimiento=:fnacimiento WHERE id=:id";

        try (Connection con = sql2o[db].beginTransaction()) {
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
    public void deleteVoluntarioP(VoluntarioP voluntarioP) {
        int id = voluntarioP.getId();
        Hash h = new Hash();
        db = h.funcionHash(id);
        String deleteQuery ="DELETE FROM voluntario WHERE id=:id";

        try (Connection con = sql2o[db].beginTransaction()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", voluntarioP.getId())

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
            try(Connection conn = sql2o[i].open()){
                total = total + conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);
            }
        }    
        return total;
    }
}

