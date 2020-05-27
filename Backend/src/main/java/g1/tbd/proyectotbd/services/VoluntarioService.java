package g1.tbd.proyectotbd.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import g1.tbd.proyectotbd.models.Voluntario;
import g1.tbd.proyectotbd.repositories.VoluntarioRepository;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


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


    @GetMapping("/voluntarios/{habilidad}")
    @ResponseBody
    public List<HashMap<String, Object>> getArtistStadistic(@PathVariable String habilidad){

        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> result = new ArrayList<>();
        Collection<Voluntario> data = voluntarioRepository.getVoluntariosbyHabilidad(habilidad);
        for(Voluntario v : data){

            map.put("id", v.getId());
            map.put("nombre", v.getNombre());
            map.put("fnacimiento", v.getFnacimiento());

            result.add(map);
            map = new HashMap<>();
        }
        return result;
    }



}
