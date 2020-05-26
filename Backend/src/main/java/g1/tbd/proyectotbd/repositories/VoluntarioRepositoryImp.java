package g1.tbd.proyectotbd.repositories;

import g1.tbd.proyectotbd.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collection;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVoluntarios() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public Collection<Voluntario> getVoluntarios() {
        Collection<Voluntario> voluntarios = null;
        try(Connection conn = sql2o.open()){
            voluntarios = conn.createQuery("SELECT * FROM voluntario")
                    .executeAndFetch(Voluntario.class);

        }
        System.out.println("Hola");
        System.out.println(voluntarios);
        return voluntarios;
    }
}