package com.colegio.colegio.service;

import java.util.List;



import com.colegio.colegio.model.Curso;


public interface ICursoService {

	List<Curso> listar();
	void crear(Curso curso);
	void actualizar(Curso curso);
	void eliminar(int id);
	
}
