package g1.tbd.proyectotbd.repositoriesP;


import g1.tbd.proyectotbd.models.Voluntario;
import g1.tbd.proyectotbd.modelsP.VoluntarioP;

import java.util.Collection;
import java.util.List;

public interface VoluntarioRepositoryP {
    public int countVoluntariosP();
    public int insertVoluntarioP(VoluntarioP voluntarioP);
    public List<VoluntarioP> getAllVoluntariosP();
    public void setVoluntarioP(VoluntarioP voluntarioP);
    public void deleteVoluntarioP(int idVoluntario);
    public List<VoluntarioP> getVoluntariosPbyHabilidadP(String habilidadP);
    public VoluntarioP getSpecificVoluntaryP(int id);
}
