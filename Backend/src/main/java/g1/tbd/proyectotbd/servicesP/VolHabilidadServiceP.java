package g1.tbd.proyectotbd.servicesP;

import g1.tbd.proyectotbd.modelsP.VolHabilidadP;
import g1.tbd.proyectotbd.repositoriesP.VolHabilidadRepositoryImpP;
import g1.tbd.proyectotbd.repositoriesP.VolHabilidadRepositoryP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
public class VolHabilidadServiceP {


    private final VolHabilidadRepositoryP volHabilidadRepositoryP;
    VolHabilidadServiceP(VolHabilidadRepositoryP volHabilidadRepositoryP){
        this.volHabilidadRepositoryP = volHabilidadRepositoryP;
    }

    @GetMapping("/volhabilidad")
    public List<VolHabilidadP> all(){
        System.out.println("aqui");
        List<VolHabilidadP> result = null;
        result = volHabilidadRepositoryP.getAllVolHabilidad();

    return result;
}

    @RequestMapping(value= "/volhabilidad/create", method = RequestMethod.POST)
    @ResponseBody
    public String crearVolHabilidadP(HttpServletRequest request) throws ParseException {
        Integer id_voluntario = Integer.parseInt(request.getParameter("id_voluntario"));
        Integer id_habilidad = Integer.parseInt(request.getParameter("id_habilidad"));

        Integer id = volHabilidadRepositoryP.countVolHabilidad() + 1;

        VolHabilidadP volhabilidad = new VolHabilidadP(id, id_voluntario, id_habilidad);

        int db = volHabilidadRepositoryP.insertVolHabilidad(volhabilidad);
        db = db+1;

        return "El registro se Almacenó en la Instancia "+ db + " de la BD";
    }

    @GetMapping("/volhabilidad/delete/{id}")
    @ResponseBody
    public String borrarVolHabilidadP(@PathVariable int id) {
        volHabilidadRepositoryP.deleteVolHabilidad(id);

        return "El registro se elimino correctamente";
    }

    @RequestMapping(value= "/volhabilidad/update", method = RequestMethod.POST)
    @ResponseBody
    public String actualizarVolHabilidadP(HttpServletRequest request) throws ParseException {
        Integer id_voluntario = Integer.parseInt(request.getParameter("id_voluntario"));
        Integer id_habilidad = Integer.parseInt(request.getParameter("id_habilidad"));

        Integer id = Integer.parseInt(request.getParameter("id"));

        VolHabilidadP volhabilidad = new VolHabilidadP(id, id_voluntario, id_habilidad);

        volHabilidadRepositoryP.setVolHabilidad(volhabilidad);

        return "El registro se actualizó correctamente";
    }


}

