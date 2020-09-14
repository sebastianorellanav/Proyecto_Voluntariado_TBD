package g1.tbd.proyectotbd.mongoRepositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import g1.tbd.proyectotbd.mongoModels.EmergenciaM;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmergenciaMRepositoryImp implements EmergenciaMRepository {
    @Autowired
    MongoDatabase database;
    @Override
    public int countEmergenciaM() {
        MongoCollection<Document> collection = database.getCollection("emergencia");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<EmergenciaM> getEmergenciaM() {
        MongoCollection<EmergenciaM> collection = database.getCollection("emergencia", EmergenciaM.class);
        List <EmergenciaM> emergencias = collection.find().into(new ArrayList<>());

        return emergencias;
    }

    @Override
    public EmergenciaM createEmergenciaM(EmergenciaM em) {
        MongoCollection<EmergenciaM> collection = database.getCollection("emergencia", EmergenciaM.class);
        collection.insertOne(em);
        return em;
    }
}
