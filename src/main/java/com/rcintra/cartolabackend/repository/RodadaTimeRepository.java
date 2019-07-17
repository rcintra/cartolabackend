package com.rcintra.cartolabackend.repository;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.repository.CrudRepository;

import com.rcintra.cartolabackend.model.RodadaTime;

public interface RodadaTimeRepository extends CrudRepository<RodadaTime, Integer> {

	default RodadaTime findByIdOrError(Integer id) {
		return findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	default RodadaTime findOne(Integer id) {
		return findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	default void delete(Integer id) {
		deleteById(id);
	}
	
}