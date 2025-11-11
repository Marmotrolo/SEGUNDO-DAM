package controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.CentroLogistico;
import util.XMLDomBancoAlimento;


public class MainBanco {
	private static final Logger logger= LogManager.getLogger(MainBanco.class);

	public static void main(String[] args) {
		XMLDomBancoAlimento XMLDomBancoAlimento= new XMLDomBancoAlimento();
		
		try {
			List<CentroLogistico> centroLogisticos = XMLDomBancoAlimento.leerCentroLogisticoDesdeXML("bancoAlimentos.xml");
			logger.info(centroLogisticos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
