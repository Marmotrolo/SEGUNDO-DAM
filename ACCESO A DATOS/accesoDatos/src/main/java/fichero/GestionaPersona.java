package fichero;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utiles.ManejaFicherosPersona;

public class GestionaPersona {
	private static final Logger logger = LogManager.getLogger(GestionaPersona.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Notas> listaNotas = new ArrayList<Notas>();
		ManejaFicherosPersona p =new ManejaFicherosPersona();
		try {
			p.cargarLista(
					"C:\\Users\\ManuelParrado\\Desktop\\SEGUNDO_DAM\\ACCESO A DATOS\\accesoDatos\\src\\main\\resources\\carpetapersona\\notitas.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}