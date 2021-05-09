package com.maki.citiesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maki.citiesapi.model.Pais;
import com.maki.citiesapi.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	public List<Pais> buscarTodos() {
		return paisRepository.findAll();
	}
	
	public Optional<Pais> buscarPorId(Long paisId) {
		return paisRepository.findById(paisId);
	}
	
	public boolean existePorId(long paisId) {
		return paisRepository.existsById(paisId);
	}
	
}
