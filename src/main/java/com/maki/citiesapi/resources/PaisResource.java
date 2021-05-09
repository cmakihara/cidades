package com.maki.citiesapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maki.citiesapi.model.Pais;
import com.maki.citiesapi.repositories.PaisRepository;
import com.maki.citiesapi.services.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisResource {
	
	
	@Autowired
	private PaisService paisService;

	@GetMapping
	public List<Pais> paises(){
		return paisService.buscarTodos();
	}
	
//	@GetMapping
//	public Page<Pais> paises(Pageable page){
//		return paisRepository.findAll(page);
//	}
	
	@GetMapping("/{paisId}")
	public ResponseEntity<Pais> buscarById(@PathVariable Long paisId){
		
		if(!paisService.existePorId(paisId)) {
			return ResponseEntity.notFound().build();
		}
		Optional<Pais> pais = paisService.buscarPorId(paisId);
		return ResponseEntity.ok(pais.get());
	}
	
	
	
}
