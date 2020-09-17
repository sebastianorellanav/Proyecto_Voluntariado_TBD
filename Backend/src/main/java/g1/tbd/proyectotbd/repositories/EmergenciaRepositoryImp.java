package g1.tbd.proyectotbd.repositories;

import g1.tbd.proyectotbd.models.Emergencia;
import g1.tbd.proyectotbd.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    private Sql2o sql2o;

    @Override
    public int countEmergencias() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);
        }

        return total;
    }

    @Override
    public List<Emergencia> getAllEmergencias(){
        List<Emergencia> emergencias = null;
        try(Connection conn = sql2o.open()){
            emergencias = conn.createQuery("SELECT * FROM emergencia").executeAndFetch(Emergencia.class);
        }
        return emergencias;
    }

    @Override
    public void insertEmergencia(Emergencia emergencia) {
        final String insertQuery =
                "INSERT INTO emergencia (id, nombre, descrip, finicio, ffin, id_institucion) " +
                        "VALUES (:id, :nombre, :descrip, :finicio, :ffin, :idInst)";

        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("id", emergencia.getId())
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("idInst", emergencia.getId_institucion())
                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }
    }


}
