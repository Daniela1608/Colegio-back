package com.colegio.colegio.service;

import java.util.List;



import com.colegio.colegio.model.Salon;


public interface ISalonService {

	List<Salon> listar();
	void crear(Salon salon);
	void actualizar(Salon salon);
	void eliminar(int id);
	List<Salon> listarPorTipo(String tipo_salon);
}
