package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	public static Connection connect() throws SQLException {
		String url = "jdbc:sqlite:path/to/your/database.db";
		return DriverManager.getConnection(url);
	}
}
