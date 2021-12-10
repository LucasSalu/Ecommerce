package com.salu.ecommerce.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salu.ecommerce.domain.Categoria;
import com.salu.ecommerce.service.CategoriaService;
import com.salu.ecommerce.service.exceptions.ObjectNotFoundException;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // pode ser usado @GetMapping
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objetos não encontrado! Id " + id + ", Tipo" + Categoria.class.getName());
		}
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj.setId(null);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> update(@RequestBody Categoria obj, @PathVariable Integer id)
			throws ObjectNotFoundException {
		obj.setId(id);
		if (service.find(id) == null) {
			throw new ObjectNotFoundException(
					"Objetos não encontrado! Id " + id + ", Tipo" + Categoria.class.getName());
		}
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
