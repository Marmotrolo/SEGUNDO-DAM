package acceso.veterinaria.services;

import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import acceso.veterinaria.models.Animal;
import acceso.veterinaria.repository.AnimalRepository;
import exceptions.AnimalNotFoundException;

@Service
public class AnimalServiceImpl implements AnimalService {
	private static final Logger logger = LogManager.getLogger(AnimalServiceImpl.class);

	@Autowired
	private AnimalRepository animalrepository;

	@Override
	public List<Animal> findAllAnimals() {
		return animalrepository.findAll();
	}
   

	public String createAnimal(Animal animal) {
		String respuesta="No se ha podido agregar tontito";
		   try {
		        Animal animalGuardado = animalrepository.save(animal);

		        if (animalGuardado != null ) {
		            respuesta = animalGuardado.getIdAnimal().toString();
		        }
		    } catch (Exception e) {
		    	logger
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
	public Set<Animal> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
