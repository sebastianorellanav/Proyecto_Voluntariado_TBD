package g1.tbd.proyectotbd.mongoRepositories;

import com.mongodb.DBObject;
import com.mongodb.DocumentToDBRefTransformer;

import org.bson.Document;
import java.util.List;

public interface AgreggateRepository {
    public List<Document> agregacion();
}
