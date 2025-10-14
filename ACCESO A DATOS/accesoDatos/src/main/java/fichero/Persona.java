package fichero;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Persona {
	private static final Logger logger = LogManager.getLogger(Persona.class);
	private String nombre;
	private List<Notas> notas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona(String nombre, List<Notas> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", notas=" + notas + "]";
	}

	
	

}
