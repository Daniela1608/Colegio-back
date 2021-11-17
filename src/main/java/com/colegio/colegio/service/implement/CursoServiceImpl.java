package com.colegio.colegio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.colegio.model.Curso;
import com.colegio.colegio.repository.CursoRepositorio;
import com.colegio.colegio.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private CursoRepositorio repo; 
	
	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return repo.listar();
	}

	@Override
	public void crear(Curso curso) {
		// TODO Auto-generated method stub
		repo.crear(curso);
		
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		repo.actualizar(curso);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.eliminar(id);
	}

}
