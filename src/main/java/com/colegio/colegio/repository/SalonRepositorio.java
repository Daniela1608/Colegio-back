package com.colegio.colegio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.colegio.colegio.model.Salon;

@Repository
public class SalonRepositorio {

	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;

	public List<Salon> listar() {
		String sql = "select * from salon";
		List<Salon> lstSalon = nameJdbcTemplate.query(sql, new RowMapper<Salon>() {

			@Override
			public Salon mapRow(ResultSet rs, int rowNum) throws SQLException {
				Salon salon = new Salon();
				salon.setId(rs.getInt("id"));
				salon.setNombre(rs.getString("nombre"));
				salon.setTipo_salon(rs.getString("tipo_salon"));
				salon.setEstado(rs.getString("estado"));
				return salon;
			}
		});
		return lstSalon;
	}

	public void crear(Salon salon) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", salon.getNombre());
		parameter.addValue("tipo_salon", salon.getTipo_salon());
		parameter.addValue("estado",salon.getEstado());

		String sql = "insert into salon( nombre, tipo_salon, estado) values( :nombre, :tipo_salon, :estado)";
		nameJdbcTemplate.update(sql, parameter);
	}

	public void actualizar(Salon salon) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", salon.getId());
		parameter.addValue("nombre", salon.getNombre());
		parameter.addValue("tipo_salon", salon.getTipo_salon());
		parameter.addValue("estado", salon.getEstado());

		String sql = "update salon set tipo_salon=:tipo_salon, nombre=:nombre, estado=:estado where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}
	
	

	public void eliminar(int id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "delete from salon where id=:id";
		nameJdbcTemplate.update(sql, parameter);
	}

	public List<Salon> listarPorTipo(String tipo_salon) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("tipo_salon", tipo_salon);
		String sql = "select * from salon where tipo_salon = :tipo_salon";

		List<Salon> listsalon = nameJdbcTemplate.query(sql, parameter, new RowMapper<Salon>() {

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
	}
	
	/*public void habilitar(int id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "update parqueadero_persona set estado = 'Despachado' where id = :id";
		namedJdbcTemplate.update(sql, parameter);
	}*/
}
