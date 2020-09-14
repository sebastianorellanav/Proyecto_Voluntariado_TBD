package g1.tbd.proyectotbd.mongoServices;

import g1.tbd.proyectotbd.mongoModels.InstitucionM;
import g1.tbd.proyectotbd.mongoRepositories.InstitucionMRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class InstitucionMService {
    private final InstitucionMRepository institucionMRepository;

    InstitucionMService(InstitucionMRepository institucionMRepository){this.institucionMRepository=institucionMRepository;}
    @GetMapping("/institucionm/count")
    public String countInstitucionM(){
        int total = institucionMRepository.countInstitucionM();
        return String.format("Tienes %s instituciones en la BD!!", total);
    }
    @GetMapping("/institucionm")
    public List<InstitucionM> getInstitucionM(){
        return institucionMRepository.getInstitucionM();
    }
    @PostMapping("/institucionm")
    @ResponseBody
    public InstitucionM createInstitucionM(@RequestBody InstitucionM im){
        InstitucionM result = institucionMRepository.createInstitucionM(im);
        return result;
    }
}
