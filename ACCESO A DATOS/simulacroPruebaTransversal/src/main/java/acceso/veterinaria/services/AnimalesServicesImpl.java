package acceso.veterinaria.services;

import java.lang.System.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import acceso.veterinaria.controllers.WebController;
import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;
import acceso.veterinaria.repository.AnimalRepository;
import acceso.veterinaria.repository.VacunaRepository;
import exceptions.AnimalNotFoundException;

@Service
public class AnimalesServicesImpl implements AnimalesServices {

    private final WebController webController;

	@Autowired
	private AnimalRepository animalrepository;
	
	@Autowired 
	private VacunaRepository vacunarepository;

    AnimalesServicesImpl(WebController webController) {
        this.webController = webController;
    }

	@Override
	public List<Animal> findAllAnimals() {
		return animalrepository.findAll();
	}
   

	public String createAnimal(Animal animal) {
		String respuesta="No se ha podido agregar ";
		   try {
		        Animal animalGuardado = animalrepository.save(animal);

		        if (animalGuardado != null ) {
		            respuesta = animalGuardado.getIdAnimal().toString();
		        }
		    } catch (Exception e) {
		    	
		    }
		return respuesta;
		
	}
	
	
	public Animal updateAnimal(Long idAnimal, Animal animal) {
		Animal aOriginal= this.findByIdAnimal(idAnimal);
		if(aOriginal != null) {
		aOriginal.setNombre(animal.getNombre());
		}
		else {
			new AnimalNotFoundException(idAnimal);
		}
		return animalrepository.save(aOriginal);
	}
	
	

	// Método para encontrar un producto por ID
    public Animal findByIdAnimal(Long id) {
        Optional<Animal> optionalProduct = animalrepository.findById(id);
        return optionalProduct.orElseThrow(() -> new AnimalNotFoundException(id));
    }




	@Override
	public List<Vacuna> findAllVacunas() {
		// TODO Auto-generated method stub
		return vacunarepository.findAll();
	}

	@Override
	public Vacuna createVacuna(Vacuna vacuna) {
        Vacuna vacunaguardada = vacunarepository.save(vacuna);
		return vacunaguardada;
	}

	@Override
	public Vacuna updateVacuna(Long idVacuna, Vacuna vacuna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vacuna findByIdVacuna(Long idVacuna) {
		Optional<Vacuna> optionalProduct = vacunarepository.findById(idVacuna);
        return optionalProduct.orElseThrow(() -> new AnimalNotFoundException(idVacuna));		
	}

	@Override
	public Animal agregarvacunaaanimal(Long idAnimal, Vacuna vacuna) {

		List<Vacuna>listavacunas=findAllVacunas();
		List<Animal>listanimales=findAllAnimals();

		
		if(!listavacunas.contains(vacuna)) {
			vacunarepository.save(vacuna);
		}
		Animal animal = findByIdAnimal(idAnimal);
	    
	    animal.getVacunas().add(vacuna);
	    vacuna.getAnimales().add(animal);
		
	  

		
		
		return animalrepository.save(animal);
	}




	
}
