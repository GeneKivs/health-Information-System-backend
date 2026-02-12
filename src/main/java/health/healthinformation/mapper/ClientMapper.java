package health.healthinformation.mapper;

import health.healthinformation.dtos.ClientRequestDTO;
import health.healthinformation.dtos.ClientResponseDTO;
import health.healthinformation.model.Client;

public class ClientMapper {

    private ClientMapper(){}

    public static Client toEntity(ClientRequestDTO dto){
        if (dto == null) {
            return null;
        }

        Client client = new Client();
        client.setFirstName(dto.getFirstNmae());
        client.setLastName(dto.getLastName());
        client.setAge(dto.getAge());
        client.setPhoneNumber(dto.getPhoneNumber());

        return client;
    }

    public static ClientResponseDTO toResponse(Client client){
        if (client == null) {
            return null;
        }

        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setClientID(client.getClientID());
        String fullName = client.getFirstName() + " " + client.getLastName();
        dto.setClientName(fullName);
        dto.setAge(client.getAge());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setCreatedAt(client.getCreatedAt());
        dto.setUpdatedAT(client.getUpdatedAT());

        return dto;
    }

}
