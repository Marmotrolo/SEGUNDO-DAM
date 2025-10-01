package accesoDatosrepaso.libreria.controladores;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class ProbandoLog {
	private static final Logger logger =                LogManager.getLogger(ProbandoLog.class);
	
public static void main(String[] args) {
	logger.debug("Empieza main");
	logger.error("Ocurre excepción"  );

}
}
