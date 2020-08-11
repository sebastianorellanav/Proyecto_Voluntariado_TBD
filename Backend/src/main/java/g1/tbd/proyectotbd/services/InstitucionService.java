package g1.tbd.proyectotbd.services;

import g1.tbd.proyectotbd.models.Institucion;
import g1.tbd.proyectotbd.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class InstitucionService {

    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){this.institucionRepository = institucionRepository;}

    @GetMapping("/institucion/form")
    public List<HashMap<String, Object>> getInstitucionesForForm(){
        List<Institucion> instituciones = null;
        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> result = new ArrayList<>();
        instituciones = institucionRepository.getAllInstituciones();
        for (Institucion inst : instituciones){

            map.put("text", inst.getNombre());
            map.put("value", inst.getId());

            result.add(map);
            map = new HashMap<>();
        }
        return result;
    }
}
