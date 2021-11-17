package com.colegio.colegio.service;

import java.util.List;



import com.colegio.colegio.model.Horario;


public interface IHorarioService {

	List<Horario> listar();
	void crear(Horario horario);
	void actualizar(Horario horario);
	void eliminar(int id);
	
}
