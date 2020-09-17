package g1.tbd.proyectotbd.repositoriesP;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseContextP {
  @Value("${database.url1}")
  private String dbUrl1;
  @Value("${database.url2}")
  private String dbUrl2;
  @Value("${database.url3}")
  private String dbUrl3;

  @Value("${database.user1}")
  private String dbUser1;
  @Value("${database.user2}")
  private String dbUser2;
  @Value("${database.user3}")
  private String dbUser3;

  @Value("${database.password1}")
  private String dbPass1;
  @Value("${database.password2}")
  private String dbPass2;
  @Value("${database.password3}")
  private String dbPass3;

  @Bean
  @Primary
  public List<Sql2o> sql2o(){
    List<Sql2o> sql2oList = new ArrayList<Sql2o>();
    sql2oList.add(new Sql2o(dbUrl1, dbUser1, dbPass1));
    sql2oList.add(new Sql2o(dbUrl2, dbUser2, dbPass2));
    sql2oList.add(new Sql2o(dbUrl3, dbUser3, dbPass3));
    return sql2oList;
  }

  /*
  public Sql2o sql2o[];
  
  public DatabaseContextP () {
    sql2o[0] = new Sql2o("jdbc:postgresql://localhost:5432/voluntariadodb1","posygres","5115126FRANCO");
    sql2o[1] = new Sql2o("jdbc:postgresql://localhost:5432/voluntariadodb2","postgres","5115126FRANCO");
    sql2o[2] = new Sql2o("jdbc:postgresql://localhost:5432/voluntariadodb3","postgres","5115126FRANCO");
  }

   */
  
}
