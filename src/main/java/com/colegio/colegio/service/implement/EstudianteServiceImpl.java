package com.colegio.colegio.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.colegio.model.Estudiante;
import com.colegio.colegio.repository.EstudianteRepositorio;

import com.colegio.colegio.service.IEstudianteService;
@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private EstudianteRepositorio repo;
	
	@Override
	public void crear(Estudiante estudiante) {
		// TODO Auto-generated method stub
		repo.crear(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		repo.actualizar(estudiante);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.eliminar(id);
	}

}
