package com.devsuperior.bds02.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;



@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll () {
		
		List<City> lista = repository.findAll(Sort.by("name"));
		return lista.stream().map(x-> new CityDTO(x)).collect(Collectors.toList());
		
	}
	
	public CityDTO findById(Long id) {
		Optional<City> object = repository.findById(id);
		City entity = object.orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada com essa id"));
		CityDTO cityDto = new CityDTO(entity);
		return cityDto;
	}
	
	@Transactional
	public CityDTO insert (CityDTO dto) {
		
		City entidade = new City();
		entidade.setName(dto.getName());
		entidade = repository.save(entidade);
		return new CityDTO(entidade);
		
	}
	
	

}
