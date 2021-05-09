package com.maki.citiesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maki.citiesapi.model.Estado;
import com.maki.citiesapi.repositories.EstadoRepository;

@Service
public class EstadoService {

	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> buscarTodos() {
		
		return estadoRepository.findAll();
	}

	public boolean existeById(Long estadoId) {
		
		return estadoRepository.existsById(estadoId);
	}

	public Optional<Estado> buscaPorId(Long estadoId) {
		
		return estadoRepository.findById(estadoId);
	}
	
	
}
