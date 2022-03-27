package com.api.controleestacionamento.controllere;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controleestacionamento.dtos.VagaEstacionamentoDto;
import com.api.controleestacionamento.models.VagaEstacionamentoModel;
import com.api.controleestacionamento.services.VagaEstacionamentoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vaga-estacionamento")
public class VagaEstacionamentoController {

	final VagaEstacionamentoService vagaEstacionamentoService;
	
	public VagaEstacionamentoController(VagaEstacionamentoService vagaEstacionamentoService) {
		this.vagaEstacionamentoService = vagaEstacionamentoService;	
	}
	
	@PostMapping
	public ResponseEntity<Object> salvarVagaEstacionamento(@RequestBody @Valid VagaEstacionamentoDto vagaEstacionamentoDto) {
		
		var vagaEstacionamentoModel = new VagaEstacionamentoModel();
		BeanUtils.copyProperties(vagaEstacionamentoDto, vagaEstacionamentoModel);
		vagaEstacionamentoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vagaEstacionamentoService.save(vagaEstacionamentoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<VagaEstacionamentoModel>> obterTodasAsVagas() {
		return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUmaVaga(@PathVariable(value = "id" )UUID id){
		Optional<VagaEstacionamentoModel> vagaEstacionamentoModelOptional = vagaEstacionamentoService.findById(id);
		if(!vagaEstacionamentoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<VagaEstacionamentoModel> parkingSpotModelOptional = vagaEstacionamentoService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vaga não escontrada!.");
        }
        vagaEstacionamentoService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Sucesso! A vaga foi deletada");
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid VagaEstacionamentoDto vagaEstacionamentoDto){
        Optional<VagaEstacionamentoModel> vagaEstacionamentoOptional = vagaEstacionamentoService.findById(id);
        if (!vagaEstacionamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        
        VagaEstacionamentoModel vagaEstacionamentoModel = new VagaEstacionamentoModel();
        BeanUtils.copyProperties(vagaEstacionamentoDto, vagaEstacionamentoModel);
        vagaEstacionamentoModel.setId(vagaEstacionamentoOptional.get().getId());
        vagaEstacionamentoModel.setDataRegistro(vagaEstacionamentoOptional.get().getDataRegistro());
        return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.save(vagaEstacionamentoModel));
    }
	
}
