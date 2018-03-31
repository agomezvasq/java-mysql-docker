package model;

public class Estudiante {

	private int idEstudiante;
	private String nombre;
	private String documento;
	private String codigo;
	private String telefono;
	private String celular;
	private String direccion;
	private Carrera carrera;
	
	public Estudiante() {
		
	}
	
	public Estudiante(String nombre,
					  String documento,
					  String codigo,
					  String telefono,
					  String celular,
					  String direccion,
					  Carrera carrera) {
		this.nombre = nombre;
		this.documento = documento;
		this.codigo = codigo;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.carrera = carrera;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public String toString() {
		return "Estudiante: {\n" 
			 + "	idEstudiante: " + idEstudiante + ",\n"
			 + "	nombre: " + nombre + ",\n"
			 + "	documento: " + documento + ",\n"
			 + "	codigo: " + codigo + ",\n"
			 + "	telefono: " + telefono + ",\n"
			 + "	celular: " + celular + ",\n"
			 + "	direccion: " + direccion + ",\n"
			 + "	carrera: {\n"
			 + "		idCarrera: " + carrera.getIdCarrera() + ",\n"
			 + "		nombre: " + carrera.getNombre() + "\n"
			 + "	}\n"
			 + "}";
	}
}
