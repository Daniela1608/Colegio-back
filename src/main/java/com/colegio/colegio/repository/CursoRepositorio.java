package com.colegio.colegio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.colegio.colegio.model.Curso;
@Repository
public class CursoRepositorio {

	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;

	public List<Curso> listar() {
		String sql = "select * from curso";
		List<Curso> lstCurso = nameJdbcTemplate.query(sql, new RowMapper<Curso>() {

			@Override
			public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNombre(rs.getString("nombre"));
				curso.setDescripcion(rs.getString("descripcion"));
				
				return curso;
			}
		});
		return lstCurso;
	}

	public void crear(Curso curso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", curso.getNombre());
		parameter.addValue("descripcion", curso.getDescripcion());
		

		String sql = "insert into curso( nombre, descripcion) values( :nombre, :descripcion)";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void actualizar(Curso curso) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", curso.getId());
		parameter.addValue("nombre", curso.getNombre());
		parameter.addValue("descripcion", curso.getDescripcion());
		

		String sql = "update curso set descripcion=:descripcion, nombre=:nombre where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void eliminar(int id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "delete from curso where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}

	/*public List<Salon> listarPorFechaActual() {


		String sql = "select * from salon where tipo_salon = :tipo_salon";

		List<Salon> listsalon = nameJdbcTemplate.query(sql, new RowMapper<Salon>() {

			@Override
			public Salon mapRow(ResultSet rs, int rowNum) throws SQLException {
				Salon salon = new Salon();
				salon.setId(rs.getInt("id"));
				salon.setNombre(rs.getString("nombre"));
				salon.setTipo_salon(rs.getString("tipo_salon"));
				return salon;
			}
		});
		return listsalon;
	}*/
}
