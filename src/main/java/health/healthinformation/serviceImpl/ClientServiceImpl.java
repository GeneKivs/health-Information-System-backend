package health.healthinformation.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import health.healthinformation.dtos.ClientRequestDTO;
import health.healthinformation.dtos.ClientResponseDTO;
import health.healthinformation.mapper.ClientMapper;
import health.healthinformation.model.Client;
import health.healthinformation.repository.ClientRepository;
import health.healthinformation.service.ClientServiceApi;


@Service
public class ClientServiceImpl implements ClientServiceApi {

    public final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO requestDTO){
        Client client = ClientMapper.toEntity(requestDTO);
        Client savedClient = clientRepository.save(client);

        return ClientMapper.toResponse(savedClient);

    }

    @Override
    public ClientResponseDTO updateClient(int clientID,ClientRequestDTO requestDTO){
        Client existingclient = clientRepository.findById(clientID).orElseThrow();

        existingclient.setFirstName(requestDTO.getFirstNmae());
        existingclient.setLastName(requestDTO.getLastName());
        existingclient.setAge(requestDTO.getAge());
        existingclient.setPhoneNumber(requestDTO.getPhoneNumber());

        Client updateClient = clientRepository.save(existingclient);

        return ClientMapper.toResponse(updateClient);
    }

    @Override
    public ClientResponseDTO patchClient(int clientID,ClientRequestDTO requestDTO){
        Client existingClient = clientRepository.findById(clientID).orElseThrow();

        if (requestDTO.getFirstNmae() != null) {
            existingClient.setFirstName(requestDTO.getFirstNmae());
        }

        if (requestDTO.getLastName() != null) {
            existingClient.setLastName(requestDTO.getLastName());
        }

        if (requestDTO.getPhoneNumber() != null ) {
            existingClient.setPhoneNumber(requestDTO.getPhoneNumber());
        }

        existingClient.setAge(requestDTO.getAge());

        Client patchClient = clientRepository.save(existingClient);

        return ClientMapper.toResponse(patchClient);
            
        }

        @Override
        public ClientResponseDTO getClientByID(int clientID){
            return clientRepository.findById(clientID)
                    .map(ClientMapper :: toResponse)
                    .orElseThrow(); 
            
        }

        public List<ClientResponseDTO> getAllClients(){
            return clientRepository.findAll()
                    .stream()
                    .map(ClientMapper:: toResponse)
                    .collect(Collectors.toList());
        }
    }


