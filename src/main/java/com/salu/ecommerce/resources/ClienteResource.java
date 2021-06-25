package com.salu.ecommerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salu.ecommerce.domain.Cliente;
import com.salu.ecommerce.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	

	@RequestMapping(value="/{id}", method = RequestMethod.GET)  //pode ser usado @GetMapping
	public ResponseEntity<?> find(@PathVariable Integer id){
	
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
