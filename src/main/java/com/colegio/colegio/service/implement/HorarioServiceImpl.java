package com.colegio.colegio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.colegio.model.Horario;

import com.colegio.colegio.repository.HorarioRepositorio;
import com.colegio.colegio.service.IHorarioService;
@Service
public class HorarioServiceImpl implements IHorarioService{

	@Autowired
	private HorarioRepositorio repo;
	
	@Override
	public List<Horario> listar() {
		// TODO Auto-generated method stub
		return repo.listar();
	}

	@Override
	public void crear(Horario horario) {
		// TODO Auto-generated method stub
		repo.crear(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		repo.actualizar(horario);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.eliminar(id);
	}

}
