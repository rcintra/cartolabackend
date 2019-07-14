package com.rcintra.cartolabackend.repository;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.model.Campeonato;

public interface CampeonatoRepository extends CrudRepository<Campeonato, Integer> {

	default Campeonato findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
	
	@Transactional(readOnly = true)
    Collection<Campeonato> findAll() throws DataAccessException;
	
}
