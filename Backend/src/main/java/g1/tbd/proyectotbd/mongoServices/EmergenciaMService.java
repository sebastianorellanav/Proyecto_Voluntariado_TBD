package g1.tbd.proyectotbd.mongoServices;

import g1.tbd.proyectotbd.mongoModels.EmergenciaM;
import g1.tbd.proyectotbd.mongoRepositories.EmergenciaMRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergenciaMService {

    private final EmergenciaMRepository emergenciaMRepository;
    EmergenciaMService(EmergenciaMRepository emergenciaMRepository){this.emergenciaMRepository=emergenciaMRepository;}
    @GetMapping("/emergenciam/count")
    public String countEmergenciaM(){
        int total = emergenciaMRepository.countEmergenciaM();
        return String.format("Tienes %s emergencias en la BD!!", total);
    }
    @GetMapping("/emergenciam")
    public List<EmergenciaM> getEmergenciaM(){
        return emergenciaMRepository.getEmergenciaM();
    }
    @PostMapping("/emergenciam")
    @ResponseBody
    public EmergenciaM createEmergenciaM(@RequestBody EmergenciaM em){
        EmergenciaM result = emergenciaMRepository.createEmergenciaM(em);
        return result;
    }
}
