package com.rcintra.cartolabackend.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.domain.Grupo;

public interface GrupoRepository extends Repository<Grupo, Integer> {

	
	@Transactional(readOnly = true)
	Collection<Grupo> findAll() throws DataAccessException;
}
