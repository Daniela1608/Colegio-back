package com.colegio.colegio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.colegio.colegio.model.Profesor;
@Repository
public class ProfesorRepositorio {
	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;
	
	public void crear(Profesor profesor) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", profesor.getNombre());
		parameter.addValue("apellido", profesor.getApellido());
	

		String sql = "insert into profesor( nombre, apellido) values( :nombre, :apellido)";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void actualizar(Profesor profesor) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", profesor.getNombre());
		parameter.addValue("apellido", profesor.getApellido());

		String sql = "update profesor set apellido=:apellido, nombre=:nombre where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void eliminar(int id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "delete from profesor where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}
}
