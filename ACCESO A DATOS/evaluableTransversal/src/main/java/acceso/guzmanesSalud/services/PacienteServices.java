package acceso.guzmanesSalud.services;


import java.util.List;


import org.springframework.stereotype.Service;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;




@Service
public interface PacienteServices {
		List<Paciente>  findAllPacientes();
		List<ConstantesVitales> findAllConstantesVitales();
	     Paciente crearPaciente(Paciente paciente) ;
	    
	    
	     Paciente findById(Long idPaciente);
	     
	   ConstantesVitales agregarConstantesVitales(Long idPaciente, ConstantesVitales constantes);
}
