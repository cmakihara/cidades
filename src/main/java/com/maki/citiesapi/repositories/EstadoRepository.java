package com.maki.citiesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maki.citiesapi.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
