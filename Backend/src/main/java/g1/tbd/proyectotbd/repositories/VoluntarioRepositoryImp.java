package g1.tbd.proyectotbd.repositories;

import g1.tbd.proyectotbd.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.List;

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
    public List<Voluntario> getVoluntariosbyHabilidad(String habilidad) {
        habilidad = habilidad.toLowerCase();
        List<Voluntario> voluntarios = null;
        try(Connection conn = sql2o.open()){
            voluntarios = conn.createQuery("select a.id,a.nombre from voluntario a left join vol_habilidad b on a.id=b.id_voluntario left join habilidad c on b.id_habilidad = c.id where lower(c.descrip) ='" + habilidad+"'").executeAndFetch(Voluntario.class);

        }
        return voluntarios;
    }
}