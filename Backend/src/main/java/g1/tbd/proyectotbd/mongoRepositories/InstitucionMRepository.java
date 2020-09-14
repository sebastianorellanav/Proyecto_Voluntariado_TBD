package g1.tbd.proyectotbd.mongoRepositories;

import g1.tbd.proyectotbd.mongoModels.InstitucionM;

import java.util.List;

public interface InstitucionMRepository {
    public int countInstitucionM();
    public List<InstitucionM> getInstitucionM();
    public InstitucionM createInstitucionM(InstitucionM iM);
}
