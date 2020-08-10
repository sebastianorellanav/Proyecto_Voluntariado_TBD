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

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia> getAllEmergencias(){
        List<Emergencia> emergencias = null;
        try(Connection conn = sql2o.open()){
            emergencias = conn.createQuery("SELECT * FROM emergencia").executeAndFetch(Emergencia.class);
        }
        return emergencias;
    }
}
