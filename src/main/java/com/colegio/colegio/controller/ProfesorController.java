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


import com.colegio.colegio.model.Profesor;
import com.colegio.colegio.service.IProfesorService;

@RestController
@RequestMapping(path = "/Profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService service;
	
	@PostMapping(path="/crear")
	@CrossOrigin(origins = "http://localhost:4200")
	public void crear(@RequestBody Profesor profesor) {
		service.crear(profesor);
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin(origins = "http://localhost:4200")
	public void actualizar(@RequestBody Profesor profesor) {
		service.actualizar(profesor);
	}
	
	@DeleteMapping(path="eliminar/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
}
