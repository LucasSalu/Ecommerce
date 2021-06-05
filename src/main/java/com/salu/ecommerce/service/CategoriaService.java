package com.salu.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salu.ecommerce.domain.Categoria;
import com.salu.ecommerce.repository.CategoriaRepositoy;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositoy repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
		} 

	


}
