package dao;

import connection.Connector;
import daointerface.IEstudianteDAO;
import model.Estudiante;
import model.Carrera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements IEstudianteDAO {

	@Override
	public boolean register(Estudiante estudiante) {
		boolean register = false;
		
		Connection connection = null;
		Statement statement = null;
		
		String sqlQuery = "INSERT INTO Estudiante (nombre, documento, codigo, telefono, celular, direccion, Carrera_idCarrera) VALUES "
						+ "("
						+ "'" + estudiante.getNombre() + "', "
						+ "'" + estudiante.getDocumento() + "', "
						+ "'" + estudiante.getCodigo() + "', "
						+ "'" + estudiante.getTelefono() + "', "
						+ "'" + estudiante.getCelular() + "', "
						+ "'" + estudiante.getDireccion() + "', "
						+ estudiante.getCarrera().getIdCarrera() + ")";
	
		try {
			connection = Connector.connect();
			statement = connection.createStatement();
			statement.execute(sqlQuery);
			statement.close();
			connection.close();
			register = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return register;
	}

	@Override
	public Estudiante get(int idEstudiante) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String sqlQuery = "SELECT * FROM Estudiante WHERE idEstudiante=" + idEstudiante;
		
		Estudiante estudiante = null;
		
		try {
			connection = Connector.connect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			resultSet.next();
			
			estudiante = new Estudiante();
			estudiante.setIdEstudiante(resultSet.getInt(1));
			estudiante.setNombre(resultSet.getString(2));
			estudiante.setDocumento(resultSet.getString(3));
			estudiante.setCodigo(resultSet.getString(4));
			estudiante.setTelefono(resultSet.getString(5));
			estudiante.setCelular(resultSet.getString(6));
			estudiante.setDireccion(resultSet.getString(7));
			
			String sqlQuery2 = "SELECT * FROM Carrera WHERE idCarrera=" + resultSet.getInt(8);   
			
			Statement statement2 = connection.createStatement();
			ResultSet resultSet2 = statement2.executeQuery(sqlQuery2);
			resultSet2.next();
			
			Carrera carrera = new Carrera();
			carrera.setIdCarrera(resultSet2.getInt(1));
			carrera.setNombre(resultSet2.getString(2));
			
			resultSet2.close();
			statement2.close();
			
			estudiante.setCarrera(carrera);
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return estudiante;
	}
	
	@Override
	public List<Estudiante> getAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String sqlQuery = "SELECT * FROM Estudiante ORDER BY idEstudiante";
		
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		try {
			connection = Connector.connect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				Estudiante estudiante = new Estudiante();
				estudiante.setIdEstudiante(resultSet.getInt(1));
				estudiante.setNombre(resultSet.getString(2));
				estudiante.setDocumento(resultSet.getString(3));
				estudiante.setCodigo(resultSet.getString(4));
				estudiante.setTelefono(resultSet.getString(5));
				estudiante.setCelular(resultSet.getString(6));
				estudiante.setDireccion(resultSet.getString(7));
				
				String sqlQuery2 = "SELECT * FROM Carrera WHERE idCarrera=" + resultSet.getInt(8);   
				
				Statement statement2 = connection.createStatement();
				ResultSet resultSet2 = statement2.executeQuery(sqlQuery2);
				resultSet2.next();
				
				Carrera carrera = new Carrera();
				carrera.setIdCarrera(resultSet2.getInt(1));
				carrera.setNombre(resultSet2.getString(2));
				
				resultSet2.close();
				statement2.close();
				
				estudiante.setCarrera(carrera);
				estudiantes.add(estudiante);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return estudiantes;
	}

	@Override
	public boolean update(Estudiante estudiante) {
		boolean update = false;
		
		Connection connection = null;
		Statement statement = null;
		
		String sqlQuery = "UPDATE Estudiante SET "
						+ "nombre='" + estudiante.getNombre() + "', "
						+ "documento='" + estudiante.getDocumento() + "', "
						+ "codigo='" + estudiante.getCodigo() + "', "
						+ "telefono='" + estudiante.getTelefono() + "', "
						+ "celular='" + estudiante.getCelular() + "', "
						+ "direccion='" + estudiante.getDireccion() + "', "
						+ "Carrera_idCarrera=" + estudiante.getCarrera().getIdCarrera() + " "
						+ "WHERE idEstudiante=" + estudiante.getIdEstudiante();
		
		try {
			connection = Connector.connect();
			statement = connection.createStatement();
			statement.execute(sqlQuery);
			update = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return update;
	}

	@Override
	public boolean delete(Estudiante estudiante) {
		boolean delete = false;
		
		Connection connection = null;
		Statement statement = null;
		
		String sqlQuery = "DELETE FROM Estudiante WHERE idEstudiante=" + estudiante.getIdEstudiante();
		
		try {
			connection = Connector.connect();
			statement = connection.createStatement();
			statement.execute(sqlQuery);
			delete = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return delete;
	}
}
