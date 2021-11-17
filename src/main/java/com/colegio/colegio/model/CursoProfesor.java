package com.colegio.colegio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CursoProfesor {

	 int id;
	 Curso curso;
	 Profesor profesor;
}
