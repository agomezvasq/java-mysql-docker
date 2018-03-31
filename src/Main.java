import connection.Connector;
import model.Carrera;
import model.Estudiante;
import controller.CarreraController;
import controller.EstudianteController;

public class Main {

	public static void main(String [] args) {
		Connector.connect();
		
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
	}
}
