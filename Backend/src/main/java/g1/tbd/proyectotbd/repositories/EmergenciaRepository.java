package g1.tbd.proyectotbd.repositories;

import g1.tbd.proyectotbd.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public List<Emergencia> getAllEmergencias();
    public int countEmergencias();
    public void insertEmergencia(Emergencia emergencia);
}
