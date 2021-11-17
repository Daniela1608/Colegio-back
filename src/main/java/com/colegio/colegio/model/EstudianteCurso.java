package com.colegio.colegio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EstudianteCurso {

	 int id;
	 Estudiante estudiante;
	 Curso curso;
}
