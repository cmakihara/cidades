package com.maki.citiesapi.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maki.citiesapi.model.Cidade;
import com.maki.citiesapi.repositories.CidadeRepository;
import com.maki.citiesapi.services.CidadeService;

@RestController
@RequestMapping("cidades")
public class CidadeResource {

	@Autowired
	private  CidadeService cidadeService;

	public CidadeResource(final CidadeRepository repository) {
		this.cidadeService = cidadeService;
	}

	/*
	 * 1st
	 * 
	 * @GetMapping public List<City> cities() { return repository.findAll(); }
	 */

	// 2nd - Pageable
	@GetMapping
	public Page<Cidade> cidades(final Pageable page) {
		return cidadeService.buscarTodos(page);
	}
	
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Long cidadeId) {
		
		if(!cidadeService.existeById(cidadeId)) {
			return ResponseEntity.notFound().build();
		}
		
		Optional<Cidade> cidade = cidadeService.buscarPorId(cidadeId);
		return ResponseEntity.ok(cidade.get());
	}
	
}
