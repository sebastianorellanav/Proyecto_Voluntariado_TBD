package g1.tbd.proyectotbd.mongoServices;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import g1.tbd.proyectotbd.mongoRepositories.AgreggateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.bson.Document;
import java.util.List;

@RestController
public class AgreggateService {
    private final AgreggateRepository agreggateRepository;
    AgreggateService(AgreggateRepository agreggateRepository){this.agreggateRepository=agreggateRepository;}

    @GetMapping("/aggregate")
    public List<Document> agregacion(){
        return agreggateRepository.agregacion();
    }

}
