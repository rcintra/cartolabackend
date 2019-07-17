package com.rcintra.cartolabackend.repository;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.repository.CrudRepository;

import com.rcintra.cartolabackend.model.Rodada;

public interface RodadaRepository extends CrudRepository<Rodada, Integer> {

	default Rodada findByIdOrError(Integer id) {
		return findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	default Rodada findOne(Integer id) {
		return findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
}
