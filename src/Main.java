import connection.Connector;
import model.Carrera;
import model.Estudiante;
import controller.CarreraController;
import controller.EstudianteController;
import dao.CarreraDAO;
import dao.EstudianteDAO;
import daointerface.ICarreraDAO;
import daointerface.IEstudianteDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
	static int idCarrera = 1;
	static int idEstudiante = 1;

	public static void main(String [] args) {
		/*Connector.connect();
		
		Carrera carrera = new Carrera("Psicología");
		Estudiante estudiante = new Estudiante("Pepito",
											   "1000000000",
											   "201800000000",
											   "0000000",
											   "3000000000",
											   "Cra. 1 #1-1",
											   carrera);

		
		CarreraController carreraController = new CarreraController();
		
		carreraController.register(carrera);
		
		carrera.setIdCarrera(1);
		
		EstudianteController estudianteController = new EstudianteController();
		
		estudianteController.register(estudiante);
		
		estudianteController.viewEstudiantes();
		
		estudiante.setIdEstudiante(1);
		estudiante.setNombre("Sócrates");
		
		estudianteController.update(estudiante);
		*/
		
		if(args.length==0) {
			System.out.println("Inserte argumentos");
			return;
		}
		if(args[0].equalsIgnoreCase("INSERT")) {
			if(args[1].equalsIgnoreCase("carrera")) {
				ICarreraDAO carreraDAO = new CarreraDAO();
				List<Carrera> carreras = carreraDAO.getAll();
				for (Carrera c:carreras) {
					if(c.getNombre().equalsIgnoreCase(args[2])) {
						System.out.println("Esta carrera ya se encuentra registrada");
						return;
					}
					
				}
				Carrera carrera = new Carrera(args[2]);
				CarreraController carreraController = new CarreraController();
				
				carreraController.register(carrera);
				carreras = carreraDAO.getAll();
				carrera.setIdCarrera(carreras.size());
				System.out.println("Registros actualizados.");
				
			}else if(args[1].equalsIgnoreCase("estudiante")) {
				IEstudianteDAO estudianteDAO = new EstudianteDAO();
				List<Estudiante> estudiantes = estudianteDAO.getAll();
				for (Estudiante e:estudiantes) {
					if(e.getDocumento().equalsIgnoreCase(args[3])) {
						System.out.println("Esta persona ya se encuentra registrada");
						return;
					}
				}
				Estudiante estudiante = new Estudiante(args[2],
						args[3],
						args[4],
						args[5],
						args[6],
						args[7],
						   carrera); // en lugar de carrera, Buscar una carrera ya creada usando un argumento idCarrera
			}
		}
		if(args[0].equalsIgnoreCase("READ")) {
			
		}
		if(args[0].equalsIgnoreCase("UPDATE")) {
			
		}
		if(args[0].equalsIgnoreCase("DELETE")) {
			
		}
		
		System.out.println(args[0]);
		
	}
}
