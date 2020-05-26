package g1.tbd.proyectotbd;

import g1.tbd.proyectotbd.repositories.VoluntarioRepository;
import g1.tbd.proyectotbd.repositories.VoluntarioRepositoryImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectotbdApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProyectotbdApplication.class, args);
		VoluntarioRepository a=new VoluntarioRepositoryImp();
		System.out.println("holas");

	}

}
