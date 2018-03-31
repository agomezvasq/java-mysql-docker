package controller;

import view.CarreraView;
import model.Carrera;
import dao.CarreraDAO;
import daointerface.ICarreraDAO;

import java.util.List;

public class CarreraController {

	private CarreraView carreraView = new CarreraView();
	
	public void register(Carrera carrera) {
		ICarreraDAO carreraDAO = new CarreraDAO();
		carreraDAO.register(carrera);
	}
	
	public void update(Carrera carrera) {
		ICarreraDAO carreraDAO = new CarreraDAO();
		carreraDAO.update(carrera);
	}
	
	public void delete(Carrera carrera) {
		ICarreraDAO carreraDAO = new CarreraDAO();
		carreraDAO.delete(carrera);
	}
	
	public void viewCarreras() {
		ICarreraDAO carreraDAO = new CarreraDAO();
		List<Carrera> carreras = carreraDAO.getAll();
		carreraView.viewCarreras(carreras);
	}
}
