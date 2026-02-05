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

import health.healthinformation.dtos.HealthProgramRequestDTO;
import health.healthinformation.dtos.HealthProgramResponseDTO;

import health.healthinformation.service.HealthProgramServiceApi;

@RestController
@RequestMapping("/api/healthprograms")
public class HealthProgramsAPIController {

    

    private final HealthProgramServiceApi programServiceApi;

    public HealthProgramsAPIController(HealthProgramServiceApi programServiceApi){
        this.programServiceApi = programServiceApi;
    }

    @GetMapping
    public ResponseEntity<List<HealthProgramResponseDTO>> getAllHealthPrograms(){
        List<HealthProgramResponseDTO> responseDTOs = programServiceApi.getAllPrograms();
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{healthProgramID}")
    public ResponseEntity <HealthProgramResponseDTO> getProgramByID(int healthProgramID){
        HealthProgramResponseDTO healthProgram =programServiceApi.getProgramByID(healthProgramID);
        return healthProgram != null ? ResponseEntity.ok(healthProgram) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HealthProgramResponseDTO> createProgram(@RequestBody HealthProgramRequestDTO healthProgram){
        HealthProgramResponseDTO saved = programServiceApi.createProgram(healthProgram);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @PutMapping("/{programID}")
    public ResponseEntity<HealthProgramResponseDTO> updateProgram(@PathVariable int programID,@RequestBody HealthProgramRequestDTO requestDTO){
        HealthProgramResponseDTO responseDTO = programServiceApi.updateProgram(programID, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/{programID}")
    public ResponseEntity<HealthProgramResponseDTO> patchProgram(@PathVariable int programID,@RequestBody HealthProgramRequestDTO requestDTO){
        HealthProgramResponseDTO responseDTO = programServiceApi.patchProgram(programID, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }



}
