package com.rcintra.cartolabackend.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer>{

	 @Transactional(readOnly = true)
	 List<Time> findAll() throws DataAccessException;
	 
}
