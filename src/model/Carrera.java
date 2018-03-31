package model;

public class Carrera {

	private int idCarrera;
	private String nombre;
	
	public Carrera() {
		
	}
	
	public Carrera(String nombre) {
		this.setNombre(nombre);
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Carrera: {\n" 
			 + "	idCarrera: " + idCarrera + ",\n"
			 + "	nombre: " + nombre + "\n"
			 + "}";
	}
}
