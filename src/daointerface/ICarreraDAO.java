package daointerface;

import java.util.List;

import model.Carrera;

public interface ICarreraDAO {
	
	public boolean register(Carrera carrera);
	public Carrera get(int idCarrera);
	public List<Carrera> getAll();
	public boolean update(Carrera carrera);
	public boolean delete(Carrera carrera);
}
