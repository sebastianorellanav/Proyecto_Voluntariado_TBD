package g1.tbd.proyectotbd.repositoriesP;


import g1.tbd.proyectotbd.modelsP.HabilidadP;

import java.util.Collection;
import java.util.List;

public interface HabilidadRepositoryP {
    public int countHabilidadesP();
    public int InsertHabilidadP(HabilidadP habilidadP);
    public List<HabilidadP> getAllHabilidadesP();
    public void setHabilidadP(HabilidadP habilidadP);
    public void deleteHabilidadP(int idVoluntario);
}