package g1.tbd.proyectotbd.servicesP;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import g1.tbd.proyectotbd.modelsP.VoluntarioP;
import g1.tbd.proyectotbd.repositoriesP.VoluntarioRepositoryP;
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
public class VoluntarioServiceP {

    private final VoluntarioRepositoryP voluntarioRepositoryP;
    VoluntarioServiceP(VoluntarioRepositoryP voluntarioRepositoryP){
        this.voluntarioRepositoryP = voluntarioRepositoryP;
    }

    @GetMapping("/voluntario") //todos los voluntarios
    public List<VoluntarioP> all(){
        List<VoluntarioP> voluntarios = null;
        voluntarios = voluntarioRepositoryP.getAllVoluntariosP();

        return voluntarios;
    }

    @RequestMapping(value= "/voluntario/create", method = RequestMethod.POST)
    @ResponseBody
    public String crearVoluntarioP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("nombre");
        String fnacimientoString = request.getParameter("fnacimiento");

        Integer id = voluntarioRepositoryP.countVoluntariosP() + 1;

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsed = format.parse(fnacimientoString);
        java.sql.Date fNacimiento = new java.sql.Date(parsed.getTime());

        VoluntarioP vP = new VoluntarioP(id, nombre, fNacimiento);

        int db = voluntarioRepositoryP.insertVoluntarioP(vP);
        db = db+1;

        return "El voluntario se Almacenó en la Instancia "+ db + " de la BD";
    }

    @GetMapping("/voluntario/delete/{id}")
    @ResponseBody
    public String borrarVoluntarioP(@PathVariable int id) {
        voluntarioRepositoryP.deleteVoluntarioP(id);

        return "El voluntario se elimino correctamente";
    }

    @RequestMapping(value= "/voluntario/update", method = RequestMethod.POST)
    @ResponseBody
    public String actualizarVoluntarioP(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("nombre");
        String fnacimiento = request.getParameter("fnacimiento");

        Integer id = Integer.parseInt(request.getParameter("id"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fnacimiento);
        java.sql.Date fNacimiento = new java.sql.Date(parsed.getTime());

        VoluntarioP vP = new VoluntarioP(id, nombre, fNacimiento);

        voluntarioRepositoryP.setVoluntarioP(vP);

        return "El voluntario se actualizó correctamente";
    }

    @GetMapping("/voluntario/{id}")
    @ResponseBody
    public VoluntarioP obtenerVoluntarioEspecificoP(@PathVariable int id) {
        VoluntarioP v = voluntarioRepositoryP.getSpecificVoluntaryP(id);

        return v;
    }


}
