package g1.tbd.proyectotbd.servicesP;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import g1.tbd.proyectotbd.modelsP.HabilidadP;
import g1.tbd.proyectotbd.repositoriesP.HabilidadRepositoryP;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@CrossOrigin
@RestController
public class HabilidadServiceP {

    private final HabilidadRepositoryP habilidadRepositoryP;
    HabilidadServiceP(HabilidadRepositoryP habilidadRepositoryP){
        this.habilidadRepositoryP = habilidadRepositoryP;
    }

    @GetMapping("/") //path todas las habilidades
    public List<HabilidadP> all(){
        List<HabilidadP> habilidadP = null;
        habilidades = habilidadRepositoryP.getAllHabilidadesP();

        return voluntarios;
    }


    @GetMapping("/") //path habilidad por voluntarios
    @ResponseBody
    public List<HashMap<String, Object>> HU1(@PathVariable String voluntarioP){

        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> result = new ArrayList<>();
        Collection<HabilidadP> data = habilidadRepositoryP.getHabilidadPbyVoluntarioP(voluntarioP);
        for(HabilidadP hP : data){

            map.put("id", hP.getId());
            map.put("nombre", hP.getDescrip());

            result.add(map);
            map = new HashMap<>();
        }
        return result;
    }
    @RequestMapping(value= "/habilidad/create", method = RequestMethod.POST)
    @ResponseBody
    public String crearHabilidadP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("descrip");

        Integer id = habilidadRepositoryP.countHabilidadesP() + 1;

        HabilidadP hP = new HabilidadP(id, descrip);

        habilidadRepositoryP.InsertHabilidadP(hP);

        return "La habilidad se creó correctamente";
    }

    @RequestMapping(value= "/habilidad/delete", method = RequestMethod.POST)
    @ResponseBody
    public String borrarHabilidadP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("descrip");

        Integer id = request.getParameter("id");

        HabilidadP hP = new HabilidadP(id, descrip);

        habilidadRepositoryP.deleteHabilidadP(hP);

        return "La habilidad se elimino correctamente";
    }

    @RequestMapping(value= "/habilidad/update", method = RequestMethod.POST)
    @ResponseBody
    public String actualizarHabilidadP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("descrip");

        Integer id = request.getParameter("id");

        HabilidadP hP = new HabilidadP(id, descrip);

        habilidadRepositoryP.setHabilidadP(hP);

        return "La habilidad se actualizo correctamente";
    }



}
