package g1.tbd.proyectotbd.services;

import g1.tbd.proyectotbd.models.Emergencia;
import g1.tbd.proyectotbd.repositories.EmergenciaRepository;
import g1.tbd.proyectotbd.repositories.VoluntarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.sql2o.tools.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }


    @GetMapping("/emergencia")
    public List<Emergencia> all(){
        System.out.println("aqui");
        List<Emergencia> emergencias = null;
        emergencias = emergenciaRepository.getAllEmergencias();

        return emergencias;
    }

    @RequestMapping(value= "/emergencia/create", method = RequestMethod.POST)
    @ResponseBody
    public String createEmergencia(HttpServletRequest request) throws ParseException {
        String nombre = request.getParameter("nombre");
        String descrip = request.getParameter("descripcion");
        String finicioString = request.getParameter("finicio");
        String ffinString = request.getParameter("ffin");
        String idInst = request.getParameter("idInstitucion");
        Integer id = emergenciaRepository.countEmergencias() + 1;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(finicioString);
        java.sql.Date finicio = new java.sql.Date(parsed.getTime());

        format = new SimpleDateFormat("yyyy-MM-dd");
        parsed = format.parse(ffinString);
        java.sql.Date ffin = new java.sql.Date(parsed.getTime());

        Emergencia e = new Emergencia(id, nombre, descrip, finicio, ffin, Integer.parseInt(idInst));

        emergenciaRepository.insertEmergencia(e);

        return "La emergencia se creó correctamente";
    }
}
