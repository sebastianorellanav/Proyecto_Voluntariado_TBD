package g1.tbd.proyectotbd.repositories;


import g1.tbd.proyectotbd.models.Voluntario;

import java.util.Collection;
import java.util.List;

public interface VoluntarioRepository {
    public int countVoluntarios();
    public List<Voluntario> getVoluntariosbyHabilidad(String habilidad);
    public List<Voluntario> getVoluntariobyEmergencia(String Emergencia);
}