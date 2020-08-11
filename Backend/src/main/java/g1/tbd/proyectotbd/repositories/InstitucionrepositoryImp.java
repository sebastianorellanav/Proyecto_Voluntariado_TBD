package g1.tbd.proyectotbd.repositories;

import g1.tbd.proyectotbd.models.Emergencia;
import g1.tbd.proyectotbd.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionrepositoryImp implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institucion> getAllInstituciones(){
        List<Institucion> instituciones = null;
        try(Connection conn = sql2o.open()){
            instituciones = conn.createQuery("SELECT * FROM institucion").executeAndFetch(Institucion.class);
        }
        return instituciones;
    }
}
