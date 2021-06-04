package com.salu.ecommerce.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET) //pode ser usado @GetMapping
	public String listar() {
		return "<h1>REST esta funcionando!</h1>";
	}

}
