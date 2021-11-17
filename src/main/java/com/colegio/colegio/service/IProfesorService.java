package com.colegio.colegio.service;



import com.colegio.colegio.model.Profesor;

public interface IProfesorService {

	void crear(Profesor profesor);
	void actualizar(Profesor profesor);
	void eliminar(int id);
}
