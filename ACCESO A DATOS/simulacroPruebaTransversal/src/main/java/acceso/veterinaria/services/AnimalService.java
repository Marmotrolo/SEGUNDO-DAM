package acceso.veterinaria.services;


import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import acceso.veterinaria.models.Animal;


@Service
public interface AnimalService {
		List<Animal>  findAllAnimals();
	    Set<Animal> findByTipo(String tipo);
	     String createAnimal(Animal animal) ;
	     Animal updateAnimal(Long idAnimal, Animal animal);
	    
	     Animal findByIdAnimal(Long idAnimal);
}
