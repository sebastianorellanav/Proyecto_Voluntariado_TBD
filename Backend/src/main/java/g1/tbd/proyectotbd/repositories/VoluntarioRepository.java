package g1.tbd.proyectotbd.repositories;


import g1.tbd.proyectotbd.models.Voluntario;

import java.util.Collection;

public interface VoluntarioRepository {
    public int countVoluntarios();
    public Collection<Voluntario> getVoluntarios();

}