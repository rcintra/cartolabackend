package com.rcintra.cartolabackend.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.model.Grupo;

public interface GrupoRepository extends CrudRepository<Grupo, Integer> {

	@Transactional(readOnly = true)
    List<Grupo> findAll() throws DataAccessException;
	
	default Grupo findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 
}
