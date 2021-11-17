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

import com.colegio.colegio.model.Horario;
import com.colegio.colegio.service.IHorarioService;

@RestController
@RequestMapping(path = "/horario")
@CrossOrigin(origins = "http://localhost:4200")
public class HorarioController {
	
	@Autowired
	private IHorarioService service;
	
	@GetMapping(path = "/listar")
	public List<Horario> listar(){
		return service.listar();
	}
	
	@PostMapping(path="/crear")
	@CrossOrigin(origins = "http://localhost:4200")
	public void crear(@RequestBody Horario horario) {
		service.crear(horario);
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin(origins = "http://localhost:4200")
	public void actualizar(@RequestBody Horario horario) {
		service.actualizar(horario);
	}
	
	@DeleteMapping(path="eliminar/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	
	
}
