package g1.tbd.proyectotbd.servicesP;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import g1.tbd.proyectotbd.modelsP.HabilidadP;
import g1.tbd.proyectotbd.repositoriesP.HabilidadRepositoryImpP;
import g1.tbd.proyectotbd.repositoriesP.HabilidadRepositoryP;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping("/habilidad") //path todas las habilidades
    public List<HabilidadP> all(){
        List<HabilidadP> habilidades = null;
        habilidades = habilidadRepositoryP.getAllHabilidadesP();

        return habilidades;
    }

    /*
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
     */
    @RequestMapping(value= "/habilidad/create", method = RequestMethod.POST)
    @ResponseBody
    public String crearHabilidadP(HttpServletRequest request) throws ParseException {
        String descrip = request.getParameter("descrip");

        Integer id = habilidadRepositoryP.countHabilidadesP() + 1;

        HabilidadP hP = new HabilidadP(id, descrip);

        int db = habilidadRepositoryP.InsertHabilidadP(hP);

        db = db+1;

        return "La habilidad se Almacenó en la Instancia "+ db + " de la BD";
    }

    @GetMapping("/habilidad/delete/{id}")
    @ResponseBody
    public String borrarHabilidadP(@PathVariable int id) {
        habilidadRepositoryP.deleteHabilidadP(id);

        return "El voluntario se elimino correctamente";
    }

    @RequestMapping(value= "/habilidad/update", method = RequestMethod.POST)
    @ResponseBody
    public String actualizarHabilidadP(HttpServletRequest request) throws ParseException {
        String descrip = request.getParameter("descrip");

        Integer id = Integer.parseInt(request.getParameter("id"));

        HabilidadP hP = new HabilidadP(id, descrip);

        habilidadRepositoryP.setHabilidadP(hP);

        return "La habilidad se actualizo correctamente";
    }



}
