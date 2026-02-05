package health.healthinformation.service;

import java.util.List;

import health.healthinformation.dtos.ClientRequestDTO;
import health.healthinformation.dtos.ClientResponseDTO;

public interface ClientServiceApi {

    ClientResponseDTO createClient(ClientRequestDTO requestDTO);

    ClientResponseDTO updateClient(int clientId,ClientRequestDTO requestDTO);

    ClientResponseDTO patchClient(int clientID,ClientRequestDTO requestDTO);

    ClientResponseDTO getClientByID(int clientID);

    List<ClientResponseDTO> getAllClients();

}
