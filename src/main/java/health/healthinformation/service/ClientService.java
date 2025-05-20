package health.healthinformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import health.healthinformation.model.Client;
import health.healthinformation.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addclient(Client client){
        clientRepository.save(client);
    }

    public Client getClientbyClientID(int clientID){
        return clientRepository.findByClientID(clientID);
    }

    public List<Client> searchClientByName(String keyword){
        return clientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);
    }
    public List<Client> getAllclients(){
        return clientRepository.findAll();
    }

    public void updateClient(Client client){
        clientRepository.save(client);
    }

    public void deleteClientbyID(int clientID){
        clientRepository.deleteById(clientID);
    }


}
