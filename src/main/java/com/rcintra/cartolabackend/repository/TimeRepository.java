package com.rcintra.cartolabackend.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.model.Time;

public interface TimeRepository extends Repository<Time, Integer>{

	 @Transactional(readOnly = true)
	 Collection<Time> findAll() throws DataAccessException;
}
