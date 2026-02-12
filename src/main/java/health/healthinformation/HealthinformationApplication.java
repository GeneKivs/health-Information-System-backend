package health.healthinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HealthinformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthinformationApplication.class, args);
	}

}
