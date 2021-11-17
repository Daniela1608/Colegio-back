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
import com.colegio.colegio.model.Horario;
import com.colegio.colegio.model.Salon;
@Repository
public class HorarioRepositorio {
	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;
	
	public List<Horario> listar() {
		String sql = "select * from horario";
		List<Horario> lstHorario = nameJdbcTemplate.query(sql, new RowMapper<Horario>() {

			@Override
			public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Horario horario = new Horario();
				Curso curso = new Curso();
				Salon salon = new Salon();
				horario.setId(rs.getInt("id"));
				horario.setHora_inicio(rs.getString("hora_inicio"));
				horario.setHora_final(rs.getString("hora_final"));
				horario.setDia(rs.getDate("dia"));
				curso.setId(rs.getInt("id_curso"));
				salon.setId(rs.getInt("id_salon"));
				horario.setCurso(curso);
				horario.setSalon(salon);
						
				return horario;
			}
		});
		return lstHorario;
	}
	public void crear(Horario horario) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("hora_inicio", horario.getHora_inicio());
		parameter.addValue("hora_final", horario.getHora_final());
		parameter.addValue("dia", horario.getDia());
		parameter.addValue("id_curso", horario.getCurso().getId());
		parameter.addValue("id_salon", horario.getSalon().getId());
		
		
		String sql = "insert into horario( hora_inicio,hora_final, dia, id_curso, id_salon ) values( :hora_inicio, :hora_final, :dia,  :id_curso, :id_salon)";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void actualizar(Horario horario) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", horario.getId());
		parameter.addValue("hora_inicio", horario.getHora_inicio());
		parameter.addValue("hora_final", horario.getHora_final());
		parameter.addValue("dia", horario.getDia());
		parameter.addValue("id_curso", horario.getCurso().getId());
		parameter.addValue("id_salon", horario.getSalon().getId());

		String sql = "update horario set hora_inicio=:hora_inicio, hora_final=:hora_final, dia=:dia, id_curso=:id_curso, id_salon=:id_salon  where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void eliminar(int id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "delete from horario where id=:id";
		nameJdbcTemplate.update(sql, parameter);
		
	}
	
	
}
