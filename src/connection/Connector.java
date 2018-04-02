package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	public static Connection connect() {
		String host = "127.0.0.1";
		int port = 3306;
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://" + host + ":" + port
					+ "/estudiantes"
					+ "?user=" + username
					+ "&password=" + password
					+"&useSSL=false";
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url);
			if (connection != null) {
				//System.out.println("Connected");
			}
		} catch (SQLException e) {
			System.out.println("Couldn't connect to the database");
			e.printStackTrace();
		}
		
		return connection;
	}
}
