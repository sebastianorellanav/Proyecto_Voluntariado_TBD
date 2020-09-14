package g1.tbd.proyectotbd.mongoRepositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import g1.tbd.proyectotbd.mongoModels.InstitucionM;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstitucionMRepositoryImp implements InstitucionMRepository {
    @Autowired
    MongoDatabase database;

    @Override
    public int countInstitucionM() {
        MongoCollection<Document> collection = database.getCollection("institucion");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<InstitucionM> getInstitucionM() {
        MongoCollection<InstitucionM> collection = database.getCollection("institucion", InstitucionM.class);
        List<InstitucionM> instituciones = collection.find().into(new ArrayList<>());

        return instituciones;
    }

    @Override
    public InstitucionM createInstitucionM(InstitucionM iM) {
        MongoCollection<InstitucionM> collection = database.getCollection("institucion", InstitucionM.class);
        collection.insertOne(iM);
        return iM;
    }
}
