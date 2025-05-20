package health.healthinformation.repository;
import health.healthinformation.model.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client  findByClientID(int clientID);

    List<Client> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName,String lastName);
}
