package com.colegio.colegio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.colegio.colegio.model.Estudiante;
@Repository
public class EstudianteRepositorio {
	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;
	
	public void crear(Estudiante estudiante) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("codigo", estudiante.getCodigo());
		parameter.addValue("nombre", estudiante.getNombre());
		parameter.addValue("apellido", estudiante.getApellido());
	
		String sql = "insert into estudiante( codigo,nombre, apellido) values( :codigo, :nombre, :apellido)";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void actualizar(Estudiante estudiante) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("codigo", estudiante.getCodigo());
		parameter.addValue("nombre", estudiante.getNombre());
		parameter.addValue("apellido", estudiante.getApellido());

		String sql = "update estudiante set apellido=:apellido, nombre=:nombre, codigo=:codigo where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void eliminar(int id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "delete from estudiante where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}
}
