package g1.tbd.proyectotbd.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.sql2o.Sql2o;



@Configuration
public class DatabaseContext {

    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPass;

    @Primary
    public Sql2o sql2o(){
        return new Sql2o(dbUrl, dbUser, dbPass);
    }
}
