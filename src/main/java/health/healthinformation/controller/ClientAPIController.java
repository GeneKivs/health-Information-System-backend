package health.healthinformation.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import health.healthinformation.dtos.ClientRequestDTO;
import health.healthinformation.dtos.ClientResponseDTO;

import health.healthinformation.service.ClientServiceApi;

@RestController
@RequestMapping("/api/clients")
public class ClientAPIController {

    private final ClientServiceApi clientServiceApi;

    public ClientAPIController(ClientServiceApi clientServiceApi){
        this.clientServiceApi = clientServiceApi;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients(){
        List<ClientResponseDTO> response = clientServiceApi.getAllClients();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{clientID}")
    public ResponseEntity<ClientResponseDTO> getClientByID(@PathVariable int clientID){
        ClientResponseDTO reponse = clientServiceApi.getClientByID(clientID);
        return reponse  != null ? ResponseEntity.ok(reponse) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO requestDTO){
        ClientResponseDTO response = clientServiceApi.createClient(requestDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{clientID}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable int clientID,@RequestBody ClientRequestDTO requestDTO){
        ClientResponseDTO reponse = clientServiceApi.updateClient(clientID, requestDTO);

        return ResponseEntity.ok(reponse);
    }

    @PatchMapping("/{clientID}")
    public ResponseEntity<ClientResponseDTO> patchClient(@PathVariable int clientID,@RequestBody ClientRequestDTO requestDTO){

        ClientResponseDTO response = clientServiceApi.patchClient(clientID, requestDTO);

        return ResponseEntity.ok(response);
    }

    

}
