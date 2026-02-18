package acceso.guzmanesSalud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.repositories.ConstantesVitalesRepository;
import acceso.guzmanesSalud.repositories.PacienteRepository;

import exceptions.PacienteNotFoundException;
@Service
public class PacienteServicesImpl implements PacienteServices {
	@Autowired
	private PacienteRepository pacienterepository;
	@Autowired
	private ConstantesVitalesRepository constantesvitalesrepository;
	
	

	

	@Override
	public List<Paciente> findAllPacientes() {
		// TODO Auto-generated method stub
		return pacienterepository.findAll();
	}

	@Override
	public Paciente crearPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienterepository.save(paciente);
	}

	@Override
	public Paciente findById(Long idPaciente) {
		  Optional<Paciente> optionalPaciente = pacienterepository.findById(idPaciente);
	        return optionalPaciente.orElseThrow(() -> new PacienteNotFoundException(idPaciente));
	}

	@Override
	public ConstantesVitales agregarConstantesVitales(Long idPaciente, ConstantesVitales constantes) {
	    try {
	        // 1. Buscamos al paciente
	        Paciente paciente = findById(idPaciente);

	        // 2. IMPORTANTE: Le asignamos el paciente a las constantes ANTES de guardar.
	        // Esto evita el error de "null property".
	        constantes.setPaciente(paciente);

	        // 3. Tu lógica: Si no están en la base de datos, las guardamos.
	        List<ConstantesVitales> todas = findAllConstantesVitales();
	        if (!todas.contains(constantes)) {
	            constantesvitalesrepository.save(constantes);
	        }

	        // 4. Añadimos la constante al paciente y guardamos el paciente.
	        paciente.getConstantesVitales().add(constantes);
	        pacienterepository.save(paciente);

	    } catch (PacienteNotFoundException e) {
	        // Si no hay paciente, no hacemos nada
	    }

	    return constantes;
	}

	@Override
	public List<ConstantesVitales> findAllConstantesVitales() {
		 return constantesvitalesrepository.findAll();
	}
}
