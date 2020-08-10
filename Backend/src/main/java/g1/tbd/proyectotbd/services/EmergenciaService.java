package g1.tbd.proyectotbd.services;

import g1.tbd.proyectotbd.models.Emergencia;
import g1.tbd.proyectotbd.repositories.EmergenciaRepository;
import g1.tbd.proyectotbd.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }


    @GetMapping("/emergencia")
    List<Emergencia> all(){
        System.out.println("aqui");
        List<Emergencia> emergencias = null;
        emergencias = emergenciaRepository.getAllEmergencias();

        return emergencias;
    }
}
