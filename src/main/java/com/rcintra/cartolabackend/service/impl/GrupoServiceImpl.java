package com.rcintra.cartolabackend.service.impl;

import java.util.Collection;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcintra.cartolabackend.domain.Grupo;
import com.rcintra.cartolabackend.repository.GrupoRepository;
import com.rcintra.cartolabackend.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Override
	public List<Grupo> findAll() {
		return toList(grupoRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable) {
		if (iterable instanceof Collection) {
			return (List<T>) iterable;
		} else {
			return Lists.newArrayList(iterable);
		}
	}
}
