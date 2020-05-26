package g1.tbd.proyectotbd.services;


import g1.tbd.proyectotbd.repositories.VoluntarioRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;
    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/voluntarios/count")
    public String countVoluntarios(){
        int total = voluntarioRepository.countVoluntarios();
        return String.format("Tienes %s voluntarios!!", total);
    }

}
