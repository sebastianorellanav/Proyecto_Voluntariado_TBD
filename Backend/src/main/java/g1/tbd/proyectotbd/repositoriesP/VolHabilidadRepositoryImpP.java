package g1.tbd.proyectotbd.repositoriesP;

import g1.tbd.proyectotbd.modelsP.HabilidadP;
import g1.tbd.proyectotbd.modelsP.Hash;
import g1.tbd.proyectotbd.modelsP.VolHabilidadP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class VolHabilidadRepositoryImpP implements VolHabilidadRepositoryP{
    @Autowired
    private List<Sql2o> sql2oList;  //Credenciales instancias de la db (usuario, contraseña y url de las 3 db)


    @Override
    public int countVolHabilidad() {
        int total = 0;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                total = total + conn.createQuery("SELECT COUNT(*) FROM vol_habilidad").executeScalar(Integer.class);
            }
        }

        return total;
    }

    @Override
    public int insertVolHabilidad(VolHabilidadP volHabilidadP) {
        int id = volHabilidadP.getId();
        Hash h = new Hash();
        int db = h.funcionHash(id);
        final String insertQuery =
                "INSERT INTO vol_habilidad (id, id_voluntario, id_habilidad) " +
                        "VALUES (:id, :id_voluntario, :id_habilidad)";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("id", volHabilidadP.getId())
                    .addParameter("id_voluntario", volHabilidadP.getId_voluntario())
                    .addParameter("id_habilidad", volHabilidadP.getId_habilidad())
                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
        return db;
    }

    @Override
    public List<VolHabilidadP> getAllVolHabilidad(){
        List<VolHabilidadP> volHabilidadList = new ArrayList<VolHabilidadP>();
        List<VolHabilidadP> aux = null;
        for(int i=0; i<3; i++){
            try(Connection conn = sql2oList.get(i).open()){
                aux = conn.createQuery("SELECT * FROM vol_habilidad").executeAndFetch(VolHabilidadP.class);
            }
            volHabilidadList = Stream.concat(volHabilidadList.stream(), aux.stream())
                    .collect(Collectors.toList());
            aux = null;
        }
        return volHabilidadList;
    }

    @Override
    public void setVolHabilidad(VolHabilidadP volHabilidadP) {
        int id = volHabilidadP.getId();
        Hash h = new Hash();
        int db = h.funcionHash(id);
        final String updateQuery ="UPDATE vol_habilidad SET id_voluntario=:id_voluntario, id_habilidad= :id_habilidad WHERE id=:id references voluntario, (id) habilidad (id) on update cascade";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(updateQuery)
                    .addParameter("id", volHabilidadP.getId())
                    .addParameter("id_voluntario", volHabilidadP.getId_voluntario())
                    .addParameter("id_habilidad", volHabilidadP.getId_habilidad())


                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }

    }

    @Override
    public void deleteVolHabilidad(int idVolHabilidad) {
        Hash h = new Hash();
        int db = h.funcionHash(idVolHabilidad);
        String deleteQuery ="DELETE FROM vol_habilidad WHERE id=:id";

        try (Connection con = sql2oList.get(db).beginTransaction()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", idVolHabilidad)

                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }

}
