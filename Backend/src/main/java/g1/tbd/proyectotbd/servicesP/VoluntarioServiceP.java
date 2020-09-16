package g1.tbd.proyectotbd.servicesP;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import g1.tbd.proyectotbd.modelsP.VoluntarioP;
import g1.tbd.proyectotbd.repositoriesP.VoluntarioRepositoryP;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@CrossOrigin
@RestController
public class VoluntarioServiceP {

    private final VoluntarioRepositoryP voluntarioRepositoryP;
    VoluntarioServiceP(VoluntarioRepositoryP voluntarioRepositoryP){
        this.voluntarioRepositoryP = voluntarioRepositoryP;
    }

    @GetMapping("/") //todos los voluntarios
    public List<VoluntarioP> all(){
        List<VoluntarioP> voluntarios = null;
        voluntarios = voluntarioRepositoryP.getAllVoluntariosP();

        return voluntarios;
    }


    @GetMapping("/") //path voluntarios por habilidad
    @ResponseBody
    public List<HashMap<String, Object>> HU1(@PathVariable String habilidadP){

        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> result = new ArrayList<>();
        Collection<VoluntarioP> data = voluntarioRepositoryP.getVoluntariosPbyHabilidadP(habilidadP);
        for(VoluntarioP vP : data){

            map.put("id", vP.getId());
            map.put("nombre", vP.getNombre());
            map.put("fnacimiento", vP.getFnacimiento());

            result.add(map);
            map = new HashMap<>();
        }
        return result;
    }
    @RequestMapping(value= "/voluntario/create", method = RequestMethod.POST)
    @ResponseBody
    public String crearVoluntarioP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("nombre");
        String descrip = request.getParameter("fnacimiento");

        Integer id = voluntarioRepositoryP.countVoluntariosP() + 1;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fnacimiento);
        java.sql.Date finicio = new java.sql.Date(parsed.getTime());

        VoluntarioP vP = new VoluntarioP(id, nombre, fnacimiento);

        voluntarioRepositoryP.insertVoluntarioP(vP);

        return "El voluntario se creó correctamente";
    }

    @RequestMapping(value= "/voluntario/delete", method = RequestMethod.POST)
    @ResponseBody
    public String borrarVoluntarioP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("nombre");
        String descrip = request.getParameter("fnacimiento");

        Integer id = request.getParameter("id");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fnacimiento);
        java.sql.Date finicio = new java.sql.Date(parsed.getTime());

        VoluntarioP vP = new VoluntarioP(id, nombre, fnacimiento);

        voluntarioRepositoryP.deleteVoluntarioP(vP);

        return "El voluntario se elimino correctamente";
    }

    @RequestMapping(value= "/voluntario/update", method = RequestMethod.POST)
    @ResponseBody
    public String actualizarVoluntarioP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("nombre");
        String descrip = request.getParameter("fnacimiento");

        Integer id = request.getParameter("id");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fnacimiento);
        java.sql.Date finicio = new java.sql.Date(parsed.getTime());

        VoluntarioP vP = new VoluntarioP(id, nombre, fnacimiento);

        voluntarioRepositoryP.setVoluntarioP(vP);

        return "El voluntario se actualizó correctamente";
    }


}
