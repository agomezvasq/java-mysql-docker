package view;

import model.Estudiante;

import java.util.List;

public class EstudianteView {

	public void viewEstudiante(Estudiante estudiante) {
		System.out.println(estudiante);
	}
	
	public void viewEstudiantes(List<Estudiante> estudiantes) {
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
	}
}
