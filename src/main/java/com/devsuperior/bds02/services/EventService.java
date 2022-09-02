package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityRepository CityRepository;
	
	@Transactional
	public EventDTO update (Long id, EventDTO eventDTO) {
		try {
			Event entity = repository.getOne(id);
			entity.setName(eventDTO.getName());
			entity.setDate(eventDTO.getDate());
			entity.setUrl(eventDTO.getUrl());
			entity.setCity(new City(eventDTO.getCityId(),null));
			entity = repository.save(entity);
			return new EventDTO(entity);			
			
		} catch (EntityNotFoundException error) {
			throw new ResourceNotFoundException("Id desse evento não foi encontrado. Id de número: " +id );
		}
	}
	

}
