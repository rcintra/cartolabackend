package com.rcintra.cartolabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rcintra.cartolabackend.model.Time;
import com.rcintra.cartolabackend.repository.TimeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TimeService {
	
	private TimeRepository timeRepository;
	
	public Time save(Time time) {
		return timeRepository.save(time);
	}
	
	public void save(List<Time> times) {
		for (Time t : times) {
			if (timeRepository.findTimeBySlug(t.getSlug()) == null)
				timeRepository.save(t);
		}
	}
	
}
