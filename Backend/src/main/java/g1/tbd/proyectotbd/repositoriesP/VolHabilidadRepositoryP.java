package g1.tbd.proyectotbd.repositoriesP;

import g1.tbd.proyectotbd.modelsP.VolHabilidadP;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolHabilidadRepositoryP {

    public int countVolHabilidad();
    public int insertVolHabilidad(VolHabilidadP volHabilidadP);
    public List<VolHabilidadP> getAllVolHabilidad();
    public void setVolHabilidad(VolHabilidadP volHabilidadP);
    public void deleteVolHabilidad(int idVolHabilidad);
}
