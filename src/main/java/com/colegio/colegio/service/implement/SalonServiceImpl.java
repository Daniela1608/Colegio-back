package com.colegio.colegio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.colegio.model.Salon;

import com.colegio.colegio.repository.SalonRepositorio;
import com.colegio.colegio.service.ISalonService;
@Service
public class SalonServiceImpl implements ISalonService {

	@Autowired
	private SalonRepositorio repo; 
	
	@Override
	public List<Salon> listar() {
		// TODO Auto-generated method stub
		return repo.listar();
	}

	@Override
	public void crear(Salon salon) {
		// TODO Auto-generated method stub
		repo.crear(salon);
	}

	@Override
	public void actualizar(Salon salon) {
		// TODO Auto-generated method stub
		repo.actualizar(salon);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.eliminar(id);
	}

	@Override
	public List<Salon> listarPorTipo(String tipo_salon) {
		// TODO Auto-generated method stub
		return repo.listarPorTipo(tipo_salon);
	}

}
