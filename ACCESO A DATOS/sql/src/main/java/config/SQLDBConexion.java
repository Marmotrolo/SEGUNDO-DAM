package config;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
//conectar base de datos con lo que tengamos
public class SQLDBConexion {
	private static final Logger logger = LogManager.getLogger(SQLDBConexion.class);
	private SQLDBConexion db;

	public SQLDBConexion() {
		Propiedades propiedades;
		try {
			propiedades = new Propiedades("JDBC.properties");
			String ruta = propiedades.get("JDBC.uri");
			String baseDatos = propiedades.get("JDBC.database");
			MongoClient client = MongoClients.create(ruta);
			this.db = client.getDatabase(baseDatos);
			logger.debug("Conectado a la BD: " + db.getName());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}	}

	public MongoDatabase getDb() {
		return db;
	}}
