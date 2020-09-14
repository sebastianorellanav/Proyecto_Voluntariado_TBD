package g1.tbd.proyectotbd.repositories;

import org.springframework.stereotype.Component;
import org.sql2o.Sql2o;

@Component
public class DatabaseContextP {

  public Sql2o sql2o[] = new Sql2o[3];
  
  public DatabaseContextP () {
    sql2o[0] = new Sql2o("jdbc:postgresql://localhost:5432/voluntariadodb1","postgres","A1b2c3z0");
    sql2o[1] = new Sql2o("jdbc:postgresql://localhost:5432/voluntariadodb2","postgres","A1b2c3z0");
    sql2o[2] = new Sql2o("jdbc:postgresql://localhost:5432/voluntariadodb3","postgres","A1b2c3z0");
  }
  
}
