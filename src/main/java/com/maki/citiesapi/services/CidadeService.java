package com.maki.citiesapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maki.citiesapi.model.Cidade;
import com.maki.citiesapi.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public Page<Cidade> buscarTodos(Pageable page) {
		
		return cidadeRepository.findAll(page);
	}

	public boolean existeById(Long cidadeId) {
		// TODO Auto-generated method stub
		return cidadeRepository.existsById(cidadeId);
	}

	public Optional<Cidade> buscarPorId(Long cidadeId) {
		// TODO Auto-generated method stub
		return cidadeRepository.findById(cidadeId);
	}
	
	
	
	
}
