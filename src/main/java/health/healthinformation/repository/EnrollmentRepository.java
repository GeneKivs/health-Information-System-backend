package health.healthinformation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import health.healthinformation.model.Enrollment;
import health.healthinformation.model.HealthProgram;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Query("SELECT healthProgram FROM Enrollment WHERE client.clientID = :clientID")
    List<HealthProgram> findHealthProgramsByClientID(@Param("clientID") int clientID);
}