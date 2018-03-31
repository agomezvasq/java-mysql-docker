package view;

import model.Carrera;

import java.util.List;

public class CarreraView {

	public void viewCarrera(Carrera carrera) {
		System.out.println(carrera);
	}
	
	public void viewCarreras(List<Carrera> carreras) {
		for (Carrera carrera : carreras) {
			System.out.println(carrera);
		}
	}
}
