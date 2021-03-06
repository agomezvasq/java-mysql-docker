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
		
		Carrera carrera = new Carrera("Psicolog�a");
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
		estudiante.setNombre("S�crates");
		
		estudianteController.update(estudiante);
		*/
		
		if(args.length==0) {
			System.out.println("Inserte argumentos");
			return;
		}
		
		CarreraController carreraController = new CarreraController();
		EstudianteController estudianteController = new EstudianteController();
		ICarreraDAO carreraDAO = new CarreraDAO();
		IEstudianteDAO estudianteDAO = new EstudianteDAO();
		
		if(args[0].equalsIgnoreCase("INSERT")) {
			if(args[1].equalsIgnoreCase("carreras")) {
				
				List<Carrera> carreras = carreraDAO.getAll();
				for (Carrera c:carreras) {
					if(c.getNombre().equalsIgnoreCase(args[2])) {
						System.out.println("Esta carrera ya se encuentra registrada");
						return;
					}
					
				}
				Carrera carrera = new Carrera(args[2]);
				
				carreraController.register(carrera);
				carreras = carreraDAO.getAll();
				carrera.setIdCarrera(carreras.size());
				System.out.println("Registro de carreras actualizado.");
				
			}else if(args[1].equalsIgnoreCase("estudiantes")) {
				
				List<Estudiante> estudiantes = estudianteDAO.getAll();
				for (Estudiante e:estudiantes) {
					if(e.getDocumento().equalsIgnoreCase(args[3])) {
						System.out.println("Esta persona ya se encuentra registrada");
						return;
					}
				}
				try{
				Estudiante estudiante = new Estudiante(args[2],
						args[3],
						args[4],
						args[5],
						args[6],
						args[7],
						   carreraController.get(Integer.parseInt(args[8])));
				estudianteController.register(estudiante);
				estudiantes = estudianteDAO.getAll();
				estudiante.setIdEstudiante(estudiantes.size());
				
				}catch(Exception e) {
					System.out.println("N�mero de argumentos incorrecto o la carrera especificada no existe.");
					return;
				}
				System.out.println("Registros de estudiantes actualizado.");
			}else {
				System.out.println("Sintaxis: INSERT <tabla> <arg1> <arg2> ... <arg n>");
				System.out.println("Ejemplo: INSERT carreras Psicolog�a" );
				System.out.println("Ejemplo: INSERT estudiantes Pepito 11111111 201810009050 2550101 3113213211 \"Cra. 1 #1-1\" 1");
			}
		}
		else if(args[0].equalsIgnoreCase("READ")) {
			if(args[1].equalsIgnoreCase("carreras")){
				printCarreras(carreraDAO.getAll());
			}else if(args[1].equalsIgnoreCase("estudiantes")) {
				printEstudiantes(estudianteDAO.getAll());
			}else {
				System.out.println("Sintaxis: READ <Tabla>  Ejemplo: Read carreras, Read estudiantes");
			}
			
		}
		else if(args[0].equalsIgnoreCase("UPDATE")) {
			if(args[1].equalsIgnoreCase("carreras")){
				Carrera carr = new Carrera(args[3]);
				carr.setIdCarrera(Integer.parseInt(args[2]));
				carr.setNombre(args[3]);
				carreraDAO.update(carr);
				
			}else if (args[1].equalsIgnoreCase("estudiantes")) {
				Estudiante est = new Estudiante(args[3],
						args[4],
						args[5],
						args[6],
						args[7],
						args[8],
						   carreraController.get(Integer.parseInt(args[9])));
				est.setIdEstudiante(Integer.parseInt(args[2]));
				estudianteDAO.update(est);
			}else {
				System.out.println("Sintaxis: UPDATE <Tabla> <id_registro_a_actualizar> <campo 1> <campo 2> ...<campo n>");
			}
		}
		else if(args[0].equalsIgnoreCase("DELETE")) {
			if(args[1].equalsIgnoreCase("carreras")) {
				carreraDAO.delete(carreraDAO.get(Integer.parseInt(args[2])));
				System.out.println("Registro "+args[2]+" de la tabla carreras eliminado.");
			}else if(args[1].equalsIgnoreCase("estudiantes")) {
				estudianteDAO.delete(estudianteDAO.get(Integer.parseInt(args[2])));
				System.out.println("Registro "+args[2]+" de la tabla estudiantes eliminado.");
			}else {
				System.out.println("Sintaxis: Delete <Tabla> <id>  Ejemplo: Delete carreras 4, Delete estudiantes 2");
			}
		}
		
		System.out.println(args[0]);
		
	}
	public static void printCarreras(List<Carrera> list){
		for(Object c:list) {
			System.out.println(c.toString());
			System.out.println("");
		}
	}
	public static void printEstudiantes(List<Estudiante> list){
		for(Object e:list) {
			System.out.println(e.toString());
			System.out.println("");
		}
	}
}
