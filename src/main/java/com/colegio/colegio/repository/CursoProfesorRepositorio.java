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
import com.colegio.colegio.model.CursoProfesor;
import com.colegio.colegio.model.Profesor;


@Repository
public class CursoProfesorRepositorio {

	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;
	
	public List<CursoProfesor>listar(int id) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		
		String sql= " SELECT c.nombre as curso, c.descripcion as descripcion, p.nombre as nombre, p.apellido as apellido, h.hora_inicio as Inicio, h.hora_final as Final, h.dia as dia  FROM `curso` c inner join curso_profesor cp on c.id = cp.id_curso INNER join profesor p on cp.id_profesor = p.id inner join horario h on c.id_horario = h.id where c.id = id";
		List<CursoProfesor> lstCursoProfesor = nameJdbcTemplate.query(sql, new RowMapper<CursoProfesor>() {

			@Override
			public CursoProfesor mapRow(ResultSet rs, int rowNum) throws SQLException {
				CursoProfesor cursoProfesor = new CursoProfesor();
				cursoProfesor.setId(rs.getInt("id"));
				
				Curso curso = new Curso();
				curso.setId(rs.getInt("id_curso"));
				curso.setId(id);
				
				Profesor profesor = new Profesor();
				profesor.setId(rs.getInt("id_profesor"));
				profesor.setId(id);
				return cursoProfesor;
			}
		});
		return lstCursoProfesor;
	}
	
	
	
}
