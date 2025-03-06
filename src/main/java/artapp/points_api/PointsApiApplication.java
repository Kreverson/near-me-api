package artapp.points_api;

import artapp.points_api.entity.PointOfInterest;
import artapp.points_api.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PointsApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PointsApiApplication.class, args);
	}

	@Autowired
	private PointOfInterestRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new PointOfInterest("Lanchonete", 27L, 12L));
		repository.save(new PointOfInterest("Posto", 31L, 18L));
		repository.save(new PointOfInterest("Joalheria", 15L, 12L));
		repository.save(new PointOfInterest("Pub", 12L, 8L));
		repository.save(new PointOfInterest("Supermercado", 23L, 6L));
		repository.save(new PointOfInterest("Churrascaria", 28L, 2L));
	}
}
