package health.healthinformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import health.healthinformation.model.HealthProgram;

public interface HealthProgramRepository extends JpaRepository<HealthProgram, Integer> {
   HealthProgram findByHealthProgramID(int healthProgramID);

}
