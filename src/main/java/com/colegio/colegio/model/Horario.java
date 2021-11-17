package com.colegio.colegio.model;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Horario {

	 int id;
	 String hora_inicio;
	 String hora_final;
	 Date dia;
	 Curso curso;
	 Salon salon;
}
