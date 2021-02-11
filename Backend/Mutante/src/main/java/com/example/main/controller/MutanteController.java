package com.example.main.controller;

import javax.transaction.Transactional;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.dtos.MutanteDTO;
import com.example.main.service.MutanteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path = "api/v1/mutante2")
public class MutanteController {
	
	private MutanteService service;

	
	//CONSTRUCTOR
	public MutanteController(MutanteService service) {
		this.service = service;
	}
	
	
	//MÉTODOS
	//getAll
	@GetMapping("/")
	@Transactional
	public ResponseEntity getAll() {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error.\"}");
			
		}
	}
	
	
	//getOne
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
			
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Registro no encontrado.\"}");
				
		}
	}
	
	
	//post
	@PostMapping("/")
	@Transactional
	public ResponseEntity post(@RequestBody MutanteDTO dto) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(dto, service.isMutant(dto)));
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error al guardar.\"}");
		}	
	}
	
	
	//put
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody MutanteDTO dto) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto, service.isMutant(dto)));
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error al actualizar.\"}");
		}
	}
	
	
	//delete
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
			
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Registro eliminado\"}");
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");
			
		}
	}
	
	
	//getStats
	@GetMapping("/stats")
	@Transactional
	public ResponseEntity getStats() {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.stats());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error.");
		}
		
	}
}
