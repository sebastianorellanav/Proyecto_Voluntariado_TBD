package g1.tbd.proyectotbd.repositoriesP;


import g1.tbd.proyectotbd.modelsP.VoluntarioP;

import java.util.Collection;
import java.util.List;

public interface VoluntarioRepositoryP {
    public int countVoluntariosP();
    public void insertVoluntarioP(VoluntarioP voluntarioP);
    public List<VoluntarioP> getAllVoluntariosP();
    public void setVoluntarioP(VoluntarioP voluntarioP);
    public void deleteVoluntarioP(VoluntarioP volubtarioP);
    public List<VoluntarioP> getVoluntariosPbyHabilidadP(String habilidadP);
}
