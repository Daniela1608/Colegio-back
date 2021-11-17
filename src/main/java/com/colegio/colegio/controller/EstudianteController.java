package com.colegio.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.colegio.model.Estudiante;
import com.colegio.colegio.service.IEstudianteService;

@RestController
@RequestMapping(path = "/Estudiantes")

public class EstudianteController {
	
	@Autowired
	private IEstudianteService service;
	
	@PostMapping(path="/crear")
	@CrossOrigin(origins = "http://localhost:4200")
	public void crear(@RequestBody Estudiante estudiante) {
		service.crear(estudiante);
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin(origins = "http://localhost:4200")
	public void actualizar(@RequestBody Estudiante estudiante) {
		service.actualizar(estudiante);
	}
	
	@DeleteMapping(path="eliminar/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
}
