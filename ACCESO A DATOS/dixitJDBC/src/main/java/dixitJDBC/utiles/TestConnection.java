package dixitJDBC.utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			FileInputStream fs = new FileInputStream("src/main/resources/database.properties");
			properties.load(fs);

			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			DriverManager.getConnection(url, user, password);
			System.out.println("Conexión exitosa a MySQL");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}