package g1.tbd.proyectotbd.mongoRepositories;

import g1.tbd.proyectotbd.mongoModels.EmergenciaM;

import java.util.List;

public interface EmergenciaMRepository {
    public int countEmergenciaM();
    public List<EmergenciaM> getEmergenciaM();
    public EmergenciaM createEmergenciaM(EmergenciaM em);
}
