package com.rcintra.cartolabackend.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rcintra.cartolabackend.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer>{

	 @Transactional(readOnly = true)
	 List<Time> findAll() throws DataAccessException;
	 
	 @Query("select t from Time t where t.slug =:slug")
	 public Time findTimeBySlug(@Param("slug") String slug);
	 
}
