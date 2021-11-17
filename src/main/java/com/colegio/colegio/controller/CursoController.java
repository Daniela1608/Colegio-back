package com.colegio.colegio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.colegio.model.Curso;
import com.colegio.colegio.service.ICursoService;


@RestController
@RequestMapping(path = "/cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {

	@Autowired
	private ICursoService service;
	
	@GetMapping(path = "/listar")
	public List<Curso> listar(){
		return service.listar();
	}
	
	@PostMapping(path="/crear")
	
	public void crear(@RequestBody Curso curso) {
		service.crear(curso);
	}
	
	@PutMapping(path="/actualizar")
	
	public void actualizar(@RequestBody Curso curso) {
		service.actualizar(curso);
	}
	
	@DeleteMapping(path="eliminar/{id}")
	
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	
	
}
