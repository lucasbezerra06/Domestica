package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String urldb = "jdbc:mariadb://localhost:3306/selecoes?allowMultiQueries=true";
			return DriverManager.getConnection( "jdbc:mariadb://localhost:3306/diaristas_serv", "root", "");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
