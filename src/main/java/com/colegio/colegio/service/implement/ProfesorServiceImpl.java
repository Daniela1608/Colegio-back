package com.colegio.colegio.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.colegio.model.Profesor;

import com.colegio.colegio.repository.ProfesorRepositorio;
import com.colegio.colegio.service.IProfesorService;
@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	private ProfesorRepositorio repo;
	
	@Override
	public void crear(Profesor profesor) {
		// TODO Auto-generated method stub
		repo.crear(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		repo.actualizar(profesor);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.eliminar(id);
	}

}
