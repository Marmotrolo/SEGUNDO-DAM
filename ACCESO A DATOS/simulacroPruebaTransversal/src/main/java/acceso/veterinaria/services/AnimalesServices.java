package acceso.veterinaria.services;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;


@Service
public interface AnimalesServices {
		List<Animal>  findAllAnimals();
	     String createAnimal(Animal animal) ;
	     Animal updateAnimal(Long idAnimal, Animal animal);
	    
	     Animal findByIdAnimal(Long idAnimal);
	     
	     List<Vacuna>  findAllVacunas();
		     Vacuna createVacuna(Vacuna vacuna) ;
		     Vacuna updateVacuna(Long idVacuna, Vacuna vacuna);
		    
		     Vacuna findByIdVacuna(Long idVacuna);
			 Animal agregarvacunaaanimal(Long idAnimal, Vacuna vacuna);
}
