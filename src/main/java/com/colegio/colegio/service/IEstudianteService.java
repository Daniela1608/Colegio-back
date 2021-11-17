package com.colegio.colegio.service;



import com.colegio.colegio.model.Estudiante;


public interface IEstudianteService {

	void crear(Estudiante estudiante);
	void actualizar(Estudiante estudiante);
	void eliminar(int id);
}
