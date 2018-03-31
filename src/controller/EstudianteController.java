package controller;

import view.EstudianteView;
import model.Estudiante;
import dao.EstudianteDAO;
import daointerface.IEstudianteDAO;

import java.util.List;

public class EstudianteController {

	private EstudianteView estudianteView = new EstudianteView();
	
	public void register(Estudiante estudiante) {
		IEstudianteDAO estudianteDAO = new EstudianteDAO();
		estudianteDAO.register(estudiante);
	}
	
	public void update(Estudiante estudiante) {
		IEstudianteDAO estudianteDAO = new EstudianteDAO();
		estudianteDAO.update(estudiante);
	}
	
	public void delete(Estudiante estudiante) {
		IEstudianteDAO estudianteDAO = new EstudianteDAO();
		estudianteDAO.delete(estudiante);
	}
	
	public void viewEstudiantes() {
		IEstudianteDAO estudianteDAO = new EstudianteDAO();
		List<Estudiante> estudiantes = estudianteDAO.getAll();
		estudianteView.viewEstudiantes(estudiantes);
	}
}
