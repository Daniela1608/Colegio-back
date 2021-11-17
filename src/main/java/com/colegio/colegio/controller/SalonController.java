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

import com.colegio.colegio.model.Salon;
import com.colegio.colegio.service.ISalonService;


@RestController
@RequestMapping(path = "/salones")
@CrossOrigin(origins = "http://localhost:4200")
public class SalonController {

	@Autowired
	private ISalonService service;
	
	@GetMapping(path = "/listar")
	public List<Salon> listar(){
		return service.listar();
	}
	
	@PostMapping(path="/crear")
	@CrossOrigin(origins = "http://localhost:4200")
	public void crear(@RequestBody Salon salon) {
		service.crear(salon);
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin(origins = "http://localhost:4200")
	public void actualizar(@RequestBody Salon salon) {
		service.actualizar(salon);
	}
	
	@DeleteMapping(path="eliminar/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	
	@GetMapping(path="/buscar-por-tipo/{tipo_salon}")
	public List<Salon> listarPorTipo(@PathVariable String tipo_salon) {
		return service.listarPorTipo(tipo_salon);
	}
	
}
