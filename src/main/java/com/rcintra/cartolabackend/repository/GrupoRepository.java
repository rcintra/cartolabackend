package com.rcintra.cartolabackend.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	@Transactional(readOnly = true)
    List<Grupo> findAll() throws DataAccessException;
	
}
