package acceso.veterinaria.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.veterinaria.models.Animal;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
 
    List<Animal> findAll();
    Animal findByIdAnimal(Long idAnimal);
    

}
  