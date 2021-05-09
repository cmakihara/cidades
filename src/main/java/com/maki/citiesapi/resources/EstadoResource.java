package com.maki.citiesapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maki.citiesapi.model.Estado;
import com.maki.citiesapi.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;

//	public EstadoResource(final EstadoRepository repository) {
//	    this.estadoService = repository;
//	  }

	@GetMapping
	public List<Estado> estados() {
		return estadoService.buscarTodos();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> estadoById(@PathVariable Long estadoId) {
		
		if(!estadoService.existeById(estadoId)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Estado> estado = estadoService.buscaPorId(estadoId);
		return ResponseEntity.ok(estado.get());
	}
}