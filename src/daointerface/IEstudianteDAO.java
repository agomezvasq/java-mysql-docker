package daointerface;

import model.Estudiante;

import java.util.List;

public interface IEstudianteDAO {
	
	public boolean register(Estudiante estudiante);
	public List<Estudiante> getAll();
	public boolean update(Estudiante estudiante);
	public boolean delete(Estudiante estudiante);
}
