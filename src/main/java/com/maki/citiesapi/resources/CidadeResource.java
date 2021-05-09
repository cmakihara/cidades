package com.maki.citiesapi.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maki.citiesapi.model.Cidade;
import com.maki.citiesapi.repositories.CidadeRepository;

@RestController
@RequestMapping("cidades")
public class CidadeResource {

	private final CidadeRepository repository;

	public CidadeResource(final CidadeRepository repository) {
		this.repository = repository;
	}

	/*
	 * 1st
	 * 
	 * @GetMapping public List<City> cities() { return repository.findAll(); }
	 */

	// 2nd - Pageable
	@GetMapping
	public Page<Cidade> cidades(final Pageable page) {
		return repository.findAll(page);
	}
}
