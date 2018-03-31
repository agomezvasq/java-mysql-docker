package dao;

import daointerface.ICarreraDAO;
import model.Carrera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Connector;

public class CarreraDAO implements ICarreraDAO {

	@Override
	public boolean register(Carrera carrera) {
		boolean register = false;
		
		Connection connection = null;
		Statement statement = null;
		
		String sqlQuery = "INSERT INTO Carrera (nombre) VALUES "
						+ "("
						+ "'" + carrera.getNombre() + "')";
	
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
	public List<Carrera> getAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String sqlQuery = "SELECT * FROM Carrera ORDER BY idCarrera";
		
		List<Carrera> carreras = new ArrayList<Carrera>();
		
		try {
			connection = Connector.connect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				Carrera carrera = new Carrera();
				carrera.setIdCarrera(resultSet.getInt(1));
				carrera.setNombre(resultSet.getString(2));
				carreras.add(carrera);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return carreras;
	}

	@Override
	public boolean update(Carrera carrera) {
		boolean update = false;
		
		Connection connection = null;
		Statement statement = null;
		
		String sqlQuery = "UPDATE Carrera SET "
						+ "nombre='" + carrera.getNombre() + "' "
						+ "WHERE idCarrera=" + carrera.getIdCarrera();
		
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
	public boolean delete(Carrera carrera) {
		boolean delete = false;
		
		Connection connection = null;
		Statement statement = null;
		
		String sqlQuery = "DELETE FROM Carrera WHERE idCarrera=" + carrera.getIdCarrera();
		
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
